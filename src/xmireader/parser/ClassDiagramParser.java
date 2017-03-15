/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.parser;

import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.reasoner.rulesys.builtins.GE;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import xmireader.XMIConstants;
import xmireader.model.classdiagram.ClassDiagram;
import xmireader.model.classdiagram.element.*;
import xmireader.model.generic.Model;

/**
 *
 * @author kane
 */
public class ClassDiagramParser extends GenericParser {

    @Override
    public Model parse(Document d) {
        ClassDiagram cd = new ClassDiagram();
        initializeNodes(d);
        parseClasses(d, cd);
        //initializeNodes(d);
        //parseInterfaces(d, cd);
        initializeNodes(d);
        parseAssociations(d, cd);
        initializeNodes(d);
        parseGeneralizations(d, cd);


        return cd;
    }

    private void parseClasses(Document d, ClassDiagram cd) throws DOMException {
        System.out.println("==== parseClasses ====");
        //List<Node> classes = getNodesByXMIType(XMIConstants.XMI_UML_CLASS_TYPE);
        List<Node> classes = getClassNodesByName(XMIConstants.XMI_UML_CLASS_NODE);
        for (Node c : classes) {
            String name = c.getAttributes().getNamedItem("name").getNodeValue();
            String id = c.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
            CDClass x = new CDClass(id, name);
            List<Method> methods = parseMethods(c);
            List<Attribute> attributes = parseAttributes(c);
            x.setMethods(methods);
            x.setAttributes(attributes);
            cd.addClass(x);
        }

    }


    private void parseInterfaces(Document d, ClassDiagram cd) throws DOMException {
        System.out.println("==== parseInterfaces ====");
        List<Node> interfaces = getNodesByXMIType(XMIConstants.XMI_UML_INTERFACE_TYPE);
        for (Node c : interfaces) {
            String name = c.getAttributes().getNamedItem("name").getNodeValue();
            String id = c.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
            Interface x = new Interface(id, name);
            List<Method> methods = parseMethods(c);
            x.setMethods(methods);
            cd.addInterface(x);
        }
    }

    private <T extends Element> List<T> parseGeneric(Node c, GenericElementParser gep) {
        List<T> elements = new ArrayList<T>();
        setNode(c);
        List<Node> nodes = getNodesByName(gep.getNodeName());
        for (Node n : nodes) {
            elements.add((T) gep.getElement(n));
        }
        return elements;
    }

    private <T extends Element> T parseGenericElement(Node c, GenericElementParser gep) {

        setNode(c);
        System.out.println("parseGenericElement gep.getNodeName(): " + gep.getNodeName());
        List<Node> nodes = getNodesByName(gep.getNodeName());
        for (Node n : nodes) {
            System.out.println("parseGenericElement: " + n.getNodeName());
            if (n.getNodeName().equals(gep.getNodeName())) {
                System.out.println("parseGenericElement return: " + n);
                return gep.getElement(n);
            }

        }
        return null;
    }


    private List<Attribute> parseAttributes(Node c) {
        return parseGeneric(c, new AttributeParser());
    }

    private List<Method> parseMethods(Node c) {
        return parseGeneric(c, MethodParser.getInstance());
    }

    private void parseAssociations(Document d, ClassDiagram cd) {
        System.out.println("==== parseAssociations ====");
        List<Node> associations = getNodesByName(XMIConstants.XMI_UML_ASSOCIATION_NODE);
        for (Node a : associations) {
            String name = a.getAttributes().getNamedItem("name").getNodeValue();
            String id = a.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();

            Association association = new Association(id, name);
            List<AssociationEnd> associationEnds = parseAssociationEnd(a);
            String assname = null;
            for(AssociationEnd associationEnd : associationEnds){

                switch (associationEnd.getType()) {
                    case ASSOC_AGGREGATION:
                        association.setType(associationEnd.getType());
                        if(associationEnd.isSource) {
                            association.setSourceID(associationEnd.refID);
                        } else {
                            association.setDestinationID(associationEnd.refID);
                        }
                        if (assname == null) {
                            assname = associationEnd.getName();
                        } else {
                            assname += " " + associationEnd.getName();
                        }

                        break;
                    case ASSOC_NONE:
                        if (association.getSourceID() == null) {
                            association.setSourceID(associationEnd.refID);
                        } else {
                            association.setDestinationID(associationEnd.refID);
                        }
                        break;
                    default:
                            break;
                }
            }
            if (assname != null) {
                association.setName(assname);
            }
            cd.addRelationship(association);
        }
    }

    private void parseGeneralizations(Document d, ClassDiagram cd) {
        System.out.println("==== parseGeneralizations ====");
        List<Node> generalizations = getNodesByName(XMIConstants.XMI_UML_GENERALIZATION_NODE);

        for (Node a : generalizations) {
            if(a.getAttributes().getNamedItem(XMIConstants.XMI_ID) != null) {

                String id = a.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
                System.out.println("parseGeneralizations id: " + id);
                Generalization generalization = new Generalization(id, "");

                GeneralizationEnd generalizationEndChild = parseGeneralizationEnd(a, GeneralizationNodeType.CHILD);
                GeneralizationEnd generalizationEndParent = parseGeneralizationEnd(a, GeneralizationNodeType.PARENT);
                generalization.setSourceID(generalizationEndParent.refID);
                generalization.setDestinationID(generalizationEndChild.refID);

                cd.addRelationship(generalization);
            }

        }
    }


    private GeneralizationEnd parseGeneralizationEnd(Node a, GeneralizationNodeType nodeType){
        return parseGenericElement(a, new GeneralizationEndParser(nodeType));
    }
    private List<AssociationEnd> parseAssociationEnd(Node a){
        return parseGeneric(a, new AssosiationEndParser());
    }
}

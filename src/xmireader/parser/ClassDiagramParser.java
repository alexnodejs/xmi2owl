/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.parser;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import xmireader.XMIConstants;
import xmireader.model.classdiagram.ClassDiagram;
import xmireader.model.classdiagram.RelationshipType;
import xmireader.model.generic.Model;
import xmireader.model.classdiagram.element.CDClass;
import xmireader.model.classdiagram.element.Method;
import xmireader.model.classdiagram.element.Attribute;
import xmireader.model.classdiagram.element.Element;
import xmireader.model.classdiagram.element.Interface;

import xmireader.model.classdiagram.element.Association;
import xmireader.model.classdiagram.element.AssociationEnd;
import xmireader.model.usecasediagram.element.OwnedEnd;

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
        initializeNodes(d);
        //parseInterfaces(d, cd);
        initializeNodes(d);
        parseAssociations(d, cd);
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
                        if(associationEnd.getSource()) {
                            association.setSourceID(associationEnd.getRelatedClassID());
                        } else {
                            association.setDestinationID(associationEnd.getRelatedClassID());
                        }
                        if (assname == null) {
                            assname = associationEnd.getName();
                        } else {
                            assname += " " + associationEnd.getName();
                        }

                        break;
                    case ASSOC_NONE:
                        if (association.getSourceID() == null) {
                            association.setSourceID(associationEnd.getRelatedClassID());
                        } else {
                            association.setDestinationID(associationEnd.getRelatedClassID());
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

    private List<AssociationEnd> parseAssociationEnd(Node a){
        return parseGeneric(a, new AssosiationEndParser());
    }
}

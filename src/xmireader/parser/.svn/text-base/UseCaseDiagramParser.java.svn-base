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
import xmireader.model.generic.GenericElement;
import xmireader.model.usecasediagram.UseCaseDiagram;
import xmireader.model.generic.Model;
import xmireader.model.usecasediagram.element.*;
/**
 *
 * @author pUf
 */
public class UseCaseDiagramParser extends GenericParser {

    @Override
    public Model parse(Document d) {
        UseCaseDiagram ucd = new UseCaseDiagram();
        initializeNodes(d);
        parseUseCases(d, ucd);
        initializeNodes(d);
        parseActors(d, ucd);
        initializeNodes(d);
        parseAssociations(d, ucd);

        return ucd;
    }

    private void parseUseCases(Document d, UseCaseDiagram ucd) throws DOMException {
        List<Node> usecases = getNodesByXMIType(XMIConstants.XMI_UML_USECASE_TYPE);
        for (Node uc : usecases) {
            String name = uc.getAttributes().getNamedItem("name").getNodeValue();
            String id = uc.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
            UseCase x = new UseCase(id, name);
            List<Include> includes = parseIncludes(uc);
            List<Extend> xtends = parseExtends(uc);
            List<ExtensionPoint> extPoints = parseExtPoints(uc);
            x.setIncludes(includes);
            x.setXtends(xtends);
            x.setExtensionPoints(extPoints);
            ucd.addElement(x);
        }
    }

    private void parseActors(Document d, UseCaseDiagram ucd) throws DOMException {
        List<Node> actors = getNodesByXMIType(XMIConstants.XMI_UML_ACTOR_TYPE);
        for (Node a : actors) {
            String name = a.getAttributes().getNamedItem("name").getNodeValue();
            String id = a.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
            Actor x = new Actor(id, name);
            List<Generalization> parentsID = parseInheritance(a);
            x.setGeneralizations(parentsID);
            ucd.addElement(x);
        }
    }


    private void parseAssociations(Document d, UseCaseDiagram ucd) throws DOMException {
        List<Node> associations = getNodesByXMIType(XMIConstants.XMI_UML_ASSOCIATION_TYPE);
        for(Node a : associations){
            String name = "temp";
            String id = a.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
            Association x = new Association(id, name);
            List<OwnedEnd> oes = parseOwnedEnd(a);
            for(OwnedEnd oe : oes){
                if(!oe.getIsSource()){
                    x.setTarget(oe.getConnectsTo());
                    x.setName(oe.getName());
                }else x.setSource(oe.getConnectsTo());
            }
            ucd.addElement(x);
        }
    }

    private <T extends Element> List<T> parseGeneric(Node a, GenericElementParser gep) {
        List<T> elements = new ArrayList<T>();
        setNode(a);
        List<Node> nodes = getNodesByName(gep.getNodeName());
        for (Node n : nodes) {
            elements.add((T) gep.getElement(n));
        }
        return elements;
    }

    private List<Generalization> parseInheritance(Node a) {
        return parseGeneric(a, new SupportParser());
    }

    private List<Include> parseIncludes(Node uc) {
        return parseGeneric(uc, new SupportParser("include", "addition", 2));
    }

    private List<Extend> parseExtends(Node uc) {
        return parseGeneric(uc, new SupportParser("extend", "extendedCase", 3));
    }

    private List<ExtensionPoint> parseExtPoints(Node uc) {
        return parseGeneric(uc, new SupportParser("extensionPoint","name", 4));
    }

    private List<OwnedEnd> parseOwnedEnd(Node a){
        return parseGeneric(a, new OwnedEndParser());
    }
}


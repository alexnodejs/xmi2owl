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
import xmireader.model.generic.Model;
import xmireader.model.classdiagram.element.CDClass;
import xmireader.model.classdiagram.element.Method;
import xmireader.model.classdiagram.element.Attribute;
import xmireader.model.classdiagram.element.Element;
import xmireader.model.classdiagram.element.Interface;

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
        parseInterfaces(d, cd);
        initializeNodes(d);
        parseRelations(d, cd);
        return cd;
    }

    private void parseClasses(Document d, ClassDiagram cd) throws DOMException {
        List<Node> classes = getNodesByXMIType(XMIConstants.XMI_UML_CLASS_TYPE);
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

    private void parseRelations(Document d, ClassDiagram cd) {
        //
    }
}

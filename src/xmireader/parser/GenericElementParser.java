/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.parser;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import xmireader.XMIConstants;
import xmireader.model.generic.GenericElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author kane
 */
public abstract class GenericElementParser {

    private Queue<Node> q = new LinkedList<Node>();

    public abstract String getNodeName();

    public abstract <T extends GenericElement> T getElement(Node n);

    public abstract Class getReturnedClass();

    protected String getAttributeValue(Node n, String attributeName) throws DOMException {
       String name = "";
       if(n.getAttributes() != null && n.getAttributes().getNamedItem(attributeName) != null)
            name =  n.getAttributes().getNamedItem(attributeName).getNodeValue();
       return name;
    }

    public String getRelatedClassByNodeName(Node node, String name){

        for(int i = 0; i < node.getChildNodes().getLength(); i++){
            q.add(node.getChildNodes().item(i));
        }

        if (node.getNodeName().equals(name)) {
            if(node.getAttributes().getNamedItem(XMIConstants.XMI_IDREF)!= null) {
                String id = node.getAttributes().getNamedItem(XMIConstants.XMI_IDREF).getNodeValue();
                System.out.println("getRelatedClassNodesByName Found class with IDREF: " + id);
                return id;
            }
        }
        else {
            Node n = getNode();
            return getRelatedClassByNodeName(n, name);
        }
        System.out.println("getRelatedClassNodesByName return");
        return null;
    }

    protected Node getNode() {
        return q.poll();
    }
}

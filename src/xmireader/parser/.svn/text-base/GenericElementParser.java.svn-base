/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.parser;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import xmireader.model.generic.GenericElement;

/**
 *
 * @author kane
 */
public abstract class GenericElementParser {


    public abstract String getNodeName();

    public abstract <T extends GenericElement> T getElement(Node n);

    public abstract Class getReturnedClass();

    protected String getAttributeValue(Node n, String attributeName) throws DOMException {
       String name = "";
       if(n.getAttributes() != null && n.getAttributes().getNamedItem(attributeName) != null)
            name =  n.getAttributes().getNamedItem(attributeName).getNodeValue();
       return name;
    }
}

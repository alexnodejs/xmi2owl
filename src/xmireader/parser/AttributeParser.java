/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.parser;

import org.w3c.dom.Node;
import xmireader.XMIConstants;
import xmireader.model.classdiagram.element.Attribute;

/**
 * @author kane
 */
public class AttributeParser extends GenericElementParser {

    public String getNodeName() {
        return "ownedAttribute";
    }

    public Attribute getElement(Node n) {
        String name = getAttributeValue(n, "name");
        String id = getAttributeValue(n, XMIConstants.XMI_ID);
        return new Attribute(id, name);
    }

    public Class getReturnedClass() {
        return Attribute.class;
    }
}

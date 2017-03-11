/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.parser;
import org.w3c.dom.Node;
import xmireader.XMIConstants;
import xmireader.model.usecasediagram.element.OwnedEnd;
/**
 *
 * @author pUf
 */
public class OwnedEndParser extends GenericElementParser{
    public String getNodeName() {
        return "ownedEnd";
    }

    public OwnedEnd getElement(Node n) {
        Boolean isSource = false;
        String name = getAttributeValue(n, "name");
        String id = getAttributeValue(n, XMIConstants.XMI_ID);
        String id2 = getAttributeValue(n, "type");
        if (getAttributeValue(n,"name").equals("src")) isSource = true;
        return new OwnedEnd(id, name, id2, isSource);
    }

    public Class getReturnedClass() {
        return OwnedEnd.class;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.parser;

import org.w3c.dom.Node;
import xmireader.XMIConstants;
import xmireader.model.usecasediagram.element.Generalization;
import xmireader.model.usecasediagram.element.Extend;
import xmireader.model.usecasediagram.element.ExtensionPoint;
import xmireader.model.usecasediagram.element.Include;
import xmireader.model.usecasediagram.element.Element;
/**
 *
 * @author pUf
 */
public class SupportParser extends GenericElementParser {
    private String gnn = "generalization";
    private String ge = "general";
    private int x = 1;
    public SupportParser(String gnn, String ge, int x){
        this.gnn = gnn;
        this.ge = ge;
        this.x = x;
    }
    public SupportParser(){
        
    }

    public String getNodeName() {
        return gnn;
    }

    public Element getElement(Node n) {
        String value = getAttributeValue(n, ge);
        String id = getAttributeValue(n, XMIConstants.XMI_ID);
        switch(x){
            case 1:return new Generalization(id, value);
            case 2:return new Include(id, value);
            case 3:return new Extend(id,value);
            case 4:return new ExtensionPoint(id, value);
            default:return null;
        }
    }

    public Class getReturnedClass() {
        switch(x){
            case 1: return Generalization.class;
            case 2: return Include.class;
            case 3: return Extend.class;
            case 4: return ExtensionPoint.class;
            default: return Element.class;
        }
    }

}

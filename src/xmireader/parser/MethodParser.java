/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.parser;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xmireader.XMIConstants;
import xmireader.model.classdiagram.element.Method;
import xmireader.model.classdiagram.element.Parameter;
import xmireader.model.classdiagram.element.VisibilityKind;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kane
 */
public class MethodParser extends GenericElementParser {
    
    GenericElementParser methodParameterParser;

    public MethodParser(GenericElementParser gep){
        methodParameterParser = gep;
    }

    public Method getElement(Node n) {
        String name = getAttributeValue(n, "name");
        String id = getAttributeValue(n, XMIConstants.XMI_ID);
        Method m = new Method(id, name);
        if(n.hasAttributes() && n.getAttributes().getNamedItem("visibility") != null)
            m.setVisibility(VisibilityKind.getVisibilityKind(n.getAttributes().getNamedItem("visibility").getNodeValue()));
        else
            m.setVisibility(VisibilityKind.PACKAGE);
        //find

        List<Parameter> parameters = new ArrayList<Parameter>();
        if(n.hasChildNodes()){
            NodeList nl = n.getChildNodes();
            for(int i=0;i<nl.getLength();i++){
                Node x = nl.item(i);
                if(x.getNodeName().equals("ownedParameter"))
                    parameters.add(methodParameterParser.<Parameter>getElement(x));
            }

           m.setParameters(parameters);
        }
        return new Method(id, name);
    }

    public String getNodeName() {
        return "ownedOperation";
    }

    public Class getReturnedClass() {
        return Method.class;
    }

    public static MethodParser getInstance(){
        MethodParser mp = new MethodParser(new MethodParameterParser());
        return mp;
    }
}

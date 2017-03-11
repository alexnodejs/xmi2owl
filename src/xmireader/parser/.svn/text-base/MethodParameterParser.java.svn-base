/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.parser;

import org.w3c.dom.Node;
import xmireader.model.classdiagram.element.Parameter;
import xmireader.model.classdiagram.element.ParameterDirectionKind;
import xmireader.model.generic.GenericElement;

/**
 *
 * @author kane
 */
public class MethodParameterParser extends GenericElementParser {

    @Override
    public String getNodeName() {
        return "ownedParameter";
    }

    @Override
    public Parameter getElement(Node n) {
        String id = getAttributeValue(n, "");
        return new Parameter(null, null, "sdfasdf", ParameterDirectionKind.IN);
    }

    @Override
    public Class getReturnedClass() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static MethodParameterParser getInstance(){
        return new MethodParameterParser();
    }
}

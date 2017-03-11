/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.activitydiagram.element;

/**
 *
 * @author pUf
 */
public class Condition extends Edge{
    public Condition(String id, String name, String in, String out){
        super(id, name, in, out);

    }
@Override
public String toString(){
    StringBuffer sb = new StringBuffer();
    sb.append("\nCondition: ").
            append("\""+getName()+"\"").
            append(", from decision id: ").
            append(getSource()).
            append(", to node id: ").
            append(getTarget());

         return sb.toString();
    }
}

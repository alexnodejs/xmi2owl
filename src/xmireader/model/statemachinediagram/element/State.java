/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.statemachinediagram.element;

/**
 *
 * @author pUf
 */
public class State extends Element{
    public State(String id, String name){
        super(id, name);
    }
@Override
public String toString() {
    StringBuffer sb= new StringBuffer();
    sb.append("\nState: ").
            append("\""+getName()+"\"").
            append(", id: ").
            append(getId());
    return sb.toString();
}
}

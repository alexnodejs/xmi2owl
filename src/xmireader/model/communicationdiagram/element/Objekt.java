/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.communicationdiagram.element;

/**
 *
 * @author pUf
 */
public class Objekt extends Element{
    public Objekt(String id, String name){
        super(id, name);
    }
@Override
public String toString() {
    StringBuffer sb= new StringBuffer();
    sb.append("\nObject: ").
            append("\""+getName()+"\"").
            append(", id: ").
            append(getId());
    return sb.toString();
}
}

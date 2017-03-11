/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.classdiagram.element;

/**
 *
 * @author kane
 */
public class Interface extends Entity {
    public Interface(String id, String name){
        super(id, name);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Interface: ").
                append(getName()).
                append(", id: ").
                append(getId()).
                append("\n");

        sb.append("\tMethods:\n");
        for (Method a : getMethods()) {
            sb.append("\t\t")
                    .append(a.toString())
                    .append("\n");
        }
        return sb.toString();
    }
}

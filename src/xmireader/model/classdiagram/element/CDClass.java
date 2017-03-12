/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmireader.model.classdiagram.element;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kane
 */
public class CDClass extends Entity {

    private List<Attribute> attributes;
    

    public CDClass(String id, String name) {
        super(id, name);
        attributes = new ArrayList<Attribute>();
        setMethods(new ArrayList<Method>());
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Class: ").
                append(getName()).
                append(", id: ").
                append(getId()).
                append("\n");
        sb.append("\tAttributes:\n");
        for (Attribute a : getAttributes()) {
            sb.append("\t\t")
                    .append(a.getName().toString())
                    .append("\n");
        }

        sb.append("\tMethods:\n");
        for (Method a : getMethods()) {
            sb.append("\t\t")
                    .append(a.toString())
                    .append("\n");
        }
        return sb.toString();
    }

    /**
     * @return the attributes
     */
    public List<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}

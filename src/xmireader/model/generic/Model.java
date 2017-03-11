/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.generic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kane
 */
public abstract class Model {
    protected HashMap<String, GenericElement> elements;
    //protected ArrayList<Relationship> relationships;

    /**
     * @return the elements
     */
    public HashMap<String, GenericElement> getElements() {
        return elements;
    }

    /**
     * @param elements the elements to set
     */
    public void setElements(HashMap<String,GenericElement> elements) {
        this.elements = elements;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(GenericElement e:elements.values()){
            sb.append(e.toString());
        }
        return sb.toString();
    }
}

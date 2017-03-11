/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.classdiagram.element;

import java.util.List;
import xmireader.model.classdiagram.*;

/**
 *
 * @author kane
 */
public abstract class Entity extends Type{
    private List<Method> methods;
    public Entity(String id, String name){
        super(id, name);
    }

    /**
     * @return the methods
     */
    public List<Method> getMethods() {
        return methods;
    }

    /**
     * @param methods the methods to set
     */
    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }


}

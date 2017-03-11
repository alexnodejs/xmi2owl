/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.generic;

import xmireader.model.classdiagram.element.Element;

/**
 *
 * @author kane
 */
public abstract class Relationship  extends Element {
    private GenericElement source;
    private GenericElement destination;

    public Relationship(String id, String name){
        super(id, name);
    }
    /**
     * @return the source
     */
    public GenericElement getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(GenericElement source) {
        this.source = source;
    }

    /**
     * @return the destination
     */
    public GenericElement getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(GenericElement destination) {
        this.destination = destination;
    }
}

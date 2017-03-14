/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.classdiagram;

import xmireader.model.classdiagram.element.Element;
import xmireader.model.generic.GenericElement;

/**
 *
 * @author kane
 */
public class Relationship extends Element {
//  private GenericElement source;
//  private GenericElement destination;

    private String sourceID;
    private String destinationID;
    private RelationshipType type;

    public RelationshipType getType() {
        return type;
    }


    public void setType(RelationshipType type) {
        this.type = type;
    }

    public String getSourceID() {
        return sourceID;
    }

    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

    public String getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(String destinationID) {
        this.destinationID = destinationID;
    }

    public Relationship(){
        super("", "");
    }

    public Relationship(String id, String name){
        super(id, name);
    }
    /**
     * @return the source
     */
//    public GenericElement getSource() {
//        return source;
//    }

    /**
     * @param source the source to set
     */
 //   public void setSource(GenericElement source) {
//        this.source = source;
//    }

    /**
     * @return the destination
     */
//    public GenericElement getDestination() {
//        return destination;
//    }

    /**
     * @param destination the destination to set
     */
//    public void setDestination(GenericElement destination) {
//        this.destination = destination;
//    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.classdiagram.element;

import xmireader.model.classdiagram.*;

/**
 *
 * @author kane
 */
public class Association extends Relationship {

    public Association(String id, String name){
        super(id, name);
        setType(RelationshipType.ASSOC_AGGREGATION);
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("\nAssociation: ").
                append("\""+getName()+"\"").
                append(", id: ").
                append(getId());
        sb.append("\n\tFrom: ").
                append(getSourceID());
        sb.append("\n\tTo: ").
                append(getDestinationID());
        return sb.toString();
    }
}

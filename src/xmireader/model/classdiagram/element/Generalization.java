package xmireader.model.classdiagram.element;

import xmireader.model.classdiagram.Relationship;
import xmireader.model.classdiagram.RelationshipType;

/**
 * Created by svitlanamoiseyenko on 3/15/17.
 */
public class Generalization extends Relationship {

    public Generalization(String id, String name){
        super(id, name);

        setType(RelationshipType.GENERALIZATION);
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("\nGeneralizaition: ").
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

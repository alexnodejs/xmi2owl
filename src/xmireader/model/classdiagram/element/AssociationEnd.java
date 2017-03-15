package xmireader.model.classdiagram.element;


import xmireader.model.classdiagram.Relationship;
import xmireader.model.classdiagram.RelationshipType;

/**
 * Created by svitlanamoiseyenko on 3/14/17.
 */
public class AssociationEnd extends Element {

    public String refID;
    public Boolean isSource = false;

    private RelationshipType type;
    public RelationshipType getType() {
        return type;
    }


    public AssociationEnd(String id, String name, String refID, String type){
        super(id, name);
        this.refID = refID;

        this.type = RelationshipType.getType(type);
        if(type.toString().equals(RelationshipType.ASSOC_AGGREGATION.toString())) {
             this.isSource = true;
        }
    }

}

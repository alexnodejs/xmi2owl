package xmireader.model.classdiagram.element;


import xmireader.model.classdiagram.Relationship;
import xmireader.model.classdiagram.RelationshipType;

/**
 * Created by svitlanamoiseyenko on 3/14/17.
 */
public class AssociationEnd extends Element {

    private String relatedClassID;



    private Boolean isSource = false;

    private RelationshipType type;
    public RelationshipType getType() {
        return type;
    }
    public Boolean getSource() {
        return isSource;
    }

    public AssociationEnd(String id, String name, String relatedClassID, String type){
        super(id, name);
        this.relatedClassID = relatedClassID;

        this.type = RelationshipType.getType(type);
        System.out.println("type: " + this.type);
        if(type.toString().equals(RelationshipType.ASSOC_AGGREGATION.toString())) {
            System.out.println("AAA type: " + this.type);
             this.isSource = true;
        }
    }

    public String getRelatedClassID() {
        return relatedClassID;
    }

}

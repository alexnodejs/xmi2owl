package xmireader.model.classdiagram.element;

import xmireader.model.classdiagram.RelationshipType;

/**
 * Created by svitlanamoiseyenko on 3/15/17.
 */
public class GeneralizationEnd extends Element {

    public Boolean isSource = false;
    public String refID;

    public GeneralizationEnd(String refID, boolean isSource){
        super("", "");
        this.refID = refID;
        this.isSource = isSource;
    }
}

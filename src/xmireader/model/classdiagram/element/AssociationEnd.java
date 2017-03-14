package xmireader.model.classdiagram.element;



/**
 * Created by svitlanamoiseyenko on 3/14/17.
 */
public class OwnedEnd extends Element {
    private Boolean isSource;
    private String connectsTo;
    public OwnedEnd(String id, String name, String id2, Boolean is){
        super(id, name);
        this.isSource = is;
        this.connectsTo = id2;
    }

    public Boolean getIsSource() {
        return isSource;
    }

    public void setIsSource(Boolean isSource) {
        this.isSource = isSource;
    }

    public String getConnectsTo() {
        return connectsTo;
    }

    public void setConnectsTo(String connectsTo) {
        this.connectsTo = connectsTo;
    }

}

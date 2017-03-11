/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.usecasediagram.element;
/**
 *
 * @author pUf
 */
public class Association extends Element{
    private String source;
    private String target;
    public Association(String id, String name){
        super(id, name);
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("\nAssociation: ").
                append("\""+getName()+"\"").
                append(", id: ").
                append(getId());
        sb.append("\n\tFrom: ").
                append(getSource());
        sb.append("\n\tTo: ").
                append(getTarget());
        return sb.toString();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
   
}

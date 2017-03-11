/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.statemachinediagram.element;

/**
 *
 * @author pUf
 */
public class Transition extends Element{
    private String source;
    private String target;
    public Transition(String id, String name, String source, String target){
        super(id, name);
        this.source = source;
        this.target = target;
    }
@Override
public String toString() {
    StringBuffer sb= new StringBuffer();
    sb.append("\nTransition id: ").
            append(getId()).
            append("\n\t from: ").
            append(getSource()).
            append("\n\t to: ").
            append(getTarget());
    return sb.toString();
}
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

}

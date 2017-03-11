/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.activitydiagram.element;

/**
 *
 * @author pUf
 */
public class Edge extends Element{
    private String source;
    private String target;
    public Edge(String id, String name, String source, String target){
        super(id, name);
        this.source = source;
        this.target = target;
    }
@Override
public String toString(){
    StringBuffer sb = new StringBuffer();
    sb.append("\nEdge id: ").
            append(getId()).
            append("\n\t source: ").
            append(getSource()).
            append("\n\t target: ").
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

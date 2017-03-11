/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.activitydiagram.element;

/**
 *
 * @author pUf
 */
public class InitialNode extends Element{
    private String outgoing;
    public InitialNode(String id, String name, String out){
        super(id, name);
        this.outgoing = out;
    }

    @Override
public String toString(){
    StringBuffer sb = new StringBuffer();
    sb.append("\nInitial Node id: ").
            append(getId()).
            append(", outogoing edge id: ").
            append(getOutgoing());

         return sb.toString();
    }

    public String getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(String outgoing) {
        this.outgoing = outgoing;
    }

}

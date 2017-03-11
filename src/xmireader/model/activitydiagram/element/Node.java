/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.activitydiagram.element;

/**
 *
 * @author pUf
 */
public class Node extends Element {
    private String[] incoming;
    private String[] outgoing;
    public Node(String id, String name, String[] in, String[] out){
        super(id,name);
        this.incoming = in;
        this.outgoing = out;
    }

    public String[] getIncoming() {
        return incoming;
    }

    public void setIncoming(String[] incoming) {
        this.incoming = incoming;
    }

    public String[] getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(String[] outgoing) {
        this.outgoing = outgoing;
    }
      
}

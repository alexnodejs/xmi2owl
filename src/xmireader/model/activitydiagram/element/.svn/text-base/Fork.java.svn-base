/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.activitydiagram.element;

/**
 *
 * @author pUf
 */
public class Fork extends Node{
    public Fork(String id, String name,String[] in, String[] out){
        super(id, name, in, out);
    }
    @Override
public String toString(){
    StringBuffer sb = new StringBuffer();
    sb.append("\nFork id: ").
            append(getId()).
            append("\n\t incoming edge id: ").
            append(getOutgoing()[0]);
                 sb.append("\n\t outgoing edges id: ");
                 for (String s : getIncoming()){
                    sb.append(s+" ");
                 }
         return sb.toString();
    }

}

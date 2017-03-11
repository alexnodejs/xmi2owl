/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.activitydiagram.element;

/**
 *
 * @author pUf
 */
public class Merge extends Node{
    public Merge(String id, String name, String[] in, String[] out){
        super(id, name, in, out);
    }
    @Override
public String toString(){
    StringBuffer sb = new StringBuffer();
    sb.append("\nMerge Node: ").
            append("\""+getName()+"\"").
            append(", id: ").
            append(getId()).
            append("\n\t incoming edge id: ");
                 for (String s : getIncoming()){
                    sb.append(s+" ");
                 }
                 sb.append("\n\t outgoing edge id: ");
                 for (String s : getOutgoing()){
                    sb.append(s+" ");
                 }
         return sb.toString();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.activitydiagram.element;

/**
 *
 * @author pUf
 */
public class Join extends Node{
    public Join(String id, String name,String[] in, String[] out){
        super(id, name, in, out);
    }
    @Override
public String toString(){
    StringBuffer sb = new StringBuffer();
    sb.append("\nJoin id: ").
            append(getId()).
            append("\n\t incoming edges id: ");
                 for (String s : getIncoming()){
                    sb.append(s+" ");
                 }
                 sb.append("\n\t outgoing edge id: ").
                 append(getOutgoing()[0]);

         return sb.toString();
    }
}

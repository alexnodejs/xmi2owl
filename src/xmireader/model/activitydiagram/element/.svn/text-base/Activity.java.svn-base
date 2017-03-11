/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.activitydiagram.element;

/**
 *
 * @author pUf
 */
public class Activity extends Node {
     public Activity(String id, String name, String[] in, String[] out) {
        super(id, name, in, out);
    }
     @Override
     public String toString(){
         StringBuffer sb = new StringBuffer();
         sb.append("\nActivity: ").
                 append("\""+getName()+"\"").
                 append(", id: ").
                 append(getId()).
                 append("\n\t incoming edge id: ").
                 append(getIncoming()[0]).
                 append("\n\t outgoing edge id: ").
                 append(getOutgoing()[0]);
         return sb.toString();
     }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.usecasediagram.element;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author pUf
 */
public class Actor extends Type {

    private List<Generalization> parentsID;
    
     public Actor(String id, String name) {
        super(id, name);
    }
@Override
public String toString() {
    StringBuffer sb= new StringBuffer();
    sb.append("\nActor: ").
            append("\""+getName()+"\"").
            append(", id: ").
            append(getId());
            for (Generalization g : getGeneralizations()){
                sb.append("\n\t inherited from: ").
                append(g.getParentID());
            }
    return sb.toString();
}

public void setGeneralizations(List<Generalization> g){
    this.parentsID = g;
}

public List<Generalization> getGeneralizations(){
    return parentsID;
}
}

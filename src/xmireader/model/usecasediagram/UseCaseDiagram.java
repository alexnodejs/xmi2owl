/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.usecasediagram;

import xmireader.model.usecasediagram.element.Element;
import java.util.HashMap;
import xmireader.model.generic.GenericElement;
import xmireader.model.generic.Model;

/**
 *
 * @author pUf
 */
public class UseCaseDiagram extends Model {
    //Map<String,GenericElement> elements;
   // Map<String,Class> classes;
    public UseCaseDiagram(){
        elements = new HashMap<String,GenericElement>();
        //TODO: relations
    }

    

    public void addElement(Element element){
        elements.put(element.getId(), element);
    }

    public void addRelationship(UCDRelationship relationship){

    }

    public void addClass(Class c){
        //this.
    }

}

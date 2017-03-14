/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.classdiagram;

import java.util.ArrayList;
import xmireader.model.classdiagram.element.Element;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import xmireader.model.classdiagram.element.CDClass;
import xmireader.model.classdiagram.element.Interface;
import xmireader.model.generic.GenericElement;
import xmireader.model.generic.Model;

/**
 *
 * @author kane
 */
public class ClassDiagram extends Model {
    //Map<String,GenericElement> elements;
    Map<String,CDClass> classes = new HashMap<String, CDClass>();
    Map<String,Interface> interfaces = new HashMap<String, Interface>();
    List<Relationship> relationships = new ArrayList<Relationship>();

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public ClassDiagram(){
        elements = new HashMap<String,GenericElement>();
        relationships = new ArrayList<Relationship>();
    }

    

    public void addElement(Element element){
        elements.put(element.getId(), element);
    }

    public void addRelationship(Relationship relationship){
       //addElement(relationship);
       relationships.add(relationship);
    }

    public void addInterface(Interface i){
        addElement(i);
        interfaces.put(i.getId(), i);
    }

    public void addClass(xmireader.model.classdiagram.element.CDClass c){
        addElement(c);
        classes.put(c.getId(), c);
    }
}

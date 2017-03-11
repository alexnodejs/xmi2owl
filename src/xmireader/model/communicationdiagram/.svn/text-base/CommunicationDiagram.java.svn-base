/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.communicationdiagram;
import java.util.HashMap;
import java.util.Map;

import xmireader.model.generic.GenericElement;
import xmireader.model.generic.Model;
import xmireader.model.communicationdiagram.element.Element;
import xmireader.model.communicationdiagram.element.Message;
import xmireader.model.communicationdiagram.element.Objekt;
/**
 *
 * @author pUf
 */
public class CommunicationDiagram extends Model {
    private HashMap<String, Message> messages;
    private HashMap<String, Objekt> objects;
    public CommunicationDiagram(){
        elements = new HashMap<String,GenericElement>();
        messages = new HashMap<String, Message>();
        objects = new HashMap<String, Objekt>();
    }

    public void addElement(Element element){
        elements.put(element.getId(), element);
    }

    public void addMessage(Message message){
        messages.put(message.getId(), message);
    }
    public HashMap<String, Message> getMessages(){
        return this.messages;
    }

    public void addObject(Objekt obj){
        objects.put(obj.getId(), obj);
    }

    public HashMap<String, Objekt> getObjects(){
        return this.objects;
    }
}

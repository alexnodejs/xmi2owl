/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.parser;
import java.util.List;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import xmireader.XMIConstants;
import xmireader.model.communicationdiagram.CommunicationDiagram;
import xmireader.model.generic.Model;
import xmireader.model.communicationdiagram.element.*;
import xmireader.model.communicationdiagram.element.Objekt;
/**
 *
 * @author pUf
 */
public class CommunicationDiagramParser extends GenericParser {

    @Override
    public Model parse(Document d) {
        CommunicationDiagram cd = new CommunicationDiagram();
        initializeNodes(d);
        parseMessages(d, cd);
        initializeNodes(d);
        parseObjects(d, cd);
        return cd;
    }

    private void parseMessages(Document d, CommunicationDiagram cd) throws DOMException {
        List<Node> messages = getNodesByName("message");
        for (Node m : messages) {
            String name = m.getAttributes().getNamedItem("name").getNodeValue();
            String id = m.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
                    initializeNodes(d);
                    String temp = m.getAttributes().getNamedItem("sendEvent").getNodeValue();
            String sender = parseFragments(d, temp);
                    initializeNodes(d);
                    temp = m.getAttributes().getNamedItem("receiveEvent").getNodeValue();
            String receiver = parseFragments(d,temp);
            Message x = new Message(id, name, sender, receiver);
            System.out.println("adding message "+x.getName());
            cd.addMessage(x);
            cd.addElement(x);
        }
    }

    private String parseFragments(Document d,String id) throws DOMException {
        List<Node> fragments = getNodesByXMIType(XMIConstants.XMI_UML_MOS_TYPE);
        for (Node f : fragments) {
             if(f.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue().equals(id)){
                 return f.getAttributes().getNamedItem("covered").getNodeValue();
             }
        }
        return null;
    }
    private void parseObjects(Document d, CommunicationDiagram cd) throws DOMException {
        List<Node> objects = getNodesByName("lifeline");
        for (Node o : objects) {
            String name = o.getAttributes().getNamedItem("name").getNodeValue();
            String id = o.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
            Objekt x = new Objekt(id, name);
            System.out.println("adding object "+x.getName());
            cd.addObject(x);
            cd.addElement(x);
        }
    }
}

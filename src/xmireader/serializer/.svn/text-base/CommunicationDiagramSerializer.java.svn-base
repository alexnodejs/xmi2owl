/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.serializer;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import java.io.FileWriter;
import java.util.Map;
import xmireader.URIConstants;
import xmireader.model.communicationdiagram.CommunicationDiagram;
import xmireader.model.communicationdiagram.element.*;

/**
 *
 * @author pUf
 */
public class CommunicationDiagramSerializer {
    public void serialize(CommunicationDiagram cd, OntModel o){
        Map<String,Message> messageMap = cd.getMessages();
        Message[] messages = messageMap.values().toArray(new Message[cd.getMessages().size()]);

        Map<String,Objekt> objectMap = cd.getObjects();
        Objekt[] objects = objectMap.values().toArray(new Objekt[cd.getObjects().size()]);

        Individual cdInd = o.getOntClass(URIConstants.NS+"CommunicationDiagram").createIndividual(URIConstants.NS+"hele");
        for(Objekt ob : objects){
            Individual i = o.createIndividual(URIConstants.NS+ob.getName(),o.getOntClass(URIConstants.NS+"Objt"));
            cdInd.addProperty(o.getObjectProperty(URIConstants.NS+"has"), i);
        }
        for(Message m : messages){
            Individual i = o.createIndividual(URIConstants.NS+m.getName()+"1",o.getOntClass(URIConstants.NS+"Message"));
            cdInd.addProperty(o.getObjectProperty(URIConstants.NS+"has"), i);
            i.addProperty(o.getOntProperty(URIConstants.NS+"isSentBy"), o.createIndividual(URIConstants.NS+objectMap.get(m.getSender()).getName(),o.getOntClass(URIConstants.NS+"Object")));
            i.addProperty(o.getOntProperty(URIConstants.NS+"isReceivedBy"), o.createIndividual(URIConstants.NS+objectMap.get(m.getReceiver()).getName(),o.getOntClass(URIConstants.NS+"Object")));
        }
        try{
        o.write(new FileWriter("src/xmireader/onto.txt"));
        }catch(Exception e){}
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.parser;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import xmireader.URIConstants;
import xmireader.XMIConstants;
import xmireader.model.activitydiagram.ActivityDiagram;
import xmireader.model.generic.Model;
import xmireader.model.activitydiagram.element.*;
import xmireader.model.communicationdiagram.element.Message;
import xmireader.model.communicationdiagram.element.Objekt;
/**
 *
 * @author pUf
 */
public class ActivityDiagramParser extends GenericParser {

    @Override
    public Model parse(Document d) {
        ActivityDiagram ad = new ActivityDiagram();
        initializeNodes(d);
        parseActivities(d, ad);
        initializeNodes(d);
        parseDecisions(d, ad);
        initializeNodes(d);
        parseMerges(d, ad);
        initializeNodes(d);
        parseEdges(d, ad);
        initializeNodes(d);
        parseJoins(d, ad);
        initializeNodes(d);
        parseForks(d, ad);
        initializeNodes(d);
        parseInitNodes(d, ad);
        initializeNodes(d);
        parseFinalNodes(d, ad);
        /*try{
        OntModel o = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        o.read(new FileReader("src/xmireader/priklad.owl"), URIConstants.URI);

        Map<String,Message> messageMap = ad.getMessages();
        Message[] messages = messageMap.values().toArray(new Message[ad.getMessages().size()]);

        Map<String,Objekt> objectMap = ad.getObjects();
        Objekt[] objects = objectMap.values().toArray(new Objekt[ad.getObjects().size()]);

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
        o.write(new FileWriter("src/xmireader/onto.txt"));
            }catch(Exception e){System.out.println(e.toString());}*/
        return ad;
    }

    private void parseActivities(Document d, ActivityDiagram ad) throws DOMException {
        List<Node> activities = getNodesByXMIType(XMIConstants.XMI_UML_ACTIVITY_TYPE);
        for (Node a : activities) {
            String name = a.getAttributes().getNamedItem("name").getNodeValue();
            String id = a.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
            String[] out = a.getAttributes().getNamedItem("outgoing").getNodeValue().split(" ");
            String[] in = a.getAttributes().getNamedItem("incoming").getNodeValue().split(" ");
            Activity x = new Activity(id, name, in, out);
            ad.addElement(x);
            ad.addActivity(x);
        }
    }

    private void parseDecisions(Document d, ActivityDiagram ad) throws DOMException {
        List<Node> decisions = getNodesByXMIType(XMIConstants.XMI_UML_DECISION_TYPE);
        for (Node dc : decisions) {
            String name = dc.getAttributes().getNamedItem("name").getNodeValue();
            String id = dc.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
            String[] out = dc.getAttributes().getNamedItem("outgoing").getNodeValue().split(" ");
            String[] in = dc.getAttributes().getNamedItem("incoming").getNodeValue().split(" ");
            Decision x = new Decision(id, name, in, out);
            ad.addElement(x);
            ad.addDecision(x);
        }
    }
    private void parseMerges(Document d, ActivityDiagram ad) throws DOMException {
        List<Node> merges = getNodesByXMIType(XMIConstants.XMI_UML_MERGE_TYPE);
        for (Node m : merges) {
            String name = m.getAttributes().getNamedItem("name").getNodeValue();
            String id = m.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
            String[] out = m.getAttributes().getNamedItem("outgoing").getNodeValue().split(" ");
            String[] in = m.getAttributes().getNamedItem("incoming").getNodeValue().split(" ");
            Merge x = new Merge(id, name, in, out);
            ad.addElement(x);
            ad.addMerge(x);
        }
    }
    private void parseEdges(Document d, ActivityDiagram ad) throws DOMException {
        List<Node> edges = getNodesByXMIType(XMIConstants.XMI_UML_EDGE_TYPE);
        for (Node e : edges) {
            String id = e.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
            String source = e.getAttributes().getNamedItem("source").getNodeValue();
            String target = e.getAttributes().getNamedItem("target").getNodeValue();
            if(e.getAttributes().getNamedItem("name")!=  null){
               String name = e.getAttributes().getNamedItem("name").getNodeValue();
               Condition x = new Condition(id, name, source, target);
               ad.addElement(x);
               ad.addCondition(x);
            }else{
               Edge x = new Edge(id, null, source, target);
               ad.addElement(x);
               ad.addEdge(x);
            }
        }
    }

    private void  parseJoins(Document d, ActivityDiagram ad) throws DOMException {
        List<Node> joins = getNodesByXMIType(XMIConstants.XMI_UML_JOIN_TYPE);
        for (Node j : joins) {
            String id = j.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
            String[] out = j.getAttributes().getNamedItem("outgoing").getNodeValue().split(" ");
            String[] in = j.getAttributes().getNamedItem("incoming").getNodeValue().split(" ");
            Join x = new Join(id, null, in, out);
            ad.addElement(x);
            ad.addJoin(x);
        }
    }

     private void  parseForks(Document d, ActivityDiagram ad) throws DOMException {
        List<Node> forks = getNodesByXMIType(XMIConstants.XMI_UML_JOIN_TYPE);
        for (Node f : forks) {
            String id = f.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
            String[] out = f.getAttributes().getNamedItem("outgoing").getNodeValue().split(" ");
            String[] in = f.getAttributes().getNamedItem("incoming").getNodeValue().split(" ");
            Fork x = new Fork(id, null, in, out);
            ad.addElement(x);
            ad.addFork(x);
        }
    }

     private void  parseInitNodes(Document d, ActivityDiagram ad) throws DOMException {
        List<Node> inodes = getNodesByXMIType(XMIConstants.XMI_UML_INODE_TYPE);
        for (Node i : inodes) {
            String id = i.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
            String out = i.getAttributes().getNamedItem("outgoing").getNodeValue();
            InitialNode x = new InitialNode(id, null, out);
            ad.addElement(x);
            ad.addInode(x);
        }
    }

     private void  parseFinalNodes(Document d, ActivityDiagram ad) throws DOMException {
        List<Node> fnodes = getNodesByXMIType(XMIConstants.XMI_UML_FNODE_TYPE);
        for (Node f : fnodes) {
            String id = f.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
            String in = f.getAttributes().getNamedItem("incoming").getNodeValue();
            FinalNode x = new FinalNode(id, null, in);
            ad.addElement(x);
            ad.addFNode(x);
        }
    }
}

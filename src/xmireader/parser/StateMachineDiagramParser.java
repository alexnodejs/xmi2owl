/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.parser;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.impl.PropertyImpl;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import xmireader.URIConstants;
import xmireader.XMIConstants;
import xmireader.model.communicationdiagram.element.Message;
import xmireader.model.communicationdiagram.element.Objekt;
import xmireader.model.generic.GenericElement;
import xmireader.model.statemachinediagram.StateMachineDiagram;
import xmireader.model.generic.Model;
import xmireader.model.statemachinediagram.element.*;
/**
 *
 * @author pUf
 */
public class StateMachineDiagramParser extends GenericParser {

    @Override
    public Model parse(Document d) {
        StateMachineDiagram smd = new StateMachineDiagram();
        initializeNodes(d);
        parseStates(d, smd);
        initializeNodes(d);
        parseTransitions(d, smd);

        try{
        OntModel o = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        o.read(new FileReader("src/xmireader/priklad.owl"), URIConstants.URI);

        Map<String,State> stateMap = smd.getStates();
        State[] states = stateMap.values().toArray(new State[smd.getStates().size()]);

        Map<String,Transition> transitionMap = smd.getTransitions();
        Transition[] transitions = transitionMap.values().toArray(new Transition[smd.getTransitions().size()]);

        Individual smdInd = o.getOntClass(URIConstants.NS+"StateMachineDiagram").createIndividual(URIConstants.NS+"StateMachineD");
        for(State s : states){
            Individual i = o.createIndividual(URIConstants.NS+s.getName(),o.getOntClass(URIConstants.NS+"State"));
            smdInd.addProperty(o.getObjectProperty(URIConstants.NS+"has"), i);
        }
        for(Transition t : transitions){
            Individual i = o.createIndividual(URIConstants.NS+t.getId(),o.getOntClass(URIConstants.NS+"Transition"));
            i.addProperty(o.getOntProperty(URIConstants.NS+"belongsTo"), smdInd);
            i.addProperty(o.getOntProperty(URIConstants.NS+"transitedFrom"),
                    o.createIndividual(URIConstants.NS+stateMap.get(t.getSource()).getName(),
                    o.getOntClass(URIConstants.NS+"State")));
           // i.addProperty(o.getObjectProperty(URIConstants.NS+"transitsTo"), o.createIndividual(URIConstants.NS+stateMap.get(t.getTarget()).getName(),o.getOntClass(URIConstants.NS+"State")));
            smdInd.addProperty(o.getOntProperty(URIConstants.NS+"has"), i);
        }
       /* //Reasoner reasoner = ReasonerRegistry.getOWLReasoner();
        InfModel inf = ModelFactory.createInfModel(reasoner, o);
        ValidityReport validity = inf.validate();
        com.hp.hpl.jena.rdf.model.Model x = inf.getDeductionsModel();
        //x.write(new FileWriter("src/xmireader/onto.txt"));
        if (validity.isValid()) {
        System.out.println("OK");
    } else {
        System.out.println("Conflicts");
        for (Iterator i = validity.getReports(); i.hasNext(); ) {
            System.out.println(" - " + i.next());
        }
    }
*/
        o.write(new FileWriter("src/xmireader/onto.txt"));
            }catch(Exception e){System.out.println(e.toString());}

        return smd;
    }
    private void parseStates(Document d, StateMachineDiagram smd) throws DOMException {
        List<Node> states = getNodesByXMIType(XMIConstants.XMI_UML_STATE_TYPE);
        for (Node s : states) {
            String name = s.getAttributes().getNamedItem("name").getNodeValue();
            String id = s.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
            State x = new State(id, name);
            smd.addElement(x);
            smd.addState(x);
        }
    }

    private void parseTransitions(Document d, StateMachineDiagram smd) throws DOMException {
        List<Node> transitions = getNodesByName("transition");
        for (Node t : transitions) {
            String id = t.getAttributes().getNamedItem(XMIConstants.XMI_ID).getNodeValue();
            String source = t.getAttributes().getNamedItem("source").getNodeValue();
            String target = t.getAttributes().getNamedItem("target").getNodeValue();
            Transition x = new Transition(id, null, source, target);
            smd.addElement(x);
            smd.addTransition(x);
        }
    }
}

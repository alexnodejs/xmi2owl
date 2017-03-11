/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.serializer;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.io.FileReader;
import java.util.List;
import xmireader.URIConstants;
import xmireader.model.communicationdiagram.CommunicationDiagram;
import xmireader.model.generic.Model;

/**
 *
 * @author pUf
 */
public class BehavioralDiagramsSerializer {
    List<Model> diagrams;
    OntModel o;
    public BehavioralDiagramsSerializer(List<Model> d){
        diagrams = d;
        try{
        o = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        o.read(new FileReader("src/xmireader/priklad.owl"), URIConstants.URI);
        }catch(Exception e){}
    }

    public void serialize(){
        for(Model d: diagrams){
           // if(d instanceof ActivityDiagram) new ActivitDiagramSerializer().serialize((ActivityDiagram)d);
           // else
                if(d instanceof CommunicationDiagram) new CommunicationDiagramSerializer().serialize((CommunicationDiagram)d, o);
            //    else
            //        if(d instanceof StateMachineDiagram) new StateMachineDiagramSerializer().serialize((StateMacineDiagram)d);
            //        else
            //            if(d instanceof UseCaseDiagram) new UseCaseDiagramSerializer().serialize((UseCaseDiagram)d);
        }
    }

}

package ontology;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import org.w3c.dom.Node;
import xmireader.URIConstants;
import xmireader.XMIConstants;
import xmireader.model.XMLReader;
import xmireader.model.classdiagram.ClassDiagram;
import xmireader.model.classdiagram.element.CDClass;
import xmireader.model.generic.GenericElement;
import xmireader.model.generic.Model;
import xmireader.parser.ClassDiagramParser;
import xmireader.parser.GenericParser;

import java.io.FileWriter;
import java.util.List;

/**
 * Created by svitlanamoiseyenko on 3/12/17.
 */
public class OntologyBuilder {

    private List<Model> models;

    public OntologyBuilder(List<Model> models) {
        this.models = models;
    }

//    public void getXMLClasses() {
//
//        System.out.println("reader: " + models.toString());
//        for (Model model: models) {
//          System.out.println("model: " + model.getClass());
//          ClassDiagram classDiagram = (ClassDiagram)model;
//            for(GenericElement e: classDiagram.getElements().values()){
//                CDClass cdClass = (CDClass)e;
//                System.out.println("classDiagram: " + cdClass.getName());
//                System.out.println("classDiagram: " + cdClass.getAttributes());
//            }
//
//        }
//
//
//    }

    public void buildOntology() {

        //getXMLClasses();

        try {
            OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
            String filenameOWL2 = "src/xmireader/dump/test11.owl";
            //base.read(filenameOWL2,  URIConstants.URI);

//            OntClass researcher = model.createClass(URIConstants.NS + "Researcher");
//            // create a dummy paper for this example
//            OntClass paper = model.getOntClass( URIConstants.NS + "Message" );
//            Individual p1 = model.createIndividual( URIConstants.NS + "paper1", paper );

            for (Model xmimodel: models) {
                System.out.println("model: " + xmimodel.getClass());
                ClassDiagram classDiagram = (ClassDiagram)xmimodel;
                for(GenericElement e: classDiagram.getElements().values()){
                    CDClass cdClass = (CDClass)e;
                    OntClass ontoClass = model.createClass(URIConstants.NS + cdClass.getName());
                    System.out.println("classDiagram: " + cdClass.getName());
                    System.out.println("classDiagram: " + cdClass.getAttributes());
                }

            }


            model.write(new FileWriter(filenameOWL2));
            //FileWriter out = null;
            //out = new FileWriter(filenameOWL2);
            //base.write(System.out, "OWL2");
        } catch(Exception e){
            e.printStackTrace();
        }

    }

}

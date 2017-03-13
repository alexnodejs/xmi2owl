package ontology;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.vocabulary.VCARD;
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

import xmireader.model.classdiagram.element.*;
/**
 * Created by svitlanamoiseyenko on 3/12/17.
 */
public class OntologyBuilder {

    private List<Model> models;
    OntModel model;

    public OntologyBuilder(List<Model> models) {
        this.models = models;
        this.model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
    }

    private void buildOntology() {

        System.out.println("reader: " + models.toString());
        for (Model model: models) {
          System.out.println("model: " + model.getClass());
          ClassDiagram classDiagram = (ClassDiagram)model;
            for(GenericElement e: classDiagram.getElements().values()){
                CDClass cdClass = (CDClass)e;
                OntClass ontoClass = this.model.createClass(URIConstants.NS + cdClass.getName());

                System.out.println("classDiagram: " + cdClass.getName());
                buildAttributes(cdClass, ontoClass);
            }
        }
    }

    private void buildAttributes(CDClass cdClass, OntClass ontoClass) {
        List<Attribute> attributes = cdClass.getAttributes();
        for(Attribute attribute: attributes) {
            System.out.println("attribute: " + attribute.getName());
            ontoClass.addProperty(VCARD.Extadd, attribute.getName());//NPROPERTIES
        }
    }

    public void performConvetring() {

        buildOntology();

        try {

            String filenameOWL2 = OntoConstants.dirname + OntoConstants.filename + OntoConstants.rdfExtension;
            //base.read(filenameOWL2,  URIConstants.URI);

            model.write(new FileWriter(filenameOWL2));
            //FileWriter out = null;
            //out = new FileWriter(filenameOWL2);
            //base.write(System.out, "OWL2");
        } catch(Exception e){
            e.printStackTrace();
        }

    }

}

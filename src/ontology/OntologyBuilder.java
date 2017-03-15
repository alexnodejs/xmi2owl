package ontology;

import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.vocabulary.VCARD;
import org.w3c.dom.Node;
import xmireader.URIConstants;
import xmireader.XMIConstants;
import xmireader.model.XMLReader;
import xmireader.model.classdiagram.ClassDiagram;
import xmireader.model.classdiagram.Relationship;
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
    OntModel ontModel;
    OntClass ontoClassCats;

    public OntologyBuilder(List<Model> models) {
        this.models = models;
        this.ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);//OWL_MEM //RDFS_MEM
    }

    private void buildTestOnto() {
        final OntClass son = ontModel.createClass( URIConstants.NS+"Son" );
        final OntClass father = ontModel.createClass( URIConstants.NS+"Father" );


        final OntProperty hasFather = ontModel.createObjectProperty( URIConstants.NS+"hasFather" );
        //final OntProperty hasSon = ontModel.createObjectProperty( URIConstants.NS+"hasSon" );

        // (1) Father subClassOf Son
        son.addSubClass( father );

        // (3'a) Son subClassOf (hasFather only Father)
        son.addSubClass( ontModel.createAllValuesFromRestriction( null, hasFather, father ));

        // (3'b) Son subClassOf (hasFather exactly 1)
       //son.addSubClass( ontModel.createCardinalityRestriction( null, hasFather, 1 ));

        // (5) Father subClassOf (hasSon min 1 Son)
        //father.addSubClass( ontModel.createSomeValuesFromRestriction( null, hasSon, son ));

        /*
        // You can create individuals of a given type using Individual#createIndividual,
        // or with Model#createIndividual.
        final Individual abe = father.createIndividual( URIConstants.NS+"AbrahamLincoln" );
        final Individual rob = ontModel.createIndividual( URIConstants.NS+"RobertToddLincoln", son );

        // You can add properties to individuals using Individual#addProperty, or you can
        // use the various Model#add methods to add statements to the model.
        rob.addProperty( hasFather, abe ); // (7)
        ontModel.add( abe, hasSon, rob );     // (8)*/

    }
    private void buildOntology() {

        System.out.println("reader: " + models.toString());
        for (Model model: models) {
          System.out.println("model: " + model.getClass());
          ClassDiagram classDiagram = (ClassDiagram)model;

            for(GenericElement e: classDiagram.getElements().values()){
                CDClass cdClass = (CDClass)e;

                System.out.println("classDiagram: " + cdClass.getName());

                OntClass ontoClass = this.ontModel.createClass(URIConstants.NS + cdClass.getName());
                buildAttributes(cdClass, ontoClass);
            }
            buildRelationships(classDiagram);
        }

    }

    private CDClass searchClassByID( ClassDiagram classDiagram, String classID) {

        for(GenericElement e: classDiagram.getElements().values()) {
            CDClass cdClass = (CDClass) e;
            if(cdClass.getId().equals(classID)) {
                return cdClass;
            }

        }
        return null;
    }
    private void buildRelationships(ClassDiagram classDiagram) {

            for(Relationship relationship: classDiagram.getRelationships()) {
                System.out.println("relationship name: " + relationship.getName());
                System.out.println("relationship destination: " + relationship.getDestinationID());
                System.out.println("relationship source: " + relationship.getSourceID());

                CDClass cdClassSource = searchClassByID(classDiagram, relationship.getSourceID());
                CDClass cdClassDestination = searchClassByID(classDiagram, relationship.getDestinationID());

                OntClass ontoSource = ontModel.getOntClass(URIConstants.NS + cdClassSource.getName());
                OntClass ontoDestination = ontModel.getOntClass(URIConstants.NS + cdClassDestination.getName());

                switch (relationship.getType()) {
                    case GENERALIZATION:
                        ontoSource.addSubClass(ontoDestination);
                        break;
                    default:
                       final OntProperty aggregation = ontModel.createObjectProperty( URIConstants.relationshipURI + relationship.getName());
                       ontoSource.addSubClass(ontModel.createSomeValuesFromRestriction( null, aggregation, ontoDestination ));
                       break;
                }
                System.out.println("relationship destination name: " + cdClassDestination.getName());
                System.out.println("relationship source name: " + cdClassSource.getName());


            }
    }

    private void buildAttributes(CDClass cdClass, OntClass ontoClass) {
        List<Attribute> attributes = cdClass.getAttributes();
        for(Attribute attribute: attributes) {
            System.out.println("attribute: " + attribute.getName());
            ontoClass.addProperty(VCARD.N, attribute.getName());//NPROPERTIES
        }
    }

    public void performConvetring() {

        //buildTestOnto();
        buildOntology();


        try {

            String filenameOWL2 = OntoConstants.dirname + OntoConstants.filename + OntoConstants.rdfExtension;
            //base.read(filenameOWL2,  URIConstants.URI);

            ontModel.write(new FileWriter(filenameOWL2));
//            FileWriter out = null;
//            out = new FileWriter(filenameOWL2);
//            ontModel.write(System.out, "Turtle");//Turtle
        } catch(Exception e){
            e.printStackTrace();
        }

    }

}

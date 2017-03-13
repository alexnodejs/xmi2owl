/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmireader;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.impl.PropertyImpl;
import com.hp.hpl.jena.rdf.model.impl.ResourceImpl;
import com.hp.hpl.jena.util.FileManager;
import de.incunabulum.owl2java.core.JenaGenerator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ontology.OntologyBuilder;
import xmireader.model.XMLReader;
import xmireader.URIConstants;


/**
 * @author kane
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //JenaGenerator generator = new JenaGenerator();
        //generator.setFactoryName("UMLFactory");
        //generator.setVocabularyName("UMLVocab");
        //generator.setToolsPackage("xmireader.model.classdiagram.generated");
        //generator.setTestcaseName("noname");
        //generator.setCreateTestClass(false);


        String filename = "src/xmireader/dump/test_5xmi.xmi";
        //test_outputparser.xmi";//
        //"src/xmireader/dump/class.uml";

        XMLReader reader = new XMLReader(filename);
        //"src/xmireader/default.uml");
        List<xmireader.model.generic.Model> models = reader.parse();

        System.out.println("XMI Parse" + reader.parse());


        OntologyBuilder ontologyBuilder = new OntologyBuilder(models);
        ontologyBuilder.buildOntology();

    }
}

 /*   String filenameRDF = "src/xmireader/dump/test.rdf";
        String filenameOWL = "src/xmireader/dump/test.owl";
        String ns = "ns:";//"http://example.com/example#";
        // Create an empty model
       OntModel model = ModelFactory.createOntologyModel(OntModelSpec.RDFS_MEM);


        //OntModel model = ModelFactory.createOntologyModel( OntModelSpec.OWL_DL_MEM_RULE_INF, base);
        // Use the FileManager to find the input file
//        InputStream in = FileManager.get().open(filenameOWL);
//
//        if (in == null)
//            throw new IllegalArgumentException("File: "+filenameOWL+" not found");

        // Read the RDF/XML file
        //model.read(in, null);

        // Create a new class named "Researcher"
        OntClass researcher = model.createClass(ns+"Researcher");

        // ** TASK 6.1: Create a new class named "University" **

        OntClass univer = model.createClass(ns + "University");

        // ** TASK 6.2: Add "Researcher" as a subclass of "Person" **

        //model.getOntClass(ns + "Person").addSubClass(researcher);

        // ** TASK 6.3: Create a new property named "worksIn" **

        Property worksIn = model.createProperty(ns + "worksIn");

        // ** TASK 6.4: Create a new individual of Researcher named "Jane Smith" **

        Individual janeSmith = researcher.createIndividual(ns + "JaneSmith");


        // ** TASK 6.5: Add to the individual JaneSmith the fullName, given and family names **

        //janeSmith.addProperty(VCARD.FN,"Jane Smith");
        //janeSmith.addProperty(VCARD.Given,"Jane");
        //janeSmith.addProperty(VCARD.Family,"Smith");

        // ** TASK 6.6: Add UPM as the university where John Smith works **

        //Individual johnSmith = model.getIndividual(ns + "JohnSmith");
        //Individual upm = univer.createIndividual(ns + "UPM");
        //johnSmith.addProperty(worksIn,upm);

        FileWriter outrdf = null;
        FileWriter outowl = null;
        try {
            //out = new FileWriter( "mymodel.xml" );

            //outrdf = new FileWriter( filenameRDF );
            //model.write(outrdf, "RDF/XML");

            outowl = new FileWriter( filenameOWL );
            model.write(outowl, "OWL/XML");
        } catch(Exception e){
                 e.printStackTrace();
        }*/

         /*try {
                OntModel base = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM);
                String filenameOWL2 = "src/xmireader/dump/test2.owl";
                //"src/xmireader/dump/phdd.owl";
                //"src/xmireader/priklad.owl";
                //base.read(new FileReader(filenameOWL), URIConstants.URI);

                // create the reasoning model using the base
                OntModel inf = ModelFactory.createOntologyModel( OntModelSpec.OWL_DL_MEM_RULE_INF, base );

                OntClass researcher = inf.createClass(URIConstants.NS + "Researcher");
                // create a dummy paper for this example
                OntClass paper = inf.getOntClass( URIConstants.NS + "Message" );
                Individual p1 = inf.createIndividual( URIConstants.NS + "paper1", paper );

                inf.write(new FileWriter(filenameOWL2));//"src/xmireader/onto.txt"));
            } catch(Exception e){
                e.printStackTrace();
            }*/

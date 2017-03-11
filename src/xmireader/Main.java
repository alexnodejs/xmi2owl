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
import de.incunabulum.owl2java.core.JenaGenerator;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import xmireader.model.XMLReader;
import xmireader.URIConstants;

/**
 *
 * @author kane
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
            JenaGenerator generator = new JenaGenerator();
            generator.setFactoryName("UMLFactory");
            generator.setVocabularyName("UMLVocab");
            generator.setToolsPackage("xmireader.model.classdiagram.generated");
            generator.setTestcaseName("noname");
            generator.setCreateTestClass(false);


            XMLReader reader = new XMLReader("src/xmireader/default.uml");
            System.out.println(reader.parse());

            try {
                OntModel base = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
                base.read(new FileReader("src/xmireader/priklad.owl"), URIConstants.URI);

                // create the reasoning model using the base
                OntModel inf = ModelFactory.createOntologyModel( OntModelSpec.OWL_DL_MEM_RULE_INF, base );

                // create a dummy paper for this example
                OntClass paper = inf.getOntClass( URIConstants.NS + "Message" );
                Individual p1 = inf.createIndividual( URIConstants.NS + "paper1", paper );


                inf.write(new FileWriter("src/xmireader/onto.txt"));
            } catch(Exception e){
                e.printStackTrace();
            }

    }
}

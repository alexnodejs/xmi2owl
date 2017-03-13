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

import ontology.OntoConstants;
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


        String filename =  OntoConstants.dirname + OntoConstants.filename + OntoConstants.xmiExtension;
        //test_outputparser.xmi";//
        //"src/xmireader/dump/class.uml";
        //"src/xmireader/default.uml");

        XMLReader reader = new XMLReader(filename);
        List<xmireader.model.generic.Model> models = reader.parse();

        System.out.println("XMI Parse" + reader.parse());

        OntologyBuilder ontologyBuilder = new OntologyBuilder(models);
        ontologyBuilder.performConvetring();

    }
}


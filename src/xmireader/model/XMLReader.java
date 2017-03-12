/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmireader.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import xmireader.model.generic.Model;
import xmireader.parser.*;

/**
 *
 * @author kane
 */
public class XMLReader {

    private Document d;
    private Queue<Node> q = new LinkedList<Node>();
    private ArrayList<GenericParser> parsers = new ArrayList<GenericParser>();

    public XMLReader(String filename) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            d = db.parse(filename);

        } catch (SAXException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Model> parse() {
        //parsers.add(new CommunicationDiagramParser());  //TODO: remove from here!
        parsers.add(new ClassDiagramParser());
        List<Model> parsedModels = new ArrayList<Model>();
        for (GenericParser p : getParsers()) {
            //System.out.println("XMI parsing: " + p);
            parsedModels.add(p.parse(d));
        }
        return parsedModels;
    }

    /**
     * @return the parsers
     */
    public ArrayList<GenericParser> getParsers() {
        return parsers;
    }

    /**
     * @param parsers the parsers to set
     */
    public void setParsers(ArrayList<GenericParser> parsers) {
        this.parsers = parsers;
    }
}

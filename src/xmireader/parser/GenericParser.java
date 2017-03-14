/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.parser;

import org.w3c.dom.Document;
import xmireader.model.generic.Model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.w3c.dom.Node;
import xmireader.XMIConstants;

/**
 *
 * @author kane
 */
public abstract class GenericParser {
    private Queue<Node> q;

    public GenericParser(){
        q = new LinkedList<Node>();
    }

    public abstract Model parse(Document d);

    protected void initializeNodes(Document d){
        clearNodes();
        for(int i=0;i<d.getChildNodes().getLength();i++){
            addNode(d.getChildNodes().item(i));
        }
    }

    public List<Node> getNodesByXMIType(String xmiType) {
        //clearNodes();
        Node n = getNode();
        System.out.println("getNodesByXMIType: " + xmiType + " node: " + n);

        List<Node> nodes = new ArrayList<Node>();
        for(int i=0;i<n.getChildNodes().getLength();i++){
            q.add(n.getChildNodes().item(i));
        }
        if (n.hasAttributes() && n.getAttributes().getNamedItem(XMIConstants.XMI_TYPE) != null &&
                n.getAttributes().getNamedItem(XMIConstants.XMI_TYPE).getNodeValue().equals(xmiType)) {
            if(n.getAttributes().getNamedItem("name")!=null) {
                System.out.println("Found class with name " + n.getAttributes().getNamedItem("name"));
            }

            nodes.add(n);
        }

        if(!q.isEmpty()){
            nodes.addAll(getNodesByXMIType(xmiType));
        }
        return nodes;
    }

    public List<Node> getClassNodesByName(String name){
        Node n = getNode();
        ArrayList<Node> nodes = new ArrayList<Node>();

        for(int i=0;i<n.getChildNodes().getLength();i++){
            q.add(n.getChildNodes().item(i));
        }

        if (n.getNodeName().equals(name)) {
            if(n.getAttributes().getNamedItem("name")!=null) {
                System.out.println("getClassNodesByName Found class with name " + n.getAttributes().getNamedItem("name"));
                nodes.add(n);
            }
        }

        if(!q.isEmpty()){
            nodes.addAll(getClassNodesByName(name));
        }
        return nodes;
    }




    public List<Node> getNodesByName(String name){
        Node n = getNode();

        ArrayList<Node> nodes = new ArrayList<Node>();
        for(int i=0;i<n.getChildNodes().getLength();i++){
            q.add(n.getChildNodes().item(i));
        }

        if (n.getNodeName().equals(name)) {
            if(n.getAttributes().getNamedItem("generalization") != null) {
                System.out.println("getNodesByName Found class with name " + n.getAttributes().getNamedItem("name"));
            }
            nodes.add(n);
        }

        if (n.getNodeName().equals(name)){
            
        }
        
        if(!q.isEmpty()){
            nodes.addAll(getNodesByName(name));
        }
        return nodes;
    }

    protected void addNode(Node n){
        q.add(n);
    }

    protected void clearNodes(){
        q.clear();
    }

    protected void setNode(Node n) {
        clearNodes();
        q.add(n);
    }

    protected Node getNode() {
        return q.poll();
    }


}

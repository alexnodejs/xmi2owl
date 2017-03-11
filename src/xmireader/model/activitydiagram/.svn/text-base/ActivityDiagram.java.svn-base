/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.activitydiagram;
import xmireader.model.activitydiagram.element.Element;
import java.util.HashMap;

import java.util.Map;
import xmireader.model.activitydiagram.element.*;
import xmireader.model.generic.GenericElement;
import xmireader.model.generic.Model;

/**
 *
 * @author pUf
 */
public class ActivityDiagram extends Model {
    HashMap<String,GenericElement> elements;
    Map<String,Activity> activities;
    Map<String,Edge> edges;
    Map<String,Condition> conditions;
    Map<String,Join> joins;
    Map<String,Decision> decisions;
    Map<String,Fork> forks;
    Map<String,FinalNode> fnodes;
    Map<String,InitialNode> inodes;
    Map<String,Merge> merges;

    public ActivityDiagram(){
        elements = new HashMap<String,GenericElement>();
        activities = new HashMap<String, Activity>();
        edges = new HashMap<String, Edge>();
        conditions = new HashMap<String, Condition>();
        joins = new HashMap<String, Join>();
        decisions = new HashMap<String, Decision>();
        forks = new HashMap<String, Fork>();
        fnodes = new HashMap<String, FinalNode>();
        inodes = new HashMap<String, InitialNode>();
        merges = new HashMap<String, Merge>();
    }



    public void addElement(Element element){
        elements.put(element.getId(), element);
    }
     public void addActivity(Activity a){
        activities.put(a.getId(), a);
    }
     public void addEdge(Edge e){
        edges.put(e.getId(), e);
    }
     public void addFNode(FinalNode f){
        fnodes.put(f.getId(), f);
    }
     public void addInode(InitialNode i){
        inodes.put(i.getId(), i);
    }
     public void addFork(Fork f){
        forks.put(f.getId(), f);
    }
     public void addDecision(Decision d){
        decisions.put(d.getId(), d);
    }
     public void addMerge(Merge m){
        merges.put(m.getId(), m);
    }
    public void addJoin(Join j){
        joins.put(j.getId(), j);
    }
    public void addCondition(Condition c){
        conditions.put(c.getId(), c);
    }
    public Map<String, Activity> getActivities() {
        return activities;
    }

    public Map<String, Condition> getConditions() {
        return conditions;
    }

    public Map<String, Decision> getDecisions() {
        return decisions;
    }

    public Map<String, Edge> getEdges() {
        return edges;
    }

    public Map<String, FinalNode> getFnodes() {
        return fnodes;
    }

    public Map<String, Fork> getForks() {
        return forks;
    }

    public Map<String, InitialNode> getInodes() {
        return inodes;
    }

    public Map<String, Join> getJoins() {
        return joins;
    }

    public Map<String, Merge> getMerges() {
        return merges;
    }

}

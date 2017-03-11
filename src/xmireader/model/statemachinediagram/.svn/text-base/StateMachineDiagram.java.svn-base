/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.statemachinediagram;


import java.util.HashMap;

import xmireader.model.generic.GenericElement;
import xmireader.model.generic.Model;
import xmireader.model.statemachinediagram.element.*;
/**
 *
 * @author pUf
 */
public class StateMachineDiagram extends Model {
    HashMap<String,State> states;
    HashMap<String,Transition> transitions;
    public StateMachineDiagram(){
        states = new HashMap<String, State>();
        elements = new HashMap<String,GenericElement>();
        transitions = new HashMap<String, Transition>();
    }

    public void addElement(Element element){
        elements.put(element.getId(), element);
    }

    public void addState(State s){
        states.put(s.getId(),s);
    }

    public void addTransition(Transition t){
        transitions.put(t.getId(), t);
    }

    public HashMap<String,State> getStates(){
        return this.states;
    }

    public HashMap<String, Transition> getTransitions() {
        return transitions;
    }
}

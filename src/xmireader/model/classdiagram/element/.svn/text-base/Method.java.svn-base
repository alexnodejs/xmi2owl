/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.classdiagram.element;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kane
 */
public class Method extends Element {
    private List<Parameter> parameters;
    private VisibilityKind visibility;
    
    public Method(String id, String name){
        super(id, name);
        parameters = new ArrayList<Parameter>();
    }

    public Method(String id, String name, List<Parameter> params, VisibilityKind visibility){
        super(id, name);
        this.parameters = params;
        this.visibility = visibility;
    }

    public void addParameter(Parameter param){
        this.parameters.add(param);
    }

    /**
     * @return the parameters
     */
    public List<Parameter> getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    /**
     * @return the visibility
     */
    public VisibilityKind getVisibility() {
        return visibility;
    }

    /**
     * @param visibility the visibility to set
     */
    public void setVisibility(VisibilityKind visibility) {
        this.visibility = visibility;
    }
}

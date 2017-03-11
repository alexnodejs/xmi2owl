/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.classdiagram.element;

/**
 *
 * @author kane
 */
public class Parameter extends Element {
    private Type type;
    private String typeId;
    private ParameterDirectionKind parameterDirection;
    
    public Parameter(String id, String name, Type type, ParameterDirectionKind parameterDirection){
        super(id, name);
        this.type = type;
        this.parameterDirection = parameterDirection;
    }

    public Parameter(String id, String name, String typeId, ParameterDirectionKind parameterDirection){
        super(id, name);
        this.typeId = typeId;
        this.parameterDirection = parameterDirection;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @return the parameterDirection
     */
    public ParameterDirectionKind getParameterDirection() {
        return parameterDirection;
    }

    /**
     * @param parameterDirection the parameterDirection to set
     */
    public void setParameterDirection(ParameterDirectionKind parameterDirection) {
        this.parameterDirection = parameterDirection;
    }
}

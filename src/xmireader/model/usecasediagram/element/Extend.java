/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.usecasediagram.element;

/**
 *
 * @author pUf
 */
public class Extend extends Element {
    private String extendedCaseID;

    public String getExtendedCaseID() {
        return extendedCaseID;
    }

    public void setExtendedCaseID(String extendedCaseID) {
        this.extendedCaseID = extendedCaseID;
    }
    public Extend(String id, String ecID){
        super(id);
        extendedCaseID = ecID;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.usecasediagram.element;

/**
 *
 * @author pUf
 */
public class Include extends Element{
    private String addition;

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }
    public Include(String id, String add){
        super(id);
        addition = add;
    }

}

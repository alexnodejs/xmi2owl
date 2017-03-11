/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.activitydiagram.element;

/**
 *
 * @author pUf
 */
public class FinalNode extends Element{
    private String incoming;
    public FinalNode(String id, String name, String in){
        super(id, name);
        this.incoming = in;
    }

    @Override
public String toString(){
    StringBuffer sb = new StringBuffer();
    sb.append("\nFinal Node id: ").
            append(getId()).
            append(", incoming edge id: ").
            append(getIncoming());

         return sb.toString();
    }

    public String getIncoming() {
        return incoming;
    }

    public void setIncoming(String incoming) {
        this.incoming = incoming;
    }


}

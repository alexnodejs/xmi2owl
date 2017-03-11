/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.communicationdiagram.element;

/**
 *
 * @author pUf
 */
public class Message extends Element{
    private String sender;
    private String receiver;
    public Message(String id, String name, String sender, String receiver){
        super(id,name);
        this.sender = sender;
        this.receiver = receiver;
    }
@Override
public String toString() {
    StringBuffer sb= new StringBuffer();
    sb.append("\nMessage: ").
            append("\""+getName()+"\"").
            append(", id: ").
            append(getId()).
            append("\n\tsender id: ").
            append(getSender()).
            append("\n\treceiver id: ").
            append(getReceiver());
    return sb.toString();
}

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xmireader.model.usecasediagram.element;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author pUf
 */
public class UseCase extends Type {
    private List<ExtensionPoint> extensionPoints;
    private List<Extend> xtends;
    private List<Include> includes;

    public UseCase(String id, String name) {
        super(id, name);
    }

    public List<ExtensionPoint> getExtensionPoints() {
        return extensionPoints;
    } 

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("\nUse case: ").
        append("\""+getName()+"\"").
        append(", id: ").
        append(getId());
        try{
        for(Include i: getIncludes()){
            sb.append("\n\tincludes: ").
                    append(i.getAddition());
        }
        for(Extend e: getXtends()){
            sb.append("\n\textends: ").
                    append(e.getExtendedCaseID());
        }
        for(ExtensionPoint xp: getExtensionPoints()){
            sb.append("\n\thas extension point: ").
                    append(xp.getName());
        }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
        return sb.toString();
    }

    public void setExtensionPoints(List<ExtensionPoint> extensionPoints) {
        this.extensionPoints = extensionPoints;
    }

    public List<Include> getIncludes() {
        return includes;
    }

    public void setIncludes(List<Include> includes) {
        this.includes = includes;
    }

    public List<Extend> getXtends() {
        return xtends;
    }

    public void setXtends(List<Extend> xtends) {
        this.xtends = xtends;
    }
}

package javasql;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kane
 * Date: Mar 29, 2010
 * Time: 6:44:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Entry implements TreeNode {
    int id;
    private Entry parent;
    private List<Entry> children;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Entry(int id, Entry parrent, String name,  List<Entry> children){
        this.id = id;
        this.name = name;
        this.setParent(parrent);
        this.setChildren(children);
    }

    public TreeNode getChildAt(int i) {
        return getChildren().get(i);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getChildCount() {
        return getChildren().size();  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Entry getParent() {
        return parent;
    }

    public int getIndex(TreeNode treeNode) {
        return getChildren().indexOf(treeNode);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean getAllowsChildren() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isLeaf() {
        return getChildren().size() == 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Enumeration children() {
        return Collections.enumeration(getChildren());  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setParent(Entry parent) {
        if(this.parent != null)
            this.parent.getChildren().remove(this);
        this.parent = parent;
        if(parent!=null)
            parent.getChildren().add(this);
    }

    public List<Entry> getChildren() {
        if(children == null)
            children = new ArrayList<Entry>();

        return children;
    }

    public void setChildren(List<Entry> children) {
        if(children == null)
            this.children = new ArrayList<Entry>();
        for (Entry child : this.children) {
            child.setParent(this);
        }
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

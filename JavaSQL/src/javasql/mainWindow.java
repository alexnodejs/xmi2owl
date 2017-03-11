package javasql;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kane
 * Date: Mar 29, 2010
 * Time: 5:52:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class mainWindow {
    private static TreeModel tm;
    private static DataAccessObjectCollection daoc;

    public mainWindow() {
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String select = textField1.getText();
                TreeNode tn = daoc.getDataAccessObjectListFromSQL(select);
                tm = new DefaultTreeModel(tn);
                tree1.setModel(tm);
                tree1.repaint();
            }
        });
    }

    public JTree getTree1() {
        return tree1;
    }

    private JTree tree1;
    private JPanel panel1;
    private JTextField textField1;
    private JButton button1;

    public static void main(String[] args) {
        daoc = new DataAccessObjectCollection();
        TreeNode entries = daoc.getDataAccessObjectListFromSQL("SELECT * FROM parent_test");
        tm = new DefaultTreeModel(entries);

        JFrame frame = new JFrame("mainWindow");
        mainWindow mainWindow = new mainWindow();
        frame.setContentPane(mainWindow.panel1);
        mainWindow.tree1.setModel(tm);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

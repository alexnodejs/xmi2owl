package javasql;

import javax.swing.tree.TreeNode;
import java.sql.*;
import java.util.*;


/**
 * DataAccessObject collection
 */
public class DataAccessObjectCollection  {
    Connection con;
    Statement stmt;

    public DataAccessObjectCollection() {
        String url = "jdbc:mysql://localhost:3306/test";
        try {
             Class.forName("com.mysql.jdbc.Driver").newInstance();

            con = DriverManager.getConnection(url, "root", "root");
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public TreeNode getDataAccessObjectListFromSQL(String sqlSelect) {
        TreeNode entries;
        List<DataAccessObjectImpl> daos = new ArrayList<DataAccessObjectImpl>();
        
        try {


            ResultSet rs = stmt.executeQuery(sqlSelect);
            while (rs.next()) {
                daos.add(new DataAccessObjectImpl(rs.getInt("id"), rs.getString("name"), rs.getInt("parent_id")));
                
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        entries = getListOfEntries(daos);

        return entries;
    }

    private TreeNode getListOfEntries(List<DataAccessObjectImpl> daos) {
        Comparator<DataAccessObjectImpl> c = new Comparator<DataAccessObjectImpl>(){
            public int compare(DataAccessObjectImpl dataAccessObject, DataAccessObjectImpl dataAccessObject1) {
                if(dataAccessObject.getParrentId()>dataAccessObject1.getParrentId())
                    return 1;
                else if(dataAccessObject.getParrentId()==dataAccessObject1.getParrentId())
                    return 0;
                else
                    return -1;
            }
        };
        Collections.sort(daos, c);
        List<Entry> entries = new ArrayList<Entry>();
        Entry root = new Entry(0, null, "root", null);
        entries.add(root);
        for (DataAccessObjectImpl dao : daos) {
            createEntryFromDao(entries, dao);
        }

        return root;  //To change body of created methods use File | Settings | File Templates.
    }

    private void createEntryFromDao(List<Entry> entries, DataAccessObjectImpl dao) {
        int id = dao.getId();
        String name = dao.getName();
        int parentId = dao.getParrentId();

        Entry parent = findParent(entries, parentId);
        if(parent == null)
            parent = entries.get(0);
        Entry e = new Entry(id, parent, name, null);
        entries.add(e);
    }

    private Entry findParent(List<Entry> entries, int parentId) {
        for (Entry entry : entries) {
            if(entry.getId()==parentId)
                return entry;
        }
        return null;
    }
}

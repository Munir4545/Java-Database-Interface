import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Manipulate {

    Statement st;

    public Manipulate(String url, String username, String password) throws SQLException {
        Connection con = DriverManager.getConnection(url, username, password);
        this.st = con.createStatement();
    }

    public Manipulate(String url, String password) throws Exception {
        Connection con = DriverManager.getConnection(url, "postgres", password);
        this.st = con.createStatement();
    }


    public void createTable( String name, HashMap<String, String> colNames) throws SQLException {
        // iterate through the col names and save them to a sql string
        // run the sql
        String create = "CREATE TABLE " + name + " (";
        for (String column : colNames.keySet()) {
            create += column + " " + colNames.get(column);
        }

        create += ");";
        st.executeQuery(create);
    }
}

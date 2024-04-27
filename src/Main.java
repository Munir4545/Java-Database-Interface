import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        String create = "CREATE TABLE Persons (\n" +
                "    PersonID int,\n" +
                "    LastName varchar(255),\n" +
                "    FirstName varchar(255),\n" +
                "    Address varchar(255),\n" +
                "    City varchar(255)\n" +
                ");";

        String add = "INSERT INTO Persons VALUES (12, 'Emam', 'Munir', '12341', 'Seattle')";

        String url = "jdbc:postgresql://localhost:5432/javadatabase";
        String username = "postgres";
        String password = "4545";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
       // ResultSet rs = st.executeQuery(create);
        st.executeQuery(add);
        con.commit();
//        System.out.println(rs);
    }
}
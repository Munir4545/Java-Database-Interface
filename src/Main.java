import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {


        String url = "jdbc:postgresql://localhost:5432/javadatabase";
        String username = "postgres";
        String password = "4545";

        Manipulate test = new Manipulate(url, username, password);
        HashMap<String, String> colNames = new HashMap<>();
        colNames.put("name", "varchar(255)");
        test.createTable("Test",colNames);
    }
}

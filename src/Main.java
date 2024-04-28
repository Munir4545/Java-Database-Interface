import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:postgresql://localhost:5432/javadatabase";
        String username = "postgres";
        String password = "4545";

        String[] dbInfo = getDatabaseInfo(scanner);

        DataManipulation test;
        if (dbInfo[1].equals("")) {
            test = new DataManipulation("jdbc:postgresql://localhost:5432/" + dbInfo[0], dbInfo[2]);
        } else {
            test = new DataManipulation("jdbc:postgresql://localhost:5432/" + dbInfo[0], dbInfo[1], dbInfo[2]);
        }
        HashMap<String, String> colNames = new HashMap<>();
        System.out.println("What whill your table name be?");
        String tableName = scanner.nextLine();
        colNames.put("Test", "varchar(255)");
        test.createTable(tableName,colNames);
    }


    public static String[] getDatabaseInfo(Scanner scanner) {
        String[] info = new String[3];
        System.out.println("What is your database name? (No spaces)");
        String dbName = scanner.nextLine();
        System.out.println(dbName);

        System.out.println("What is your Username? (if no username press enter)");
        String userName = scanner.nextLine();
        System.out.println(userName);

        System.out.println("What is your password?");
        String password = scanner.nextLine();
        System.out.println(password);
        info[0] = dbName;
        info[1] = userName;
        info[2] = password;

        return info;
    }
}

import java.sql.*;
import java.sql.DriverManager;


public class DataBase {
    public Connection connect(String dbname, String user, String pass){

        Connection conn = null;

        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname,user,pass);

            if(conn!=null){
                System.out.println("Connection done!");
            }
            else {
                System.out.println("Failed");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }

    public void createTable(Connection conn, String table_name){
        Statement state;

        try {
    String query = "CREATE TABLE " + table_name + " (id SERIAL,money int,PRIMARY KEY (id));";
            state = conn.createStatement();
            state.executeUpdate(query);
            System.out.println("Table created");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addRow(Connection conn, String table_name, int money){
        Statement state;

        try {
            String query = String.format("insert into %s(money) values('%s');", table_name,money);
            state = conn.createStatement();
            state.executeUpdate(query);
            System.out.println("Row inserted!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

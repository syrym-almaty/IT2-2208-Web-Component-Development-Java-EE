import java.sql.Connection;
import java.util.Scanner;

public class Main extends DataBase{
    public static void main(String[] args){
        DataBase db = new DataBase();
        Connection conn = db.connect("BudgetManagerDataBase","Arm","1234");
        db.createTable(conn, "Income");

        System.out.print("Enter 1 if you want to insert data: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1){
            db.addRow(conn, "Income", 10000);
        }

    }
}
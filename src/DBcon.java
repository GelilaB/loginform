import java.sql.Connection;
import java.sql.DriverManager;
public class DBcon{
      
public Connection connection;

public Connection getconnection(){
      
    String DatabaseName = "java_fx";
    String user = "root" ;
    String password = "root";
     String url = "jdbc:mysql://localhost:3306/"+DatabaseName;

    try {
        connection = DriverManager.getConnection(url, user, password);
    } catch (Exception e) {
      System.out.println(e);
    }
    return connection;
}

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {

    Connection connection;
    Statement statement;
    Database(){
        //URL is case sensitive
        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/fitness?useSSL=false&serverTimezone=UTC","root","Komal@325740");
            statement = connection.createStatement();
        }catch(Exception e){
            e.printStackTrace();

        }


    }
}

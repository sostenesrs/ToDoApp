package ToDoApp;
import java.sql.Connection;
import java.sql.DriverManager;
import util.ConnectionFactory;

/**
 *
 * @author sostenes.rodrigues
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Connection c = ConnectionFactory.getConection();
        ConnectionFactory.closeConnection(c);
        
        
        
    }
    
}

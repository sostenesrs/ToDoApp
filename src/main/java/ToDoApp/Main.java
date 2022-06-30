package ToDoApp;
import controller.ProjectController;
import java.sql.Connection;
import java.sql.DriverManager;
import model.Project;
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
        ProjectController projectController = new ProjectController();;
        
        Project project = new Project();
        
        project.setName("Projeto teste");
        project.setDescription("description");
        projectController.save(project);
        
        
        
    }
    
}

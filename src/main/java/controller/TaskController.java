/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;


/**
 *
 * @author sostenes.rodrigues
 */
public class TaskController {
    
    public void save(Task task){
        
        String sql = "INSERT INTO tasks (idProject, name, description, completed, notes, deadline, createdAt, updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa"+ ex.getMessage(), ex);

        }finally{
            ConnectionFactory.closeConnection(connection);
        }
        
    }
    
    public void update (Task task){
        
    }
    
    public void removeById(Task taskId){
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar a tarefa", e);
            
        } finally{
            ConnectionFactory.closeConnection(conn);
        }
        
        
        
        
    }
    
    public List <Task> getAll(int idProject){
        return null;
    }
    
}

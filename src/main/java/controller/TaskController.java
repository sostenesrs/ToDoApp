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
            ConnectionFactory.closeConnection(connection, statement);
            
            
        }
        
    }
    
    public void update (Task task){
        
        String sql = "UPDATE tasks SET idProject = ?, name = ?, description = ?, status = ?, notes = ?, deadline = ?, completed = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //estabelece a conexao com o banco de dados
            connection = ConnectionFactory.getConection();
            //preparando a query
            statement = connection.prepareStatement(sql);
            //setando os valores do statement
            statement.setInt     (1, task.getIdProject());
            statement.setString  (2, task.getName());
            statement.setString  (3, task.getDescription());
            statement.setString  (4, task.getNotes());
            statement.setBoolean (5, task.isIsCompleted());
            statement.setDate    (6, new java.sql.Date(task.getDeadline().getTime()));
            statement.setDate    (7, new java.sql.Date(task.getCreatedAt().getTime()));
            statement.setDate    (8, new java.sql.Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            
            //executando a query
            statement.execute();
            
            
        } catch (Exception ex) {
            throw  new RuntimeException("Erro ao atualizar a tarefa" + ex.getMessage(), ex);
        }
    }
    
    
    
    
    public void removeById(Task id){
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //criação da conexão com banco
            connection = ConnectionFactory.getConection();
            
            //preparando a query
            statement = connection.prepareStatement(sql);
            //setando os valores do statement
            statement.setInt(1, id);
            //executando a query
            statement.execute();
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar a tarefa" +ex.getMessage());
            
        } finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
        
        
        
        
    }
    
    public List <Task> getAll(int idProject){
        
        String sql ="SELECT * FROM tasks WHERE idProject =?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        ResultSet resultSet = null;
        //lista de tarefas que sera deovlvida quando o metodo for chamado
        List<Task> tasks = new ArrayList<Task>();
        
        try {
            //criação da conexão
            connection = ConnectionFactory.getConection();
            statement = connection.prepareStatement(sql);
            //setando o valor que corresponde ao filtro de busca
            statement.setInt(1,idProject);
            //valor retornado pelo query
            resultSet = statement.executeQuery();
            
            //enquanto houverem valores a serem percorridos no resultset
            while (resultSet.next()) {                
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getNString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setNotes(resultSet.getString("notes"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                tasks.add(task);
            }
            
            
        } catch (Exception ex) {
                        throw new RuntimeException("Erro ao inserir a tarefa" +ex.getMessage());

        } finally{
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        //lista de tarefas que foi criada e carregada do banco
        return tasks;
        
    }
    
}

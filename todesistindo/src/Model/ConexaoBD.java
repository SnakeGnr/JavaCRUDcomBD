/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ConexaoBD {
     
    
    public Connection getConnection (){
       
        try{
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Adao", "postgres", "aluno");
            
        }catch (SQLException e){
           throw new RuntimeException(e);
        }
    }
    
    
}

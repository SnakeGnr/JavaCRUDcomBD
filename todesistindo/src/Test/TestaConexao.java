/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import Model.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * @author Adão Lima
 */
public class TestaConexao {
    
    public static void main(String[] args) throws SQLException {
            Connection con = null;
        try{
             con = new ConexaoBD().getConnection();
        System.out.println("Conexão Aberta !");
        
        String sql = "Insert into Cliente"
                + "(nome,email, cep, endereco, telefone, dataNasc) "
                + "values (?, ?, ?, ?, ?, ?) ";
        
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setString(1, "Adao");
        st.setString(2, "adaognr.lima@gmail.com");
        st.setInt(3, 83420000);
        st.setString(4, "Rua da Paz, 460 - Ctba");
        st.setString(5, "9898-9696");
        st.setString(6, "21/10/1995");
        
        st.execute();
        st.close();
        
        System.out.println("Gravado com Sucesso !");
        
        }catch(Exception e){
          throw new  RuntimeException(e);
        }finally{
            con.close();
        }
        
    }

}

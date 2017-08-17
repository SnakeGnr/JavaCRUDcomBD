/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import Model.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestaConsulta {

    public static void main(String[] args) throws SQLException{
        Connection con = new ConexaoBD().getConnection();
       
        PreparedStatement st = con.prepareStatement("select * from Cliente");
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()){
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            
            System.out.println(nome + " :: "+ email);
        }
        st.close();
        con.close();
        
    }
    
}

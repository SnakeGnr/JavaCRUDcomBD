/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import Model.Cliente;
import Model.ClienteDao;
import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author SnakeGnr
 */
public class TestaConsulta2 {

    public static void main(String[] args)  {
        
        try {
            ClienteDao dao = new ClienteDao();
            //cria uma lista para receber a lista de carros da DAO
            List<Cliente> clientes = dao.consulta();
            
            for(Cliente cli : clientes){
                System.out.println("ID: "+ cli.getId());
                System.out.println("Nome: "+ cli.getNome());
                System.out.println("Email: "+ cli.getEmail());
                System.out.println("CEP: "+ cli.getCep());
                System.out.println("Endereco: "+ cli.getEndereco());
                System.out.println("Telefone: "+ cli.getTelefone());
                System.out.println("Data de Nascimento: "+ cli.getDataNasc());
                System.out.println("------------------------------------------");
            }
            
        } catch (Exception e) {
        throw new RuntimeException(e);
        }
        
    }
}

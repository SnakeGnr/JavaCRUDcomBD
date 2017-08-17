/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import Model.Cliente;
import Model.ClienteDao;
import java.util.*;
/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestaRemove {
static Scanner in = new Scanner (System.in);
    public static void main(String[] args) {
        Cliente cli = new Cliente();
        
        System.out.println("Informe o ID do Cliente que deseja excluir: ");
        cli.setId(in.nextInt());
        
        ClienteDao dao = new ClienteDao();
        
        dao.remove(cli);
        System.out.println("Cliente Removido com sucesso!");
        
    }
    
}

/*-
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import Model.*;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestaInsere {

    public static void main(String[] args) {
        
        Cliente c = new Cliente();
        
        c.setNome("Caelum");
        c.setEmail("contato@caelum.com");
        c.setCep(83420000);
        c.setEndereco("Rua Vinte e Cinco");
        c.setTelefone("9898-9999");
        c.setDataNasc("06/06/1995");
        
        ClienteDao cdao = new ClienteDao();
    
        cdao.adiciona(c);
        
        System.out.println("Cadastro do Objeto Efetuado com Sucesso!");
    }
    
}

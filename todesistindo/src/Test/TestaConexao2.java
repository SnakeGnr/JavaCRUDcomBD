/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Model.Carro;
import Model.CarroDao;
import Model.ConexaoBD2;
import java.util.List;

/**
 *
 * @author SnakeGnr
 */
public class TestaConexao2 {

    public static void main(String[] args) {
        testaConsulta();
    }

    public static void teste() {

        ConexaoBD2 conecta = new ConexaoBD2();

        conecta.criaConexao();
        conecta.desconecta();
    }

    public static void testaCadastro() {

        Carro car = new Carro("Golf GTI", "Volkswagen", 2017, 50000);

        CarroDao cDao = new CarroDao();
        cDao.adicionaCarro(car);

    }

    public static void testaConsulta() {
        CarroDao cDao = new CarroDao();
         List<Carro> meusCarros = cDao.consulta();
         
         for(Carro car: meusCarros){
             System.out.println("Id_Carro: "+ car.getId_carro());
             System.out.println("Modelo: "+ car.getModelo());
             System.out.println("Marca: "+ car.getMarca());
             System.out.println("Ano: "+ car.getAno());
             System.out.println("Valor: "+ car.getValor());
             System.out.println("----------------------");
         }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Carro;
import Model.CarroDao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author SnakeGnr
 */
public class Main {

    static BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {
        int op = 0;

        while (op != 5) {
            System.out.println("------MENU CARRO SQL-------");
            System.out.println("1 - Cadastrar ");
            System.out.println("2 - Consultar ");
            System.out.println("3 - Alterar ");
            System.out.println("4 - Remover");
            System.out.println("5 - Sair");
            System.out.println("----------------------");
            
            op = Integer.valueOf(leitor.readLine());
            switch (op) {
                case 1:
                    cadastra();
                    break;

                case 2:
                    consulta();
                    break;

                case 3:
                    altera();
                    break;

                case 4:
                    remove();
                    break;
                default:
                    System.out.println("Informe uma opção válida!!!");
                    break;
            }
        }
    }

    public static void consulta() throws IOException {
        CarroDao cDao = new CarroDao();
        List<Carro> meusCarros = cDao.consulta();

        for (Carro car : meusCarros) {
            System.out.println("Id_Carro: " + car.getId_carro());
            System.out.println("Modelo: " + car.getModelo());
            System.out.println("Marca: " + car.getMarca());
            System.out.println("Ano: " + car.getAno());
            System.out.println("Valor: " + car.getValor());
            System.out.println("----------------------");
        }

        menu();
    }

    public static void cadastra() throws IOException {
        try {
            Carro car = new Carro();
            System.out.print("Informe o Modelo: ");
            car.setModelo(leitor.readLine());
            System.out.print("Informe a Marca: ");
            car.setMarca(leitor.readLine());
            System.out.print("Informe o Ano: ");
            car.setAno(Integer.valueOf(leitor.readLine()));
            System.out.print("informe o Valor: ");
            car.setValor(Double.valueOf(leitor.readLine()));

            CarroDao cDao = new CarroDao();
            cDao.adicionaCarro(car);

           // System.out.println("Carro Cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro no cadastro!!!" + e.getMessage());
        }
        menu();
    }

    public static void altera() throws IOException {

        try {
            Carro car = new Carro();
            System.out.println("Informe o id do carro que deseja alterar: ");
            car.setId_carro(Integer.valueOf(leitor.readLine()));
            System.out.print("Informe o novo Modelo: ");
            car.setModelo(leitor.readLine());
            System.out.print("Informe a nova Marca: ");
            car.setMarca(leitor.readLine());
            System.out.print("Informe o novo Ano: ");
            car.setAno(Integer.valueOf(leitor.readLine()));
            System.out.print("informe o novo Valor: ");
            car.setValor(Double.valueOf(leitor.readLine()));

            CarroDao cDao = new CarroDao();
            cDao.altera(car);

           // System.out.println("Carro Alterado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro na alteração!!!" + e.getMessage());
        }

        menu();

    }

    public static void remove() throws IOException {

        try {
            Carro car = new Carro();
            System.out.println("Informe o id do carro que deseja REMOVER: ");
            car.setId_carro(Integer.valueOf(leitor.readLine()));

            CarroDao cDao = new CarroDao();
            cDao.remove(car);

           // System.out.println("Carro Alterado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro na alteração!!!" + e.getMessage());
        }
        menu();
    }

}

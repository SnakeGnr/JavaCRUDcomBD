/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SnakeGnr
 */
public class CarroDao {

    private ConexaoBD2 conecta = new ConexaoBD2();

    public void adicionaCarro(Carro car) {
        conecta.criaConexao();

        String sql = "Insert into Carro (modelo, marca, ano, valor) values (?,?,?,?)";

        try {
            //prepara o tratamento dos dados
            PreparedStatement st = conecta.con.prepareStatement(sql);

            //monta o objeto carro
            st.setString(1, car.getModelo());
            st.setString(2, car.getMarca());
            st.setInt(3, car.getAno());
            st.setDouble(4, car.getValor());

            st.execute();
            System.out.println("Carro cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao adicionar um carro: " + e);
        } finally {
            //faz com que seja obrigatorio, independente de erro ou sucesso!
            conecta.desconecta();
        }
    }

    public List<Carro> consulta() {
        conecta.criaConexao();
        try {
            List<Carro> carros = new ArrayList<Carro>();

            String sql = "select * from Carro";
            PreparedStatement st = conecta.con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Carro car = new Carro();
                car.setId_carro(rs.getInt("id_carro"));
                car.setModelo(rs.getString("modelo"));
                car.setMarca(rs.getString("marca"));
                car.setAno(rs.getInt("ano"));
                car.setValor(rs.getDouble("valor"));
                carros.add(car);
            }
            rs.close();
            st.close();
            System.out.println("sucesso");
            return carros;

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            conecta.desconecta();
        }
    }

    public void remove(Carro car) {
        conecta.criaConexao();
        try {
            PreparedStatement st = conecta.con.prepareStatement("delete "
                    + "from Carro where id_carro = ?");
            st.setInt(1, car.getId_carro());

            st.execute();
            st.close();
        } catch (SQLException e) {
            System.out.println("Erro na remoção: " + e.getMessage());
        } finally {
            conecta.desconecta();
        }
    }

    public void altera(Carro car) {
        conecta.criaConexao();
        String sql = "update Carro set "
                + "modelo=?, marca=?, ano=?, valor=? where id_carro =? ";

        try {
            PreparedStatement st = conecta.con.prepareStatement(sql);

            st.setString(1, car.getModelo());
            st.setString(2, car.getMarca());
            st.setInt(3, car.getAno());
            st.setDouble(4, car.getValor());
            st.setInt(5, car.getId_carro());

            st.execute();
            st.close();

            System.out.println("Carro Alterado com sucesso! ");

        } catch (SQLException e) {
            System.out.println("Erro na alteração: " + e.getMessage());
        } finally {
            conecta.desconecta();
        }
    }

}

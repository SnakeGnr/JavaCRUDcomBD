/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ClienteDao {

    private Connection con;

    public ClienteDao() {
        this.con = new ConexaoBD().getConnection();
    }

    public void adiciona(Cliente cli) {
        String sql = "Insert into Cliente"
                + "(nome,email, cep, endereco, telefone, dataNasc) "
                + "values (?, ?, ?, ?, ?, ?) ";

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, cli.getNome());
            st.setString(2, cli.getEmail());
            st.setInt(3, cli.getCep());
            st.setString(4, cli.getEndereco());
            st.setString(5, cli.getTelefone());
            st.setString(6, cli.getDataNasc());

            st.execute();
            st.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> consulta() {

        try {
            List<Cliente> clientes = new ArrayList<Cliente>();
            PreparedStatement st = this.con.prepareStatement("select * from Cliente");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setEmail(rs.getString("email"));
                cli.setCep(rs.getInt("cep"));
                cli.setEndereco(rs.getString("endereco"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setDataNasc(rs.getString("dataNasc"));

                clientes.add(cli);
            }
            rs.close();
            st.close();
            return clientes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Cliente cli) {
        try {
            PreparedStatement st = con.prepareStatement("delete "
                    + "from Cliente where id = ?");
            st.setInt(1, cli.getId());

            st.execute();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Cliente cli) {
        String sql = "update Cliente set "
                + "nome=?, email=?, cep=?, endereco=?, telefone=?, dataNasc=? ";

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, cli.getNome());
            st.setString(2, cli.getEmail());
            st.setInt(3, cli.getCep());
            st.setString(4, cli.getEndereco());
            st.setString(5, cli.getTelefone());
            st.setString(6, cli.getDataNasc());

            st.execute();
            st.close();

            System.out.println("Cliente Alterado com sucesso! ");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

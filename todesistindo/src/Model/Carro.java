/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 * 
 * @author SnakeGnr
 */
public class Carro {
    private int id_carro;
    private String modelo;
    private String marca;
    private int ano;
    private double valor;

    public Carro() {
    }

    public Carro(String modelo, String marca, int ano, double valor) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.valor = valor;
    }

    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the id_carro
     */
    public int getId_carro() {
        return id_carro;
    }

    /**
     * @param id_carro the id_carro to set
     */
    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
    }
    
    
}

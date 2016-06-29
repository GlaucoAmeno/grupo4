/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Rodrigo Kuya
 */
@Entity(name="produto")
public class Produto implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="idProduto")
    private int idProduto;
    @Column(name="nomeProduto")
    private String nomeProduto;
    @Column(name="tipoProduto")
    private String tipoProduto;
    @Column(name="precoProduto")
    private double precoProduto;
    @Column(name="qtdProduto")
    private int qtdProduto;

    public Produto(int idProduto, String nomeProduto, String tipoProduto, double precoProduto, int qtdProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.tipoProduto = tipoProduto;
        this.precoProduto = precoProduto;
        this.qtdProduto = qtdProduto;
    }
    
    public Produto (){
        
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }
    
    public String toString(){
        return "ID: " + this.idProduto + " Nome: " + this.nomeProduto;
    }
}

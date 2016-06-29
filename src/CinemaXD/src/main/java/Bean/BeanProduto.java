/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.Crud;
import classes.Produto;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Rodrigo Kuya
 */
@ManagedBean
@SessionScoped
public class BeanProduto implements Serializable {

    Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String inserir(ActionEvent actionEvent) {
        Crud dao = new DAO.BeanProduto();
        dao.inserir(produto);
        return "index";
    }

    public String remover(ActionEvent actionEvent) {
        Crud dao = new DAO.BeanProduto();
        dao.remover(produto.getIdProduto());
        return "index";
    }

    public List<Produto> listar() {
        Crud dao = new DAO.BeanProduto();
        List<Produto> l = new ArrayList();
        l = dao.lista();
        return l;
    }

    public String alterar(ActionEvent actionEvent) {
        Crud dao = new DAO.BeanProduto();
        dao.alterar(produto);
        return "index";
    }

    public String prepararAlterarProduto(ActionEvent actionEvent) {
        produto = new Produto();
        return "AlterarProduto";
    }
    
    public void prepararProduto(ActionEvent actionEvent) {
        produto = new Produto();
    }

}

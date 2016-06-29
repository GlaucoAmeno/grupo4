/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.Crud;
import DAO.BeanProduto;
import classes.Combo;
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
public class BeanCombo implements Serializable{
    Combo combo;
    List<String> listProd = new ArrayList();

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }
    
    public void prepararCombo(ActionEvent actionEvent){
        combo = new Combo();
    }
    
    public void adicionaProd(Produto p){
        listProd.add(p.getNomeProduto());
    }
    
    public String inserir(ActionEvent actionEvent) {
        Crud dao = new DAO.BeanCombo();
        dao.inserir(combo);
        return "index";
    }
    
    public String remover(ActionEvent actionEvent) {
        Crud dao = new DAO.BeanCombo();
        dao.remover(combo.getIdCombo());
        return "index";
    }
    
    public List<Combo> listar() {
        Crud dao = new DAO.BeanCombo();
        List<Combo> l = new ArrayList();
        l = dao.lista();
        return l;
    }

}

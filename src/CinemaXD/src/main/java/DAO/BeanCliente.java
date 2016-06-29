/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import RecomendacaoFilmes.ConectaBanco;
import classes.Cliente;
import classes.Filmes;
import classes.PerfilFilme;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "crCliente")
@RequestScoped
public class BeanCliente implements Serializable {

    Cliente cli = new Cliente();
    
    @PostConstruct
    public void init() {

    }
    
    public String inserCliente(ActionEvent e){
        
        try {
            ConectaBanco.createUsuario(cli);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BeanCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BeanCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "index";
    }

    public Cliente getCli() {
        return cli;
    }

    public void setFm(Cliente cli) {
        this.cli = cli;
    }

   
}

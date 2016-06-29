/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import RecomendacaoFilmes.ConectaBanco;
import classes.Cliente;
import classes.SessionUtils;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "vlLogin")
@SessionScoped
public class ValidateLogin implements Serializable {

    Cliente cli = new Cliente();
    Boolean admin = false;

    @PostConstruct
    public void init() {

    }

    public String validaLogin(ActionEvent e) {
        boolean l = false;
        String page = "";
        try {

            l = ConectaBanco.verifyLogin(cli);
            if (cli.getNome().equals("admin")) {
                if (l) {
                    page = "MenuPrincipalUsuario";
                    admin = true;
                }
            } else {
                page = l ? "ListagemCinema" : "login";
                admin = false;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BeanCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BeanCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return page;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setFm(Cliente cli) {
        this.cli = cli;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    
    

}

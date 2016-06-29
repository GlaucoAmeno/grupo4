/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import RecomendacaoFilmes.ConectaBanco;
import classes.Cinema;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "crCinema")
@RequestScoped
public class BeanCinema implements Serializable {

    Cinema cin = new Cinema();
    String cinemaEscolhido;
    int showButton = 0;

    @PostConstruct
    public void init() {

    }

    public String selectCinema(ActionEvent e, String cn) throws InterruptedException {
        try {
            System.out.println("id cinema" + cin.getId());
            cin = ConectaBanco.selectCinema(cn);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        showButton = 1;
        return "CadCinema";
    }

    public String inserCinema(ActionEvent e) {

        try {
            ConectaBanco.createCinema(cin);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BeanCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BeanCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        showButton = 0;
        return "ListagemCinema";

    }

    public String updateCinema(ActionEvent e) throws ClassNotFoundException, SQLException {
        ConectaBanco.updateCinema(cin);
        return "ListagemCinema";
    }

    public String deleteCinema(ActionEvent e, int id) throws ClassNotFoundException, SQLException {
        ConectaBanco.deleteCinema(id);
        return "ListagemCinema";
    }

    public String escolheCinemaFilme(ActionEvent e, String cn) {
        cinemaEscolhido = cn;
        return "ListagemFilmes";
    }

    public Cinema getCin() {
        return cin;
    }

    public void setCin(Cinema cin) {
        this.cin = cin;
    }

    public int getShowButton() {
        return showButton;
    }

    public void setShowButton(int showButton) {
        this.showButton = showButton;
    }

    public String getCinemaEscolhido() {
        return cinemaEscolhido;
    }

    public void setCinemaEscolhido(String cinemaEscolhido) {
        this.cinemaEscolhido = cinemaEscolhido;
    }
    
    

}

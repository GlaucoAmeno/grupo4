/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import RecomendacaoFilmes.ConectaBanco;
import classes.Filmes;
import classes.PerfilFilme;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "crFilmes")
@RequestScoped
public class BeanFilmes implements Serializable {

    Filmes fm = new Filmes();
    String nomeFilme;
    PerfilFilme pf = new PerfilFilme();
    int idFilme;
    int showButton = 0;

    double acao;
    double terror;
    double comedia;
    double romance;
    double documentario;
    double drama;
    double animacao;
    double suspense;

    @PostConstruct
    public void init() {

    }

    public String selectFilme(ActionEvent e, String nf) throws InterruptedException {
        try {
            fm = ConectaBanco.selectFilme(nf);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        showButton = 1;
        return "CadFilmes";
    }

    public String inserir(ActionEvent e) {
        try {
            pf.setAcao(acao);
            pf.setAnimacao(animacao);
            pf.setComedia(comedia);
            pf.setDocumentario(documentario);
            pf.setDrama(drama);
            pf.setRomance(romance);
            pf.setSuspense(suspense);
            pf.setTerror(terror);
            fm.setPerfil(pf);

            ConectaBanco.createFilmes(fm);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BeanFilmes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BeanFilmes.class.getName()).log(Level.SEVERE, null, ex);
        }
        showButton = 0;
        return "ListagemFilmes";
    }

    public String updateFilme(ActionEvent e) throws ClassNotFoundException, SQLException {

        System.out.println("fmss id " + fm.getId());
        System.out.println("fmss diretor " + fm.getDiretor());
        System.out.println("fmss lancamento " + fm.getDataLancamento());
        ConectaBanco.updateFilme(fm);
        return "ListagemFilmes";
    }

    public String deleteFilme(ActionEvent e, int id) throws ClassNotFoundException, SQLException {
        System.out.println("id index" + id);
        ConectaBanco.deleteFilme(id);
        return "ListagemFilmes";
    }

    public Filmes getFm() {
        return fm;
    }

    public void setFm(Filmes fm) {
        this.fm = fm;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public int getShowButton() {
        return showButton;
    }

    public void setShowButton(int showButton) {
        this.showButton = showButton;
    }

    public double getAcao() {
        return acao;
    }

    public void setAcao(double acao) {
        this.acao = acao;
    }

    public double getTerror() {
        return terror;
    }

    public void setTerror(double terror) {
        this.terror = terror;
    }

    public double getComedia() {
        return comedia;
    }

    public void setComedia(double comedia) {
        this.comedia = comedia;
    }

    public double getRomance() {
        return romance;
    }

    public void setRomance(double romance) {
        this.romance = romance;
    }

    public double getDocumentario() {
        return documentario;
    }

    public void setDocumentario(double documentario) {
        this.documentario = documentario;
    }

    public double getDrama() {
        return drama;
    }

    public void setDrama(double drama) {
        this.drama = drama;
    }

    public double getAnimacao() {
        return animacao;
    }

    public void setAnimacao(double animacao) {
        this.animacao = animacao;
    }

    public double getSuspense() {
        return suspense;
    }

    public void setSuspense(double suspense) {
        this.suspense = suspense;
    }
    
}

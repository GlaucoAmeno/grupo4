/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import RecomendacaoFilmes.ConectaBanco;
import classes.Ingresso;
import java.sql.SQLException;
import javax.faces.event.ActionEvent;
import classes.Filmes;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean(name = "crudIngresso")
@SessionScoped
public class BeanIngresso {

    Ingresso ingresso = new Ingresso();
    Filmes filme = new Filmes();

    public BeanIngresso() {
        ingresso.setValor(20.5);
    }

    public String comprarIngresso(ActionEvent ae, String nomeFilme) throws ClassNotFoundException, SQLException {        
        System.out.println("NOME -> " +nomeFilme);
        filme = ConectaBanco.selectFilme(nomeFilme);
        ingresso.setIdFilme(filme.getId());
        System.out.println("** IdFILME: "+ ingresso.getIdFilme()+" - DATA - : " +ingresso.getDataFilme() + " - SALA - " + ingresso.getSala() + " - HORARIO: "+ingresso.getHorario()+"  ****");
        ConectaBanco.createIngresso(ingresso);
        return "index";
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }

    public String carregarFilme(ActionEvent ae, String nome) throws ClassNotFoundException, SQLException {
        try {
            filme = ConectaBanco.selectFilme(nome);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return "CadIngressos";
    }

    public Filmes getFilme() {
        return filme;
    }

    public void setFilme(Filmes filme) {
        this.filme = filme;
    }
        
}

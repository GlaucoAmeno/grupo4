/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.Produto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Rodrigo Kuya
 */
@Entity(name = "combo")
public class Combo implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "idCombo")
    private int idCombo;
    @Column(name = "valorCombo")
    private double valorCombo;
    @Column(name = "definicaoCombo")
    private String definicaoCombo;

    public Combo(int idComb, double valorCombo, String definicaoCombo) {
        this.idCombo = idCombo;
        this.valorCombo = valorCombo;
        this.definicaoCombo = definicaoCombo;
    }

    public Combo() {
    }

    public int getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(int idCombo) {
        this.idCombo = idCombo;
    }

    public double getValorCombo() {
        return valorCombo;
    }

    public void setValorCombo(double valorCombo) {
        this.valorCombo = valorCombo;
    }

    public String getDefinicaoCombo() {
        return definicaoCombo;
    }

    public void setDefinicaoCombo(String definicaoCombo) {
        this.definicaoCombo = definicaoCombo;
    }

   

}

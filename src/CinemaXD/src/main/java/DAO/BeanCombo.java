/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.Combo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rodrigo Kuya
 */
public class BeanCombo implements Crud {

    @Override
    public void inserir(Object c) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = ss.beginTransaction();
        try {
            ss.save((Combo) c);
            ts.commit();
        } catch (Exception ex) {
            ts.rollback();
            throw ex;
        } finally {
            HibernateUtil.close(ss);
        }
    }

    @Override
    public void alterar(Object p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(int id) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = ss.beginTransaction();
        try {
            ss.createQuery("DELETE FROM combo WHERE idCombo =" + id).executeUpdate();
            ts.commit();
        } catch (Exception ex) {
            ts.rollback();
            throw ex;
        } finally {
            HibernateUtil.close(ss);
        }
    }

    @Override
    public List lista() {
        Transaction ts = null;
        Session ss = HibernateUtil.getSessionFactory().openSession();
        try {
            /*Query q = ss.createQuery("SELECT idProduto,nomeProduto FROM produto");
            List listar = q.list();*/
            ts = ss.beginTransaction();
            List listar = ss.createQuery("FROM combo").list();
            ss.getTransaction().commit();
            //ts.commit();
            return listar;
        } catch (Exception ex) {
            ts.rollback();
            throw ex;
        } finally {
            HibernateUtil.close(ss);
        }
    }

    @Override
    public Object findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

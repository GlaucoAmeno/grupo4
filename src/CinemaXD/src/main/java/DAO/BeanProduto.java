/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.Produto;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rodrigo Kuya
 */
public class BeanProduto implements Crud {

    @Override
    public void inserir(Object p) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = ss.beginTransaction();
        try {
            ss.save((Produto) p);
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
        Transaction ts = null;
        Session ss = HibernateUtil.getSessionFactory().openSession();
        try {
            ts = ss.beginTransaction();
            ss.update((Produto) p);
            ss.getTransaction().commit();
            //ss.createQuery("UPDATE produto SET nomeProduto,tipoProduto,precoProduto,qtdProduto WHERE idProduto =" + id).executeUpdate();
            //ts.commit();
        } catch (Exception ex) {
            if (ts != null) {
                ts.rollback();
            }
            throw ex;
        } finally {
            HibernateUtil.close(ss);
        }
    }

    @Override
    public void remover(int id) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = ss.beginTransaction();
        try {
            ss.createQuery("DELETE FROM produto WHERE idProduto =" + id).executeUpdate();
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
        //Session ss = HibernateUtil.getSessionFactory().openSession();
        //Transaction ts = ss.beginTransaction();

        Transaction ts = null;
        Session ss = HibernateUtil.getSessionFactory().openSession();
        try {
            /*Query q = ss.createQuery("SELECT idProduto,nomeProduto FROM produto");
            List listar = q.list();*/
            ts = ss.beginTransaction();
            List listar = ss.createQuery("FROM produto").list();
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
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Transaction ts = ss.beginTransaction();
        return ss.createQuery("SELECT idProduto from produto WHERE idProduto = id");
    }

}

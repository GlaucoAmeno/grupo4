/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.fasterxml.classmate.AnnotationInclusion;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Rodrigo Kuya
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = (SessionFactory) new AnnotationConfiguration.StdConfiguration(AnnotationInclusion.DONT_INCLUDE);
            
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close(Session session) {
        if (session != null) {
            try {
                session.close();
            } catch (HibernateException h) {
                System.out.println("Não fechou.");
                h.printStackTrace();
            }
        }
    }
}

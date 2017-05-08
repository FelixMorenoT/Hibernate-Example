/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Noticias;
import Modelo.Usuarios;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author felixmoreno
 */
public class Controlador {

    public void InsertUser(Usuarios user) {
        SessionFactory SessionFactory = NewHibernateUtil.getSessionFactory();
        Session Session;

        Session = SessionFactory.openSession();
        Transaction tx = Session.beginTransaction();
        Session.save(user);
        tx.commit();
        Session.close();
        JOptionPane.showMessageDialog(null, "Creacion Correcta");
    }

    public Usuarios FindUser(String user) {
        Usuarios SearchUser;
        SessionFactory SessionFactory = NewHibernateUtil.getSessionFactory();
        Session Session;

        Session = SessionFactory.openSession();
        Transaction tx = Session.beginTransaction();
        SearchUser = (Usuarios) Session.get(Usuarios.class, user);
        tx.commit();
        Session.close();

        return SearchUser;
    }

    public void InsertNews(Noticias news) {
        SessionFactory SessionFactory = NewHibernateUtil.getSessionFactory();
        Session Session;

        Session = SessionFactory.openSession();
        Transaction tx = Session.beginTransaction();
        Session.save(news);
        tx.commit();
        Session.close();
        JOptionPane.showMessageDialog(null, "Noticia Creada");

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Noticias;
import Modelo.Usuarios;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
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

    public DefaultListModel ShowNoticias() {
        DefaultListModel AuxDLM = new DefaultListModel();

        SessionFactory SessionFactory = NewHibernateUtil.getSessionFactory();
        Session Session;

        Session = SessionFactory.openSession();
        Transaction tx = Session.beginTransaction();

        Query Query = Session.createQuery("from Noticias");
        List<Noticias> Consulta = Query.list();
        Iterator<Noticias> ConsultaIterador = Consulta.iterator();

        tx.commit();
        Session.close();

        while (ConsultaIterador.hasNext()) {
            Noticias News = (Noticias) ConsultaIterador.next();
            AuxDLM.addElement(News);
        }
        return AuxDLM;
    }

    public void DeleteNews(String User, String Titu) {
        SessionFactory SessionFactory = NewHibernateUtil.getSessionFactory();
        Session Session;

        Session = SessionFactory.openSession();
        Transaction tx = Session.beginTransaction();

        Query Query = Session.createQuery("Delete Noticias where Titulo_Noticia='"+Titu+"' and Usuario_Nick='"+User+"'");
 
        Query.executeUpdate();
        tx.commit();
        Session.close();
        JOptionPane.showMessageDialog(null, "Noticia Eliminada");
    }
}

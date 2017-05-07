/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Usuarios;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author felixmoreno
 */
public class Controlador {
    
    public void InsertUser(Usuarios user){
        NewHibernateUtil newHibernateUtil = new NewHibernateUtil();
        SessionFactory SessionFactory = newHibernateUtil.getSessionFactory();
        Session Session;
        
        Session = SessionFactory.openSession();
        Transaction tx = Session.beginTransaction();
        Session.save(user);
        tx.commit();
        Session.close();
        JOptionPane.showMessageDialog(null, "Creacion Correcta");
        
    }
    
    
}

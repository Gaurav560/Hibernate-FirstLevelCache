package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


// 1st level caching happens in same session .
// only one query generated for similar request(internally provided in
// hibernate)

public class App {

    public static void main(String[] args) {


//        Alien telusko = new Alien();
//        telusko.setAid(110);
//        telusko.setAname("NavinReddy1");
//        telusko.setColor("Green");
//
//        Alien telusko1 = new Alien();
//        telusko1.setAid(111);
//        telusko1.setAname("NavinReddy2");
//        telusko1.setColor("Red");
//
//
//        Alien telusko2 = new Alien();
//        telusko2.setAid(112);
//        telusko2.setAname("NavinReddy3");
//        telusko2.setColor("Blue");


        Alien a = null;


        //creating session object
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionfactory = con.buildSessionFactory(reg);
        System.out.println(sessionfactory);
        Session session1 = sessionfactory.openSession();


        Transaction tx = session1.beginTransaction();
        a = (Alien) session1.get(Alien.class, 110);
        System.out.println(a);
        tx.commit();
        session1.close();


        Session session2 = sessionfactory.openSession();
        Transaction tx1 = session2.beginTransaction();
        a = (Alien) session2.get(Alien.class, 110);
        System.out.println(a);


        //persisting alien objects in database
//        session.persist(telusko);
//        session.persist(telusko1);
//        session.persist(telusko2);


        tx1.commit();
        session2.close();


    }
}
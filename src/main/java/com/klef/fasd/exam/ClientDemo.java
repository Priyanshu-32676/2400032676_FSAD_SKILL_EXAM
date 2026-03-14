package com.klef.fasd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class ClientDemo {

    public static void main(String[] args) {

        StandardServiceRegistry ssr =
                new StandardServiceRegistryBuilder().configure("hibernatecnfg.xml").build();

        Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory sf = md.getSessionFactoryBuilder().build();

        Session s = sf.openSession();

        Transaction t = s.beginTransaction();

        ShipmentEntity p1 = new ShipmentEntity();

        p1.setId(103);
        p1.setName("Washing Machine");
        p1.setDate("12th March 2026");
        p1.setStatus("Pending");

        s.save(p1);


        t.commit();

       

        System.out.println("Record inserted successfully");
        
        Query q = s.createQuery("FROM ShipmentEntity e where id:sid");
        q.setParameter("sid", 101);
        s.delete(q);
        System.out.println("REcord deleted successfully");
    }
}
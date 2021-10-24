package com.example.demo.school;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SingleSessionFactory {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() throws Exception{
        if (sessionFactory == null) {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            try {
                return sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            }
            catch (Exception e) {
                StandardServiceRegistryBuilder.destroy( registry );
            }
        }
        return sessionFactory;
    }
}

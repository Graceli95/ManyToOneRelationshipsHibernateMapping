package com.Li;

import com.Li.model.Department;
import com.Li.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        manyToOne();
    }

    public static void manyToOne() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        //creating departments
        Department dept1 = new Department("IT");
        Department dept2 = new Department("HR");

        //creating teachers
        Teacher t1 = new Teacher(1000,"MHaseeb",dept1);
        Teacher t2 = new Teacher(2220,"Shahparan",dept1);
        Teacher t3 = new Teacher(3000,"James",dept1);
        Teacher t4 = new Teacher(40000,"Joseph",dept2);

//storing departments in database
        session.persist(dept1);
        session.persist(dept2);

//        storing teachers in database
        session.persist(t1);
        session.persist(t2);
        session.persist(t3);
        session.persist(t4);
        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
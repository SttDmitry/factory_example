package com.example.demo.school;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentRepository {

    private Session session;
    private SessionFactory sessionFactory;

    public StudentRepository() {
        try {
            sessionFactory = SingleSessionFactory.getSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Student> getStudentsList () {
        session = sessionFactory.openSession();
        session.beginTransaction();
        List<Student> studentsList = session.createQuery( "from Student" ).list();
        for ( Student student : studentsList ) {
            System.out.println(student);
        }
        session.getTransaction().commit();
        session.close();
        return studentsList;
    }

    public void deleteStudentById(Integer id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.delete(student);
        session.getTransaction().commit();
    }

    public void saveOrUpdateStudent(Student student) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

    public Student findStudentById(Integer id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        return student;
    }
}

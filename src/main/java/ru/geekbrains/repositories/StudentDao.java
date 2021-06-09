package ru.geekbrains.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.models.Student;

import java.util.List;

public class StudentDao {
    private static SessionFactory factory;

    private static void init() {
        factory = new Configuration()
                .configure("configs/student/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public StudentDao() {
        init();
    }

    public void shutdown() {
        factory.close();
    }

    public Student findById(Long id) {
        Student student = null;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            student = session.createQuery(String.format("select p from Student p where id = %d", id), Student.class).getSingleResult();
            session.getTransaction().commit();
        }
        return student;
    }

    public List<Student> findAll() {
        List<Student> studentList = null;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            studentList = session.createQuery("from Student").getResultList();
            session.getTransaction().commit();
        }
        return studentList;
    }

    public void deleteById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
        }
    }

    public Student saveOrUpdate(Student student) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }
        return student;
    }

    public void saveSomeStudents(List<Student> studentList) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            for (Student student : studentList) {
                session.saveOrUpdate(student);
            }
            session.getTransaction().commit();
        }
        ;
    }


}

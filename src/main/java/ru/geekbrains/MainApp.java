package ru.geekbrains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.models.Student;
import ru.geekbrains.repositories.StudentDao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MainApp {
    public static void main(String[] args) {
        prepare();
        StudentDao studentDao = new StudentDao();
        System.out.println("------studentDao.findAll()-----");
        System.out.println(studentDao.findAll());
        System.out.println("----studentDao.findById(2l)----");
        System.out.println(studentDao.findById(2l));
        System.out.println("---studentDao.deleteById(2l)---");
        studentDao.deleteById(2l);
        System.out.println(studentDao.findAll());
        System.out.println("-------studentDao.save--------");
        System.out.println(studentDao.saveOrUpdate(new Student("Student 6", 56)));
        System.out.println("-------studentDao.update-------");
        studentDao.saveOrUpdate(new Student(1l, "Student One", 500));
        System.out.println(studentDao.findAll());
        System.out.println("-------studentDao.add1000students-------");
        add1000students(studentDao);
        for (int i = 100; i < 1001; i += 100) System.out.println(studentDao.findById((long) i));
        studentDao.shutdown();
    }

    private static void prepare() {
        SessionFactory factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            String sql = Files.lines(Paths.get("student.sql")).collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }

    }

    private static void add1000students(StudentDao studentDao) {
        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i < 1001; i++) studentList.add(new Student("Student " + i, i));
        studentDao.saveSomeStudents(studentList);
    }
}

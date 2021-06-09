package ru.geekbrains.models;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private int mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Student() {
    }

    public Student(Long id, String name, int mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return String.format("Student [id = %d, name = %s, mark = %d]", id, name, mark);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (mark != student.mark) return false;
        if (!id.equals(student.id)) return false;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + mark;
        return result;
    }
}





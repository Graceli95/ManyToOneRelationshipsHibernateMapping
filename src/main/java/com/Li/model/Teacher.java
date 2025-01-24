package com.Li.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table
public class Teacher implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;
    private int salary;
    private String teacherName;

//    @ManyToOne  the annotation tells Hibernate how to map it to the database.By default, Hibernate generates the name of the foreign key column based on the name of the relationship mapping attribute
//    and the name of the primary key attribute. In this example, Hibernate would use a column named department_did to store the foreign key to the Teacher entity.
//    If you want to use a different column name, you need to define the foreign key column name with a @JoinColumn annotation.
    @ManyToOne
//    @JoinColumn(name="fk_dep")
    private Department department;

    public Teacher() {}
//    public Teacher(int teacherId, String salary, String teacherName) {
//        super();
//        this.teacherId = teacherId;
//        this.salary = salary;
//        this.teacherName = teacherName;
//    }

    public Teacher(int salary, String teacherName, Department department) {
        this.salary = salary;
        this.teacherName = teacherName;
        this.department = department;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}

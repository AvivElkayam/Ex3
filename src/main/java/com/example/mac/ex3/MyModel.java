package com.example.mac.ex3;

import java.util.ArrayList;

/**
 * Created by mac on 4/16/15.
 */
public class MyModel {
    private static MyModel ourInstance = new MyModel();
     public ModelInterface model;
    public int a;
    public static MyModel getInstance() {
        return ourInstance;
    }

    private MyModel() {
        this.model = new ArrayModel();
    }
    public interface ModelInterface
    {
        public void addStudent(Student student);
        public ArrayList<Student> getStudents();
        public void editStudent(int i,Student s);
        public void deleteStudent(int i);
    }


    public void addStudent(Student student)
    {
        model.addStudent(student);

    }

    public ArrayList<Student> getStudents()
    {
        return model.getStudents();
    }
}

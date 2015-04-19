package com.example.mac.ex3;

import java.util.ArrayList;

/**
 * Created by mac on 4/16/15.
 */
public class ArrayModel implements MyModel.ModelInterface {
    private ArrayList<Student> studentsArray = new ArrayList<Student>();
    @Override
    public void addStudent(Student student) {
        studentsArray.add(student);
    }

    @Override
    public ArrayList<Student> getStudents() {
        return studentsArray;
    }

    @Override
    public void editStudent(int i, Student s) {
        studentsArray.set(i,s);
    }

    @Override
    public void deleteStudent(int i) {
        studentsArray.remove(i);
    }
}

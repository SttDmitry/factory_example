package com.example.demo.school;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student s1 = new Student("Alex", 3.5);
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.saveOrUpdateStudent(s1);

        students.addAll(studentRepository.getStudentsList());
        System.out.println(students);
        studentRepository.deleteStudentById(1);
        System.out.println(studentRepository.getStudentsList());
    }
}

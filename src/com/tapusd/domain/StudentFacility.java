package com.tapusd.domain;

import java.util.List;
import java.util.Optional;

public class StudentFacility {

    private final StudentRepository studentRepository;

    public StudentFacility() {
        this.studentRepository = StudentRepository.getInstance();
    }

    public void save(Student student) {
        try {
            studentRepository.saveNewStudent(student);
        } catch (IllegalArgumentException exception) {
            System.out.println("Unable to save Student! Exception Occurred: " + exception.getMessage());
        }
    }

    public void delete(Long studentId) {
        if (studentRepository.deleteStudent(studentId)) {
            System.out.println("Student With Id {" + studentId + "} Deleted!");
        } else {
            System.out.println("No student Found with Id: " + studentId);
        }
    }

    public void getAll() {
        List<Student> all = studentRepository.getAll();
        System.out.println("All Students");
        all.forEach(System.out::println);
    }

    public void findById(Long studentId) {
        singleStudentPrinter(studentRepository.findById(studentId));
    }

    public void findByAge(Integer age) {
        singleStudentPrinter(studentRepository.findByAge(age));
    }

    public void getAllStudentAgeGreaterThanEqual(Integer age) {
        List<Student> students = studentRepository.getAllStudentAgeGreaterThanEqual(age);
        System.out.println("Students Age Greater Than Equal To: " + age);
        students.forEach(System.out::println);
    }


    public void getAllStudentAgeLessThanEqual(Integer age) {
        System.out.println("Students Age Less than Equal To: " + age);
        List<Student> students = studentRepository.getAllStudentAgeLessThanEqual(age);
        students.forEach(System.out::println);
    }

    private void singleStudentPrinter(Optional<Student> studentOp) {
        if (studentOp.isPresent()) {
            System.out.println("!Student Found!");
            System.out.println(studentOp.get());
        } else {
            System.out.println("Student Not Found!");
        }
    }

}

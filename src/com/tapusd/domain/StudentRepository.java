package com.tapusd.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentRepository {

    private static StudentRepository studentRepository;
    private Long nextId = 0L;
    private final List<Student> students;

    private StudentRepository() {
        this.students = new ArrayList<>();
    }

    protected static StudentRepository getInstance() {
        if (Objects.isNull(studentRepository)) {
            studentRepository = new StudentRepository();
        }
        return studentRepository;
    }

    protected void saveNewStudent(Student student) {
       student.setId(nextId + 1);
       validateStudentsBeforeSave(student);
       this.students.add(student);
       nextId+=1;
    }

    protected boolean deleteStudent(Long studentId) {
        if (Objects.nonNull(studentId) && studentId > 0) {
            return this.students.removeIf(student -> student.getId().equals(studentId));
        }
        return false;
    }

    private void validateStudentsBeforeSave(Student student) {
        if (Objects.isNull(student) ||
                Objects.isNull(student.getName()) ||
                        Objects.isNull(student.getAge()) ||
                                Objects.isNull(student.getDepartment())) {
           throw new IllegalArgumentException("Invalid student information provided!");
        }
    }

    protected List<Student> getAll() {
        return this.students;
    }

    protected Optional<Student> findById(Long studentId) {
        return this.students.stream().filter(student -> student.getId().equals(studentId)).findFirst();
    }

    protected Optional<Student> findByAge(Integer age) {
        return this.students.stream().filter(student -> student.getAge().equals(age)).findFirst();
    }

    protected List<Student> getAllStudentAgeGreaterThanEqual(Integer age) {
        return this.students.stream().filter(student -> student.getAge() >= age).collect(Collectors.toList());
    }


    protected List<Student> getAllStudentAgeLessThanEqual(Integer age) {
        return this.students.stream().filter(student -> student.getAge() <= age).collect(Collectors.toList());
    }

    public Optional<Student> findByName(String nameQuery) {
        return students.stream().filter(student -> nameQuery.equalsIgnoreCase(student.getName())).findFirst();
    }

    public List<Student> findAllByDepartment(String departmentQuery) {
        return students.stream().filter(student -> departmentQuery.equalsIgnoreCase(student.getDepartment())).collect(Collectors.toList());
    }
}

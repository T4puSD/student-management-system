package com.tapusd.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class StudentRepositoryTest {

    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = StudentRepository.getInstance();
        studentRepository.saveNewStudent(new Student("John", 24,"BBA"));
        studentRepository.saveNewStudent(new Student("Bella", 25,"CSE"));
        studentRepository.saveNewStudent(new Student("Miller", 22,"CSE"));
    }

    @AfterEach
    void tearDown() {
        studentRepository.deleteAll();
    }


    @Test
    void whenGetInstanceItShouldReturnRepositoryObject() {
        //when
        StudentRepository studentRepositoryTest = StudentRepository.getInstance();

        //then
        assertThat(studentRepositoryTest).isNotNull();
    }

    @Test
    void givenValidStudentWhenSaveNewStudentItShouldAssignNewId() {
        //given
        Student student = new Student("Sam", 25, "CSE");

        //when
        studentRepository.saveNewStudent(student);

        //then
        assertThat(student)
                .isNotNull()
                .extracting("id")
                .isEqualTo(4L);
    }

    @Test
    void givenValidStudentWhenSaveNewStudentItShouldSaveNewStudent() {
        //given
        Student student = new Student("Sam", 25, "BBA");

        //when
        studentRepository.saveNewStudent(student);

        //then
        assertThat(studentRepository.getAll())
                .size()
                .isEqualTo(4);
    }

    @Test
    void givenInvalidStudentNameWhenSaveNewStudentItShouldThrowException() {
        //given
        Student student = new Student("", 25, "BBA");

        //when - then
        assertThatThrownBy(() -> studentRepository.saveNewStudent(student))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenInvalidStudentDepartmentWhenSaveNewStudentItShouldThrowException() {
        //given
        Student student = new Student("Gorge", 25, "");

        //when - then
        assertThatThrownBy(() -> studentRepository.saveNewStudent(student))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenExistingStudentIdWhenDeleteStudentItShouldDeleteAStudent() {
        //given
        long studentId = 1;
        //when
        studentRepository.deleteStudent(studentId);
        //then
        assertThat(studentRepository.getAll())
                .size()
                .isEqualTo(2);
    }

    @Test
    void givenNonExistingStudentIdWhenDeleteStudentItShouldNotDeleteAStudent() {
        //given
        long studentId = 80;
        //when
        studentRepository.deleteStudent(studentId);
        //then
        assertThat(studentRepository.getAll())
                .size()
                .isEqualTo(3);
    }
    @Test
    void whenGetAllItShouldReturnAllStudent() {
        //when
        List<Student> all = studentRepository.getAll();
        //then
        assertThat(all)
                .size()
                .isEqualTo(3);
    }

    @Test
    void givenExistingStudentIdWhenFindByExistingIdItShouldReturnStudent() {
        //given
        long studentId = 2;
        //when
        Optional<Student> byId = studentRepository.findById(studentId);
        //then
        assertThat(byId)
                .isPresent()
                .get()
                .extracting("id")
                .isEqualTo(studentId);
    }

    @Test
    void givenNonExistingStudentIdWhenFindByNonExistingIdItShouldNotReturnStudent() {
        //given
        long studentId = 5;
        //when
        Optional<Student> byId = studentRepository.findById(studentId);
        //then
        assertThat(byId)
                .isEmpty();
    }

    @Test
    void givenExistingAgeWhenFindByAgeItShouldReturnStudentMatchingAge() {
        //given
        int age = 22;
        //when
        Optional<Student> byAge = studentRepository.findByAge(age);
        //then
        assertThat(byAge)
                .isPresent()
                .get()
                .extracting("age")
                .isEqualTo(age);
    }

    @Test
    void givenNonExistingAgeWhenFindByAgeItShouldNotReturnStudentMatchingAge() {
        //given
        int age = 58;
        //when
        Optional<Student> byAge = studentRepository.findByAge(age);
        //then
        assertThat(byAge)
                .isEmpty();
    }

    @Test
    void givenAgeWhenGetAllStudentAgeGreaterThanEqualItShouldReturnListOfStudentsEqualOrGreaterThanTheProvidedAge() {
        //given
        int searchAge = 24;
        //when
        List<Student> allStudentAgeLessThanEqual = studentRepository.getAllStudentAgeLessThanEqual(searchAge);
        //then
        assertThat(allStudentAgeLessThanEqual)
                .size()
                .isEqualTo(2);
    }

    @Test
    void givenAgeWhenGetAllStudentAgeLessThanEqualItShouldReturnListOfStudentsEqualOrLessThanTheProvidedAge () {
        //given
        int searchAge = 24;
        //when
        List<Student> allStudentAgeLessThanEqual = studentRepository.getAllStudentAgeLessThanEqual(searchAge);
        //then
        assertThat(allStudentAgeLessThanEqual)
                .size()
                .isEqualTo(2);
    }

    @Test
    void givenExistingNameWhenFindByNameItShouldReturnStudent() {
        //given
        String name = "Bella";
        //when
        Optional<Student> byName = studentRepository.findByName(name);
        //then
        assertThat(byName)
                .isPresent()
                .get()
                .extracting("name")
                .isEqualTo(name);
    }

    @Test
    void givenNonExistingNameWhenFindByNameItShouldNotReturnStudent() {
        //given
        String name = "Nitesh";
        //when
        Optional<Student> byName = studentRepository.findByName(name);
        //then
        assertThat(byName)
                .isEmpty();
    }

    @Test
    void givenExistingDepartmentWhenFindAllByDepartmentItShouldReturnListOfMatchingStudents() {
        //given
        String department = "CSE";
        //when
        List<Student> allByDepartment = studentRepository.findAllByDepartment(department);
        //then
        assertThat(allByDepartment)
                .filteredOn("department", department)
                .hasSize(2);
    }

    @Test
    void whenDeleteAllItShouldDeleteEveryRecord() {
        //when
        studentRepository.deleteAll();
        //then
        assertThat(studentRepository.getAll())
                .size()
                .isEqualTo(0);
    }
}
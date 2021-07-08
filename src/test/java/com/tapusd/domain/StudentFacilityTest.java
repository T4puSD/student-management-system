package com.tapusd.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentFacilityTest {

    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentFacility studentFacility;

    @Test
    void givenValidStudentCanSave() {
        //given
        Student student = new Student("Jack", 24, "CSE");
        //when
        studentFacility.save(student);
        //then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).saveNewStudent(studentArgumentCaptor.capture());

        assertThat(studentArgumentCaptor.getValue())
                .isEqualTo(student);
    }

    @Test
    void givenStudentIdCanDeleteStudent() {
        //gievn
        long studentId = 2;
        //when
        studentFacility.delete(studentId);
        //then
        ArgumentCaptor<Long> deleteStudentIdArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(studentRepository).deleteStudent(deleteStudentIdArgumentCaptor.capture());

        assertThat(deleteStudentIdArgumentCaptor.getValue())
                .isEqualTo(studentId);
    }

    @Test
    void canGetAllStudent() {
        //when
        studentFacility.getAll();
        //then
        verify(studentRepository).getAll();
    }

    @Test
    void givenStudentIdCanFindStudent() {
        //given
        long findByStudentId = 5;
        //when
        studentFacility.findById(findByStudentId);
        //then
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(studentRepository).findById(argumentCaptor.capture());

        assertThat(argumentCaptor.getValue())
                .isEqualTo(findByStudentId);
    }

    @Test
    void givenAgeCanFindByAge() {
        //given
        int findByAge = 24;
        //when
        studentFacility.findByAge(findByAge);
        //then
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(studentRepository).findByAge(argumentCaptor.capture());

        assertThat(argumentCaptor.getValue())
                .isEqualTo(findByAge);
    }

    @Test
    void givenAgeCanGetAllStudentAgeGreaterThanEqualToAge() {
        //given
        int findByAge = 24;
        //when
        studentFacility.getAllStudentAgeGreaterThanEqual(findByAge);
        //then
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(studentRepository).getAllStudentAgeGreaterThanEqual(argumentCaptor.capture());

        assertThat(argumentCaptor.getValue())
                .isEqualTo(findByAge);
    }

    @Test
    void givenAgeCanGetAllStudentAgeLessThanEqual() {
        //given
        int findByAge = 24;
        //when
        studentFacility.getAllStudentAgeLessThanEqual(findByAge);
        //then
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(studentRepository).getAllStudentAgeLessThanEqual(argumentCaptor.capture());

        assertThat(argumentCaptor.getValue())
                .isEqualTo(findByAge);
    }

    @Test
    void givenNameCanFindByName() {
        //given
        String name = "Miller";
        //when
        studentFacility.findByName(name);
        //then
        verify(studentRepository).findByName(anyString());
    }

    @Test
    void givenDepartmentNameCanFindAllByDepartment() {
        //given
        String department = "CSE";
        //when
        studentFacility.findAllByDepartment(department);
        //then
        verify(studentRepository).findAllByDepartment(anyString());
    }
}
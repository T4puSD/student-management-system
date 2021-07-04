package com.tapusd.handlers;

import com.tapusd.domain.Student;

import java.util.Objects;
import java.util.Scanner;

public class UserInputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public Student inputStudent() {
        Student student = new Student();
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        while (name.isBlank()) {
            System.out.println("Name can not be blank! Try Again(Input 0 to go back to Main Menu)");
            name = scanner.nextLine();
            if ("0".equals(name)) {
                return null;
            }
        }
        student.setName(name);

        System.out.println("Enter age: ");
        Integer age = inputAge();
        while (Objects.isNull(age)) {
            age = inputAge();
        }
        if (Integer.valueOf(-1).equals(age)) {
            return null;
        }
        student.setAge(age);

        System.out.println("Enter student department: ");
        String department = scanner.nextLine();
        while (department.isBlank()) {
            System.out.println("Department can not be blank! Try Again(Input 0 to go back to Main Menu)");
            department = scanner.nextLine();
            if ("0".equals(department)) {
                return null;
            }
        }
        student.setDepartment(department.toUpperCase());

        return student;
    }

    private static Integer inputAge() {
        String age = scanner.nextLine();
        while (age.isBlank()) {
            System.out.println("Age can not be blank! Try Again(Input 0 to go back to Main Menu)");
            age = scanner.nextLine();
            if ("0".equals(age)) {
                return -1;
            }
        }
        if ("0".equals(age)) {
            return -1;
        }

        try {
            int i = Integer.parseInt(age);
            if (i < 0 || i > 120) {
                System.out.println("Invalid Age! Try Again(Input 0 to go back to Main Menu)");
                return null;
            }
            return i;
        } catch (NumberFormatException exception) {
            System.out.println("Invalid Age Input Format! Try Again(Input 0 to go back to Main Menu)");
            return null;
        }
    }
}

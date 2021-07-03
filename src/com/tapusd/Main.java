package com.tapusd;

import com.tapusd.domain.Student;
import com.tapusd.domain.StudentFacility;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final StudentFacility studentFacility = new StudentFacility();
    private static final Scanner scanner = new Scanner(System.in);

    private static String stringGenerator(char symbol, int length) {
        char[] arr = new char[length];
        Arrays.fill(arr, symbol);
        return new String(arr);
    }

    private static void printMainMenu() {
        System.out.println(stringGenerator('=', 30));
        System.out.println(stringGenerator('=', 30));
        System.out.println("1. Add new Student");
        System.out.println("2. Show All");
        System.out.println("3. Search Students");
        System.out.println("4. Delete a student");
        System.out.println("5. Exit");
        System.out.println(stringGenerator('=', 30));
        System.out.println(stringGenerator('=', 30));
        System.out.println("Choose A Option: ");
    }

    private static Student inputStudent() {
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

    public static void main(String[] args) {
        boolean isActive = true;
        while (isActive) {
            printMainMenu();
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("Add New Student");
                    Student student = inputStudent();
                    if (Objects.nonNull(student)) {
                        studentFacility.save(student);
                    }
                    break;
                case "2":
                    System.out.println("Show All");
                    studentFacility.getAll();
                    break;
                case "3":
                    System.out.println("Search Students");
                    break;
                case "4":
                    System.out.println("Delete Student");
                    break;
                case "5":
                    System.out.println("Bye");
                    isActive = false;
                    break;
                default:
                    System.out.println("Please Choose a correct Option!");
            }
        }
    }
}

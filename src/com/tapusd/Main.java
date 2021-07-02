package com.tapusd;

import com.tapusd.domain.Student;
import com.tapusd.domain.StudentFacility;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final StudentFacility studentFacility = new StudentFacility();

    private static String stringGenerator(char symbol, int length) {
        char [] arr = new char [length];
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
        System.out.println(stringGenerator('=', 30));
        System.out.println(stringGenerator('=', 30));
        System.out.println("Choose A Option: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Student student = new Student("tapu", 23, "CSE");
//        studentFacility.save(student);
//        Student student1 = new Student("Jack", 53, "CSE");
//        studentFacility.save(student1);
//        Student student2 = new Student("Miller", 33, "CSE");
//        studentFacility.save(student2);
//        Student student3 = new Student("Jonnathon", 43, "CSE");
//        studentFacility.save(student3);
//        Student student4 = new Student("Jack The Ripper", 18, "CSE");
//        studentFacility.save(student4);
//
//        studentFacility.getAll();
//        studentFacility.delete(2L);
//        studentFacility.getAll();
//        Student student5 = new Student("WingMan", 23, "CSE");
//        studentFacility.save(student5);
//        studentFacility.getAll();
//
//        studentFacility.getAllStudentAgeGreaterThanEqual(30);
//        studentFacility.getAllStudentAgeLessThanEqual(25);
//        studentFacility.findByAge(18);
//
//        studentFacility.save(new Student(null, null,null));

        while (true) {
            printMainMenu();
            Integer choose = Integer.valueOf(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Add New Student");
                    break;
                case 2:
                    System.out.println("Show All");
                    break;
                case 3:
                    System.out.println("Search Students");
                    break;
                case 4:
                    System.out.println("Delete Student");
                    break;
                default:
                    System.out.println("Please Choose a correct Option!");
            }

            break;
        }
    }
}

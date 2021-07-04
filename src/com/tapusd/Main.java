package com.tapusd;

import com.tapusd.domain.Student;
import com.tapusd.domain.StudentFacility;
import com.tapusd.handlers.UserInputHandler;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final StudentFacility studentFacility = new StudentFacility();
    private static final UserInputHandler userInputHandler = new UserInputHandler();
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


    public static void main(String[] args) {
        boolean isActive = true;
        while (isActive) {
            printMainMenu();
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("Add New Student");
                    Student student = userInputHandler.inputStudent();
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

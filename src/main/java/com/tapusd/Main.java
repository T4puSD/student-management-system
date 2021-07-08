package com.tapusd;

import com.tapusd.domain.Student;
import com.tapusd.domain.StudentFacility;
import com.tapusd.domain.StudentRepository;
import com.tapusd.handlers.UserInputHandler;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final StudentFacility studentFacility = new StudentFacility(new StudentRepository());
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
                    System.out.println(stringGenerator('=', 30));
                    System.out.println(stringGenerator('=', 30));
                    System.out.println("1. Search By Name");
                    System.out.println("2. Search By Age");
                    System.out.println("3. Search By Department");
                    System.out.println(stringGenerator('=', 30));
                    System.out.println(stringGenerator('=', 30));
                    System.out.println(stringGenerator('#', 10) + "Choose: ");
                    String chooseSearchOption = scanner.nextLine();
                    switch (chooseSearchOption) {
                        case "1":
                            System.out.println("Enter the name to Search: ");
                            String nameQuery = scanner.nextLine();
                            studentFacility.findByName(nameQuery);
                            break;
                        case "2":
                            break;
                        case "3":
                            System.out.println("Enter the department name: ");
                            String departmentQuery = scanner.nextLine();
                            studentFacility.findAllByDepartment(departmentQuery);
                            break;
                    }
                    break;
                case "4":
                    System.out.println("Delete Student");
                    System.out.println("Enter student id to delete: ");
                    String deleteStudentId = scanner.nextLine();
                    if (Objects.nonNull(deleteStudentId) && !deleteStudentId.isBlank()) {
                        studentFacility.delete(Long.parseLong(deleteStudentId));
                    }
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

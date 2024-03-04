package com.example.task2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Task2Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Task2Application.class, args);
        //postman
        GenderIdenteficatorService service = context.getBean(GenderIdenteficatorService.class);




//        boolean continueProgram = true;
//        while (continueProgram) {
//            System.out.print("Write name to add: ");
//            String nameToAdd = scanner.nextLine();
//            service.addNameToFile(nameToAdd);
//
//            System.out.print("Do you want delete name? (Yes/No): ");
//            String choiceRemovedName = scanner.nextLine();
//            if(choiceRemovedName.equalsIgnoreCase("yes")) {
//                System.out.print("Write name to remove: ");
//                String nameToRemoved = scanner.nextLine();
//                removeName(service, nameToRemoved);
//                System.out.println("Name: " + nameToRemoved + " removed from file. Program is Finished!");
//                break;
//            } else {
//                System.out.print("Do you want continue? (Yes/No:) ");
//                String choiceContinue = scanner.nextLine();
//                continueProgram = choiceContinue.equalsIgnoreCase("yes");
//                if(continueProgram == false) {
//                    System.out.println("Program is Finished!");
//                }
//            }
//        }
    }

    public static void removeName(GenderIdenteficatorService service, String nameToRemove) {
        boolean removedName = service.removeNameFromFile(nameToRemove);
        if(removedName) {
            System.out.println("Name: " + nameToRemove + " removed from file");
        }
        else {
            System.out.println("Name: " + nameToRemove + " not removed from file");
        }
    }
}

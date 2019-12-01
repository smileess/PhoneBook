package it.studies;

import java.util.Scanner;

public class HelperMethods {

    public void printMenu () {
        System.out.println("--Address Book Application--");
        System.out.println("Enter the command respective for the desired action");
        System.out.println("command | action");
        System.out.println("-----------------");
        System.out.println("add | creates a new contact");
        System.out.println("find | finds a contact");
        System.out.println("edit | edit a contact");
        System.out.println("delete | choose a contact to delete");
        System.out.println("exit | exit the program and save the data to the file");
        System.out.println("-----------------");
        System.out.println();
    }

    public void printFindContactMenu() {
        System.out.println("--Find contact by:");
        System.out.println(" 1 | by number");
        System.out.println(" 2 | by name");
        System.out.println(" 3 | by surname");
        System.out.println(" 4 | by city");
    }



}

package it.studies;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Book {

    HelperMethods helperMethods = new HelperMethods();
    List<Contact> myArray = new ArrayList<Contact>();

    String temp = "";
    File file = new File("contacts.txt");



    public void displayMenu() {
        myArray = readFromFile();
        Scanner scanner = new Scanner(System.in);
        helperMethods.printMenu();
        String choice = scanner.nextLine();


        switch (choice) {
            case "add":
                //add method? implement
                System.out.println("provide phone number, name and surname, confirm each by pressing enter:");
                addContact(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
                System.out.println(Arrays.toString(myArray.toArray()));

                displayMenu();
                break;
            case "find":
                //to implement findContact
                helperMethods.printFindContactMenu();
                break;
            case "edit":
                // implement edit contact
                break;
            case "delete":
                // implement delete a record
                break;
            case "exit":
                saveToFile();
                break;
                // zapisz listę do pliku i zakończ program

            default:
                System.out.println("Please type one of the available options from the menu");
                displayMenu();
        }

    }



public void addContact(String phoneNumber, String name, String surname) {
    Contact contact = new Contact();
    contact.phoneNumber = phoneNumber;
    contact.name = name;
    contact.surname = surname;
    myArray.add(contact);


}

public void saveToFile() {
        parseListToString();
    try{

        // creates the file
        file.createNewFile();

        // creates a FileWriter Object
        FileWriter writer = new FileWriter(file);

        // Writes the content to the file
        writer.write(temp);
        writer.flush();
        writer.close();


    }
    catch(IOException e)
    {
        System.out.println("Error with saving file " + e);
    }
}

    public void parseListToString() {

        for (Contact contact : myArray) {
            temp += contact.name +","+ contact.surname + "," + contact.phoneNumber + ";";
        }
    }

public List<Contact> readFromFile(){
//    // Creates a FileReader Object
//    try {
//        FileReader fr = new FileReader(file);
//        char[] a = new char[50];
//        fr.read(a);   // reads the content to the array
//
//        for (char c : a)
//            System.out.print(c);   // prints the characters one by one
//        fr.close();
//    }catch(Exception e) {
//        System.out.println("Exception in read from file" + e);
//    }
    List<String> linesFromFile = readLines();
    List<Contact> parsed = new ArrayList<Contact>();

    for (String line : linesFromFile) {
        try {
            String[] split = line.split(",");

            String phoneNumber = String.valueOf(split[0]);
            String name = String.valueOf(split[1]);
            String surname = String.valueOf(split[2]);
            Contact contact = new Contact(phoneNumber, name, surname);
            parsed.add(contact);
        } catch (Exception e) {
            System.out.println("Could not read data from file: " + e);
        }
    }

    return parsed;
}

public List<String> readLines() {
    try (Stream<String> lines = Files.lines(file.toPath())) {
        return lines.collect(Collectors.toList());
    } catch (IOException e) {
        System.out.println("Could not read from file: " + e);
    }
    return null;

}




}

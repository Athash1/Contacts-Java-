package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static contacts.Phonebook.*;

public class PhoneBookApp {
    public static void main(String[] args) {
        String filePath = ".\\Contacts (Java)\\task\\src\\contacts\\phonebook.txt";
        Phonebook phonebook;
            try {
                phonebook = (Phonebook) Serialization.deserializeObject(filePath);
            } catch (Exception e) {
                System.out.println("Error: Can't load Phone book from file. New Phone book created.\n");
                phonebook = new Phonebook();
            }
        if (phonebook == null) {
            System.out.println("Error: Can't load Phone book from file. New Phone book created.\n");
            phonebook = new Phonebook();
        }
        Serialization.serializeObject(phonebook, filePath);
        menu(phonebook, filePath);
    }
    public static void menu(Phonebook phonebook, String filePath) {
        Scanner input = new Scanner(System.in);
        System.out.println("[menu] Enter action (add, list, search, count, exit): > ");
        String action = input.nextLine();
        switch (action) {
            case "add" -> phonebook.add(phonebook, filePath);
            case "list" -> list(phonebook, filePath);
            case "search" -> search(phonebook, filePath);
            case "count" -> phonebook.count(phonebook, filePath);
            case "exit" -> phonebook.exit(phonebook, filePath);
            default -> System.out.println("[menu] Enter action (add, list, search, count, exit): > ");

        }


        System.out.println();
        menu(phonebook, filePath);
    }
}

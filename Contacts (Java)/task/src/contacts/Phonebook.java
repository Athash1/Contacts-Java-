package contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Phonebook implements Serializable {
    protected int size = 0;
    protected List<Contact> contactList = new ArrayList<>();

    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    public void add(Phonebook phonebook, String filePath) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the type (person, organization): > ");
        String type = input.nextLine();
        switch (type) {
            case "person" -> {
                Person person = new Person();
                System.out.println("Enter the name: >");
                person.setName(input.nextLine());
                System.out.println("Enter the surname: >");
                person.setSurname(input.nextLine());
                System.out.println("Enter the birth date: >");
                person.setBirthday(input.nextLine());
                System.out.println("Enter the gender (M, F): >");
                person.setGender(input.nextLine());
                System.out.println("Enter the number: >");
                String s = input.nextLine();
                if (!person.isValidNumber(s)) {
                    System.out.println("Wrong number format!");
                }
                person.setNumber(s);
                person.hasNumber(person.getNumber());
                person.setCreatedTime();
                System.out.println("The record added.\n");
                phonebook.addContact(person);
                phonebook.size += 1;
            }
            case "organization" -> {
                Organization organization = new Organization();

                System.out.println("Enter the organization name: > ");
                organization.setName(input.nextLine());
                System.out.println("Enter the address: > ");
                organization.setAddress(input.nextLine());
                System.out.println("Enter the number: > ");
                String s = input.nextLine();
                if (!organization.isValidNumber(s)) {
                    System.out.println("Wrong number format!");
                }
                organization.setNumber(s);
                organization.hasNumber(organization.getNumber());
                organization.setCreatedTime();
                System.out.println("The record added.\n");
                phonebook.addContact(organization);
                phonebook.size += 1;
            }
        }
    }

//    public void remove(Phonebook phonebook) {
//        Scanner input = new Scanner(System.in);
//        if (phonebook.size == 0) {
//            System.out.println("No records to remove!");
//        } else {
//            for (int i = 0; i < phonebook.contactList.size(); i++) {
//                Contact s = phonebook.contactList.get(i);
//                System.out.println(i+1 + ". " + s);
//            }
//
//            System.out.println("Select a record: > ");
//            if (input.hasNext()) {
//                String s = input.next();
//                if (isNumeric(s)) {
//                    int number = Integer.parseInt(s) - 1;
//                    if (number < phonebook.size && number > -1) {
//                        phonebook.contactList.remove(number);
//                        phonebook.size -= 1;
//                        System.out.println("The record removed!");
//                    }
//                }
//            }
//        }
//
//    }

    public void count(Phonebook phonebook,String filePath) {
        System.out.println("The Phone Book has " + phonebook.size + " records");
    }

    public static void list(Phonebook phonebook, String filePath) {
        Scanner input = new Scanner(System.in);
        if (phonebook.size == 0) {
            System.out.println("No records!");
        } else {
            for (int i = 0; i < phonebook.contactList.size(); i++) {
                if (phonebook.contactList.get(i) instanceof Person s) {
                    System.out.println(i+1 + ". " + s.getName());
                }

                if (phonebook.contactList.get(i) instanceof Organization s) {
                    System.out.println(i+1 + ". " + s.getName());
                }
            }
//            System.out.println("[list] Enter action ([number], back): > ");
//            Scanner input = new Scanner(System.in);
//            String s = input.next();
//            while (!isNumeric(s)) {
//                System.out.println("[list] Enter action ([number], back): > ");
//                s = input.next();
//            }
//            if (isNumeric(s))  {
//                int number = Integer.parseInt(s) - 1;
//                if (number < phonebook.size && number > -1) {
//
//                    if (phonebook.contactList.get(number) instanceof Person person) {
//                            System.out.println(person);
//                        }
//
//                    if (phonebook.contactList.get(number) instanceof Organization organization) {
//                            System.out.println(organization);
//                        }
//                }
//
//            }

            boolean doAgain = true;
            while (doAgain) {
                System.out.println("[list] Enter action ([number], back): > ");
                String action = input.nextLine();
                try {
                    int number = Integer.parseInt(action);
                    if (number >= 1) {
                        Contact target = phonebook.contactList.get(number - 1);
                        System.out.println(target);
                        doAgain = false;
                        boolean doAgain2 = true;
                        while (doAgain2) {
                            System.out.println("[record] Enter action (edit, delete, menu): > ");
                            String action2 = input.nextLine();
                            switch (action2) {
                                case "edit" -> edit(target, filePath);
                                case "delete" -> {
                                    phonebook.contactList.remove(number - 1);
                                    doAgain2 = false;
                                }
                                case "menu" -> {
                                    PhoneBookApp.menu(phonebook, filePath);
                                    doAgain2 = false;
                                }
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    if (action.equals("back")) {
                        doAgain = false;
                        PhoneBookApp.menu(phonebook, filePath);
                    }
//                    if (action.equals("again")) {
//                        doAgain = false;
//                        search(phonebook);
//                    }
                }
            }
        }
    }

    public static void edit(Contact contact, String filePath) {
        Scanner input = new Scanner(System.in);
//        if (phonebook.size == 0) {
//            System.out.println("No records to edit!");
//        } else {
//            for (int i = 0; i < phonebook.contactList.size(); i++) {
//                if (phonebook.contactList.get(i) instanceof Person person) {
//                    System.out.println(i+1 + ". " + person.getName());
//                }
//
//                if (phonebook.contactList.get(i) instanceof Organization organization) {
//                    System.out.println(i+1 + ". " + organization.getName());
//                }
//            }
//
//            System.out.println("Select a record: > ");
//            String s = input.next();
//            while (!isNumeric(s)) {
//                System.out.println("Select a record: > ");
//                s = input.next();
//            }
//            if (isNumeric(s))  {
//                int number = Integer.parseInt(s) - 1;
//                if (number < phonebook.size && number > -1) {
                    if (contact instanceof Person person) {
                        System.out.print(person);
                        System.out.println("Select a field (name, surname, birth, gender, number): > ");
                        String field = input.next().trim();
                        input.nextLine(); // 消耗掉换行符
                            switch (field) {
                                case "name" -> {
                                    System.out.println("Enter name: > ");
                                    String info = input.next();
                                    person.setName(info);
                                    person.setLastModifiedTime();
                                    System.out.println("Saved\n");
                                    System.out.println(person);
                                }
                                case "surname" -> {
                                    System.out.println("Enter surname: > ");
                                    String info = input.next();
                                    person.setSurname(info);
                                    person.setLastModifiedTime();
                                    System.out.println("Saved\n");
                                    System.out.println(person);
                                }
                                case "birth" -> {
                                    System.out.println("Enter birth date: >");
                                    String info = input.nextLine();
                                    person.setBirthday(info);
                                    person.setLastModifiedTime();
                                    System.out.println("Saved\n");
                                    System.out.println(person);
                                }
                                case "gender" -> {
                                    System.out.println("Enter gender: >");
                                    String info = input.next();
                                    person.setGender(info);
                                    person.setLastModifiedTime();
                                    System.out.println("Saved\n");
                                    System.out.println(person);
                                }
                                case "number" -> {
                                    System.out.println("Enter number: > ");
                                    String q = input.nextLine();
                                    if (!person.isValidNumber(q)) {
                                        System.out.println("Wrong number format!");
                                    }
                                    person.setNumber(q);
                                    person.hasNumber(person.getNumber());
                                    person.setLastModifiedTime();
                                    System.out.println("Saved\n");
                                    System.out.println(person);
                                }
                                default -> {
                                }
                            }
                    }

                    if (contact instanceof Organization organization) {
                        System.out.print(organization);
                        System.out.println("Select a field (address, number): > ");
                        String field = input.next().trim();
                        input.nextLine(); // 消耗掉换行符
                            switch (field) {
                                case "address" -> {
                                    System.out.println("Enter address: > ");
                                    String info = input.nextLine();
                                    organization.setAddress(info);
                                    organization.setLastModifiedTime();
                                    System.out.println("Saved\n");
                                    System.out.println(organization);
                                }
                                case "number" -> {
                                    System.out.println("Enter number: > ");
                                    String q = input.nextLine();
                                    if (!organization.isValidNumber(q)) {
                                        System.out.println("Wrong number format!");
                                    }
                                    organization.setNumber(q);
                                    organization.hasNumber(organization.getNumber());
                                    organization.setLastModifiedTime();
                                    System.out.println("Saved\n");
                                    System.out.println(organization);
                                }
                                default -> {
                                }
                            }

                    }
                }
//            }

//        }
//    }

    public static void search(Phonebook phonebook, String filePath) {
        List<Contact> results = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter search query: > ");
        String query = input.nextLine();
        for (Contact entry : phonebook.contactList) {
            if (entry instanceof Person person) {
                if (person.getName().toLowerCase().contains(query.toLowerCase()) ||
                        person.getSurname().toLowerCase().contains(query.toLowerCase()) ||
                        person.getBirthday().toLowerCase().contains(query.toLowerCase()) ||
                        person.getGender().toLowerCase().contains(query.toLowerCase()) ||
                        person.getNumber().toLowerCase().contains(query.toLowerCase())) {
                    results.add(entry);
                }
            }
            if (entry instanceof Organization organization) {
                if (organization.getName().toLowerCase().contains(query.toLowerCase()) ||
                        organization.getAddress().toLowerCase().contains(query.toLowerCase()) ||
                        organization.getNumber().toLowerCase().contains(query.toLowerCase())) {
                    results.add(entry);
                }
            }
        }
        if (results.isEmpty()) {
            System.out.println("Found 0 results:");
        } else {
            System.out.printf("Found %d results:\n", results.size());
            for (int i = 0; i < results.size(); i++) {
                if (results.get(i) instanceof Person person) {
                    System.out.println((i + 1) + ". " + person.getName() + " " + person.getSurname());
                }
                if (results.get(i) instanceof Organization organization) {
                    System.out.println((i + 1) + ". " + organization.getName());
                }
            }
        }
        boolean doAgain = true;
        while (doAgain) {
            System.out.println("[search] Enter action ([number], back, again): > ");
            String action = input.nextLine();
            try {
                int number = Integer.parseInt(action);
                if (number >= 1) {
                    Contact target = results.get(number - 1);
                    System.out.println(target);
                    doAgain = false;
                    boolean doAgain2 = true;
                    while (doAgain2) {
                        System.out.println("[record] Enter action (edit, delete, menu): > ");
                        String action2 = input.nextLine();
                        switch (action2) {
                            case "edit" -> edit(target, filePath);
                            case "delete" -> {
                                phonebook.contactList.remove(number - 1);
                                doAgain2 = false;
                            }
                            case "menu" -> {
                                PhoneBookApp.menu(phonebook, filePath);
                                doAgain2 = false;
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                if (action.equals("back")) {
                    doAgain = false;
                    PhoneBookApp.menu(phonebook, filePath);
                }
                if (action.equals("again")) {
                    doAgain = false;
                    search(phonebook, filePath);
                }
            }
        }

    }

    public void exit(Phonebook phonebook,String filePath) {
        if (phonebook == null) {
            System.exit(0); // 在程序退出前进行序列化和退出
        } else {
            Serialization.serializeObject(phonebook, filePath);
            System.exit(0);
        }
    }

    public static boolean isNumeric(String str) {
        if (str != null && !"".equals(str.trim()))
            return str.matches("^[0-9]+$");
        else
            return false;
    }
}
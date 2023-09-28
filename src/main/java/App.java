import java.util.Scanner;

public class App {
    static boolean active = true;
    Journal journal = new Journal();

    public static void menu() {
        System.out.println("********** Welcome To Journal  *********** ");
        help();
    }

    private static void help() {
        System.out.println(
                """
                        \t Here are some Journal commands:\s
                        help - shows available commands\s
                        add  - adds new record about student
                        show - shows all records
                        exit - to exit this system""");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Journal journal = new Journal();

        menu();
        do {
            System.out.println("\nEnter command");
            //окремі слова сприймає як окремий ввід
            String command = scanner.next();
            switch(command) {
                case "help":
                    System.out.println("help command");
                    help();
                    break;
                case "add":
                    System.out.println("Add new record");
                    System.out.println("Name: ");
                    String name = scanner.next();
                    System.out.println("Surname: ");
                    String surname = scanner.next();
                    System.out.println("Birthday: ");
                    String birthday = scanner.next();
                    System.out.println("Phone Number: ");
                    String phone = scanner.next();
                    System.out.println("Address: ");
                    String address = scanner.next();

                    journal.add(name, surname, birthday, phone, address);
                    break;
                case "show":
                    System.out.println("show command");
                    journal.show();
                    break;
                case "exit":
                    System.out.println("exit command");
                    System.exit(0);

                default:
                    System.out.println("Please enter valid command");
                    break;
            }
        } while (active);
    }
}


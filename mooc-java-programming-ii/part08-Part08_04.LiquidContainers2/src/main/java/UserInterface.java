import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private Container container1;
    private Container container2;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.container1 = new Container();
        this.container2 = new Container();
    }

    public void start() {
        while (true) {
            System.out.println("First: " + container1.contains() + "/100");
            System.out.println("Second: " + container2.contains() + "/100");

            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            String command = parts[0];
            if (command.equals("quit")) {
                break;
            }

            int amount = Integer.valueOf(parts[1]);
            if (amount > 0) {
                if (command.equals("add")) {
                    container1.add(amount);
                } else if (command.equals("move")) {
                    if (amount > container1.contains()) {
                        amount = container1.contains();
                    }

                    container1.remove(amount);
                    container2.add(amount);
                } else if (command.equals("remove")) {
                    container2.remove(amount);
                }
            }
        }
    }
}

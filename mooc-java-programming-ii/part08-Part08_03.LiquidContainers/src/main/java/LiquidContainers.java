import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int first = 0;
        int second = 0;
        while (true) {
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");

            // user input
            String input = scan.nextLine();
            String[] parts = input.split(" ");
            if (parts[0].equals("quit")) {
                break;
            }
            int amount = Integer.valueOf(parts[1]);
            if (amount > 0) {
                // add amount adds the amount of liquid specified by the parameter to the first container. The inserted amount must be specified as an integer. The container can't hold more than a hundred liters and everything added past that will go to waste.

                if (parts[0].equals("add")) {
                    first += amount;
                    if (first >= 100) {
                        first = 100;
                        // amount -= 100;
                    }
                } else if (parts[0].equals("move")) {
                    // move amount moves the amount of liquid specified by the parameter from the first container to the second container. The given amount must be specified as an integer. If the program is requested to move more liquid than than the first container currently holds, move all the remaining liquid. The second container can't hold more than one hundred liters of liquid and everything past that will go to waste.
                    if (amount > first) {
                        amount = first;
                    }
                    second += amount;
                    if (second <= 100) {
                        first -= amount;
                        if (first < 0) {
                            first = 0;
                        }
                    } else {
                        first = 0;
                        second = 100;
                    }
                } else if (parts[0].equals("remove")) {
                    amount = amount > second ? second : amount;

                    second -= amount;
                    if (second < 0) {
                        second = 0;
                    }
                }
            }
        }
    }
}

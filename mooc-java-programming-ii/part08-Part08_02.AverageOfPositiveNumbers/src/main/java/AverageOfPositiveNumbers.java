import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPositiveNubmer = 0;
        int sum = 0;
        while (true) {
            String command = scanner.nextLine();

            if (command.equals("0")) {
                break;
            }

            int num = Integer.valueOf(command);
            if (num > 0) {
                sum += num;
                ++countPositiveNubmer;
            }
        }

        if (countPositiveNubmer == 0) {
            System.out.println("Cannot calculate the average");
        } else {
            System.out.println((1.0 * sum) / countPositiveNubmer);
        }
    }
}

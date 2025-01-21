import java.util.Scanner;

public class Temperatures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] temperatures = new double[5];
        double sum = 0;

        System.out.println("Enter 5 temperatures:");
        for (int i = 0; i < temperatures.length; i++) {
            System.out.print("Temperature " + (i + 1) + ": ");
            temperatures[i] = scanner.nextDouble();
            sum += temperatures[i];
        }
        double average = sum / temperatures.length;
        System.out.println("\nThe average temperature is: " + average);
        System.out.println("\nTemperatures above the average:");
        for (double temp : temperatures) {
            if (temp > average) {
                System.out.println(temp);
            }
        }

        scanner.close();
    }
}
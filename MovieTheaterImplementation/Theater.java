import java.util.Scanner;


public class Theater {
    // A 2D array for the seats: 5 rows, each with 10 seats
    // false = available, true = reserved
    public static boolean[][] seats = new boolean[5][10];

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int choice;
            
            do {
                System.out.println("\nSeat Reservations");
                System.out.println("1. Reserve a seat");
                System.out.println("2. Cancel a reservation");
                System.out.println("3. Show available seats");
                System.out.println("4. Exit");
                System.out.print("Enter your choice (1-4): ");
                choice = sc.nextInt();
                
                switch (choice) {
                    case 1 -> reserveSeat(sc);
                    case 2 -> cancelReservation(sc);
                    case 3 -> displaySeats();
                    case 4 -> System.out.println("Good bye.");
                    default -> System.out.println("Invalid choice. Please use 1-4 as indicated in the menu.");
                }
            } while (choice != 4);
        }
    }
   // The function to reserve a seat firsts asks for the input for the desired seat, then checks if its valid- if so checks the availibility, 
   //if seat is availible the function finishes and reserves that seat via a boolean, if not it suggests the next seat availible in the array.
    private static void reserveSeat(Scanner sc) {
        System.out.print("Select row number (1-5): ");
        int row = sc.nextInt();
        System.out.print("Enter seat number (1-10): ");
        int column = sc.nextInt();
       
        if (!validSeat(row, column)) {
            System.out.println("Invalid Selection. Rows: 1-5, Seats: 1-10.");
            return;
        }
        //Subtracting 1 from the input to align with the 0 based index.
        int rowIndex = row - 1;
        int colIndex = column - 1;

        if (!seats[rowIndex][colIndex]) {
            seats[rowIndex][colIndex] = true;
            System.out.println("Seat reserved successfully.");
        } else {

            System.out.println("That seat is already reserved.");
            int[] suggestion = findNextSeat(rowIndex, colIndex);
            if (suggestion != null) {
                System.out.println("Next available seat is at Row " 
                        + (suggestion[0] + 1) + ", Seat " + (suggestion[1] + 1));
            } else {
                System.out.println("No seats are available after the requested seat.");
            }
        }
    }

    // This function simply checks that a valid reserved seat has been input by the user, then changes it's boolean to false cancelling that reservation.
    private static void cancelReservation(Scanner sc) {
        System.out.print("Select row number (1-5): ");
        int row = sc.nextInt();
        System.out.print("Enter seat number (1-10): ");
        int column = sc.nextInt();

        if (!validSeat(row, column)) {
            System.out.println("Invalid Selection. Rows: 1-5, Seats: 1-10.");
            return;
        }

        int rowIndex = row - 1;
        int colIndex = column - 1;

        if (seats[rowIndex][colIndex]) {
            seats[rowIndex][colIndex] = false;
            System.out.println("Your seat reservation has been canceled.");
        } else {
            System.out.println("That seat is not currently reserved.");
        }
    }

    private static void displaySeats() {
        System.out.println("\nCurrent Seating Chart (X reserved, O availible):");
        for (int i = 0; i < seats.length; i++) {
            System.out.print("Row " + (i + 1) + ": ");
            for (int j = 0; j < seats[i].length; j++) {
                
                if (seats[i][j]) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    private static boolean validSeat(int row, int col) {
        return (row >= 1 && row <= 5 && col >= 1 && col <= 10);
    }

    private static int[] findNextSeat(int row, int col) {
        for (int i = row; i < seats.length; i++) {
            // if we're on the same row as the attempted seat, start from col+1
            int startCol = (i == row) ? col + 1 : 0;
            for (int j = startCol; j < seats[i].length; j++) {
                if (!seats[i][j]) {  // if this seat is available
                    return new int[]{ i, j };
                }
            }
        }
        return null; 
    }
}

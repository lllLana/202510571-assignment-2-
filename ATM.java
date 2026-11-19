import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int pin = 1234;
        int attempts = 0;
        int enteredPin;
        double balance = 0;
        int choice;
        double amount;
        String[] transactions = new String[100];
        int count = 0;

        while (attempts < 3) {
            System.out.print("Enter PIN: ");
            enteredPin = input.nextInt();

            if (enteredPin == pin) {
                break;
            } else {
                attempts++;
            }
        }

        if (attempts < 3) {
            while (true) {
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. View Transactions");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = input.nextInt();

                if (choice == 1) {
                    System.out.println("Balance: " + balance);
                } 
                else if (choice == 2) {
                    System.out.print("Enter amount: ");
                    amount = input.nextDouble();
                    balance = balance + amount;
                    transactions[count] = "Deposit: " + amount;
                    count++;
                } 
                else if (choice == 3) {
                    System.out.print("Enter amount: ");
                    amount = input.nextDouble();

                    if (amount <= balance) {
                        balance = balance - amount;
                        transactions[count] = "Withdrawal: " + amount;
                        count++;
                    } else {
                        System.out.println("Insufficient balance");
                    }
                } 
                else if (choice == 4) {
                    for (int i = 0; i < count; i++) {
                        System.out.println(transactions[i]);
                    }
                } 
                else if (choice == 5) {
                    break;
                }
            }
        } else {
            System.out.println("Maximum attempts reached");
        }

        input.close();
    }
}
``

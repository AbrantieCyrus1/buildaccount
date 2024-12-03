import java.util.Scanner;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private String email;
    private String phoneNumber;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, String email, String phoneNumber, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Balance: $" + String.format("%.2f", balance));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Welcome to Abrantie Bank!");
            System.out.println("Please provide the following details to create a new account:");

            System.out.print("Account Holder Name: ");
            String accountHolderName = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Phone Number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Initial Deposit Amount: $");
            double balance;

            while (true) {
                try {
                    balance = Double.parseDouble(scanner.nextLine());
                    if (balance < 0) {
                        System.out.println("Initial deposit cannot be negative. Please try again.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number for the initial deposit.");
                }
            }

            String accountNumber = "ACC" + String.format("%04d", (int) (Math.random() * 10000));

            BankAccount account = new BankAccount(accountNumber, accountHolderName, email, phoneNumber, balance);

            System.out.println("\nAccount created successfully!");
            account.displayAccountDetails();
        } finally {
           
            scanner.close();
        }
    }
}

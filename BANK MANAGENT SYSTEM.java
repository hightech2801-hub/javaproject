import java.util.Scanner;

class BankAccount {
    String accountNumber;
    String accountHolder;
    double balance;

    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposit successful.");
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance = balance - amount;
            System.out.println("Withdrawal successful.");
            System.out.println("Balance: " + balance);
        }
    }

    void display() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accountHolder = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account =
                new BankAccount(accountNumber, accountHolder, balance);

        int choice;

        do {

            System.out.println("\n===== BANK MANAGEMENT =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = sc.nextDouble();

                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter Withdrawal Amount: ");
                    double withdrawAmount = sc.nextDouble();

                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println(
                            "Current Balance: " + account.balance
                    );
                    break;

                case 4:
                    account.display();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
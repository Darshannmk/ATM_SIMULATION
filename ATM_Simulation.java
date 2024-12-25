import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A class that simulates the basic functions of an ATM machine.
 */
public class ATM_Simulation {
    private int pin;
    private int balance;
    private List<String> transactionHistory;

    /**
     * Constructor to initialize balance, PIN, and transaction history.
     *
     * @param balance Initial balance
     * @param pin Initial PIN
     */
    public ATM_Simulation(int balance, int pin) {
        this.balance = balance;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
    }

    /**
     * Method to change the PIN.
     *
     * @param new_pin New PIN to set
     * @return Message indicating the result of the operation
     */
    public String change_Pin(int new_pin) {
        if (!isValidPinSize(new_pin)) return "\tInvalid PIN size. Please enter a valid four-digit PIN.";
        this.pin = new_pin;
        transactionHistory.add("PIN changed successfully.");
        return "\tPIN change successful!";
    }

    /**
     * Method to deposit an amount.
     *
     * @param amount Amount to deposit
     * @return Message indicating the new balance after deposit
     */
    public String deposit(int amount) {
        if (amount <= 0) return "\tDeposit amount must be positive.";
        this.balance += amount;
        transactionHistory.add("Deposited: " + amount);
        return String.format("\tDeposit successful! New Balance: %d", this.balance);
    }

    /**
     * Method to withdraw an amount.
     *
     * @param amount Amount to withdraw
     * @return Message indicating the new balance after withdrawal
     */
    public String withdraw(int amount) {
        if (amount <= 0) return "\tWithdrawal amount must be positive.";
        if (amount > this.balance) return "\tInsufficient funds.";
        this.balance -= amount;
        transactionHistory.add("Withdrew: " + amount);
        return String.format("\tWithdrawal successful! New Balance: %d", this.balance);
    }

    /**
     * Method to check the balance.
     *
     * @return Message indicating the current balance
     */
    public String check_Balance() {
        return String.format("\tCurrent Balance: %d", this.balance);
    }

    /**
     * Method to verify the PIN.
     *
     * @param pin PIN to verify
     * @return True if the PIN is correct, false otherwise
     */
    public boolean isPinVerified(int pin) {
        return pin == this.pin;
    }

    /**
     * Method to check if the PIN size is valid.
     *
     * @param pin PIN to check
     * @return True if the PIN is a four-digit number, false otherwise
     */
    public boolean isValidPinSize(int pin) {
        return String.valueOf(pin).length() == 4;
    }

    /**
     * Method to display the transaction history.
     *
     * @return String representing the transaction history
     */
    public String getTransactionHistory() {
        StringBuilder history = new StringBuilder("\tTransaction History:\n");
        for (String transaction : transactionHistory) {
            history.append("\t").append(transaction).append("\n");
        }
        return history.toString();
    }

    /**
     * Main method to run the ATM simulation program.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ATM_Simulation atm = new ATM_Simulation(1000, 1000);

        // Prompt the user to enter their PIN
        System.out.print("Enter your 4-digit PIN: ");
        int pin = in.nextInt();

        // Verify the entered PIN
        if (!atm.isValidPinSize(pin) || !atm.isPinVerified(pin)) {
            System.out.println("\tInvalid PIN. Please try again.");
            return;
        }

        // Main menu loop for ATM operations
        while (true) {
            System.out.print("\n---> 1. Deposit\t2. Withdraw\t3. Change PIN\t4. Check Balance\t5. Transaction History\t6. Exit\nEnter your choice: ");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    System.out.println(atm.deposit(in.nextInt()));
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    System.out.println(atm.withdraw(in.nextInt()));
                    break;
                case 3:
                    System.out.print("Enter new 4-digit PIN: ");
                    System.out.println(atm.change_Pin(in.nextInt()));
                    break;
                case 4:
                    System.out.println(atm.check_Balance());
                    break;
                case 5:
                    System.out.println(atm.getTransactionHistory());
                    break;
                case 6:
                    System.out.println("\tThank you for using our ATM. Transactions completed.");
                    return;
                default:
                    System.out.println("\tInvalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}

# ATM Simulation

This Java program simulates the basic functions of an ATM machine. It allows users to perform essential banking tasks such as checking account balance, depositing money, withdrawing cash, changing PIN, and viewing transaction history.

## Features

- **Account Balance Inquiry**: Check the current balance of the account.
- **Cash Withdrawal**: Withdraw a specified amount from the account, provided there are sufficient funds.
- **Cash Deposit**: Deposit a specified amount into the account.
- **PIN Change**: Change the account PIN to a new one.
- **Transaction History**: View the history of all transactions, including deposits, withdrawals, and PIN changes.

## How to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/darshan-nmk/ATM_SIMULATION.git
   cd ATM_SIMULATION

2. **Compile the Code**:
   ```bash
   javac ATM_Simulation.java

3. **Run the Program**:
   ```bash
   java ATM_Simulation

4. **Follow the On-Screen Instructions**:
 Enter your PIN and choose from the menu options to perform various banking tasks.

## Code Overview
The main class ATM_Simulation includes the following methods:

- change_Pin(int new_pin): Changes the PIN after validating its size.

- deposit(int amount): Adds a specified amount to the balance and logs the transaction.

- withdraw(int amount): Deducts a specified amount from the balance if sufficient funds are available and logs the transaction.

- check_Balance(): Returns the current balance.

- isPinVerified(int pin): Verifies the entered PIN.

- isValidPinSize(int pin): Checks if the PIN is a four-digit number.

- getTransactionHistory(): Returns the transaction history as a formatted string.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

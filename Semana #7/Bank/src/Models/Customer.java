package Models;

public class Customer extends Person {
    private int accountNumber;

    public Customer(String firstName, String lastName, int accountNumber) {
        super(firstName, lastName);
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}

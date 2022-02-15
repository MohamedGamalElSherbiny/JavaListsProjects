package ListChallenges.BankAccountsExercise;

import java.util.ArrayList;

public class CustomerAccount {
    private String name;
    private String accountNumber;
    private final ArrayList<Double> transactions;

    public CustomerAccount(String name, String accountNumber, Double transactions) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.transactions = new ArrayList<>();
        addFunds(transactions);
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addFunds(double transaction){
        this.transactions.add(Math.max(transaction, 0.0));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}

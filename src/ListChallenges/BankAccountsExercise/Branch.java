package ListChallenges.BankAccountsExercise;

import java.util.ArrayList;

public class Branch {

    private final String name;

    private final ArrayList<CustomerAccount> customersList;

    public Branch(String name) {
        this.name = name;
        this.customersList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean addCustomer(String name, String accountNumber, double transactions){
        CustomerAccount customerAccount = new CustomerAccount(name, accountNumber, transactions);
        if(!queryCustomers(customerAccount)) {
            customersList.add(customerAccount);
            System.out.println("Account was created successfully.");
            return true;
        }
        System.out.println("This username and account number is already used, please try again.");
        return false;
    }

    public boolean removeCustomer(String name, String accountNumber){
        CustomerAccount customerAccount = new CustomerAccount(name, accountNumber, 0.0);
        int index = searchCustomersIndex(customerAccount);
        if( index >= 0){
            customersList.remove(index);
            System.out.println("Account was successfully removed.");
            return true;
        }
        return false;
    }

    public boolean modifyCustomerName(String oldName, String newName, String accountNumber){
        CustomerAccount customerAccount = new CustomerAccount(oldName, accountNumber, 0.0);
        int index = searchCustomersIndex(customerAccount);
        if(index >= 0){
            CustomerAccount customer = customersList.get(index);
            customer.setName(newName);
            System.out.println("Customer name : " + oldName + ", was changed to : " + newName + " .");
            return true;
        }
        System.out.println("There is no customer with that name and account number.");
        return false;
    }

    public boolean modifyAccountNumber(String name, String oldAccountNumber, String newAccountNumber){
        CustomerAccount customerAccount = new CustomerAccount(name, oldAccountNumber, 0.0);
        int index = searchCustomersIndex(customerAccount);
        if(index >= 0){
            CustomerAccount customer = customersList.get(index);
            customer.setName(newAccountNumber);
            System.out.println("Customer name : " + name + ", account number was changed from  " + oldAccountNumber + " to " + newAccountNumber);
            return true;
        }
        System.out.println("There is no customer with that name and account number.");
        return false;
    }

    public boolean makeTransaction(String name, String accountNumber, double transaction){
        CustomerAccount customerAccount = new CustomerAccount(name, accountNumber, transaction);
        int index = searchCustomersIndex(customerAccount);
        if(index >= 0){
            ArrayList<Double> transactions = customersList.get(index).getTransactions();
            double transactionsDouble = transactions.stream().mapToDouble(Double::doubleValue).sum();
            double sum = transactionsDouble + transaction;
            if(sum >= 0){
                customersList.get(index).addFunds(transaction);
                System.out.println("Transaction was successful. You now have " + sum + "$ in your account.");
                return true;
            }
        }
        System.out.println("Insufficient funds.");
        return false;
    }

    public double checkTransactions(String name, String accountNumber){
        CustomerAccount customerAccount = new CustomerAccount(name, accountNumber, 0.0);
        int index = searchCustomersIndex(customerAccount);
        ArrayList<Double> transactions = customersList.get(index).getTransactions();
        return transactions.stream().mapToDouble(Double::doubleValue).sum();
    }

    public boolean searchCustomers(String name, String accountNumber){
        CustomerAccount customerAccount = new CustomerAccount(name, accountNumber, 0.0);
        return queryCustomers(customerAccount);
    }

    public boolean printTransactions(String name, String accountNumber){
        CustomerAccount customerAccount = new CustomerAccount(name, accountNumber, 0.0);
        if(queryCustomers(customerAccount)) {
            int index = searchCustomersIndex(customerAccount);
            ArrayList<Double> transactions = customersList.get(index).getTransactions();
            for (int i = 0; i < transactions.size(); i++)
                System.out.println("Transaction #" + (i + 1) + "" +
                        " = " + transactions.get(i).toString());
            return true;
        }
        System.out.println("Incorrect username or account number.");
        return false;
    }

    public boolean printCustomers(boolean checkTransactions){
        if(customersList.size() <= 0) {
            System.out.println("You have no customers in your branch yet.");
            return false;
        }
        for(int i = 0; i < customersList.size(); i++){
            if(checkTransactions){
                double sum = checkTransactions(customersList.get(i).getName(), customersList.get(i).getAccountNumber());
                System.out.println("Customer #" + (i+1) + " with name " + customersList.get(i).getName() + " with " +
                        "account number " + customersList.get(i).getAccountNumber() + " has " + sum + "$.");
            } else {
                System.out.println("Customer #" + (i+1) + " with name " + customersList.get(i).getName() + " with " +
                        "account number " + customersList.get(i).getAccountNumber());
            }
        }
        return true;
    }

    private int searchCustomersIndex(CustomerAccount customerAccount){
        for(int i = 0; i < customersList.size(); i++){
            CustomerAccount customer = customersList.get(i);
            if(customer.getName().equals(customerAccount.getName()) &&
                    customer.getAccountNumber().equals(customerAccount.getAccountNumber())) return i;
        }
        return -1;
    }

    private boolean queryCustomers(CustomerAccount customerAccount){
        for(CustomerAccount customer: customersList){
            if(customer.getName().equals(customerAccount.getName()) &&
                    customer.getAccountNumber().equals(customerAccount.getAccountNumber())) return true;
        }
        return false;
    }
}

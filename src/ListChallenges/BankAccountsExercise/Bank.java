package ListChallenges.BankAccountsExercise;

import java.util.ArrayList;

public class Bank {

    private final String name;

    private final ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public boolean addBranch(String name){
        if(!queryBranches(name)) {
            Branch branch = new Branch(name);
            branches.add(branch);
            System.out.println("Branch was successfully added.");
            return true;
        }
        System.out.println("There is already a branch with that name");
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, String accountNumber, double transactions){
        int  index = searchBranchIndex(branchName);
        if(index >= 0){
            Branch branch = branches.get(index);
            if(branch.addCustomer(customerName, accountNumber, transactions)){
                System.out.println("Successful!");
                return true;
            }
        }
        System.out.println("Please try again.");
        return false;
    }

    public boolean removeCustomer(String branchName, String customerName, String accountNumber){
        int  index = searchBranchIndex(branchName);
        if(index >= 0){
            Branch branch = branches.get(index);
            if(branch.removeCustomer(customerName, accountNumber)){
                System.out.println("Successful!");
                return true;
            }
        }
        System.out.println("Please try again.");
        return false;
    }

    public boolean modifyCustomerName(String branchName, String oldName, String newName, String accountNumber){
        int  index = searchBranchIndex(branchName);
        if(index >= 0){
            Branch branch = branches.get(index);
            if(branch.modifyCustomerName(oldName, newName, accountNumber)){
                System.out.println("Successful!");
                return true;
            }
        }
        System.out.println("Please try again.");
        return false;
    }

    public boolean modifyAccountNumber(String branchName, String name, String oldAccountNumber, String newAccountNumber){
        int  index = searchBranchIndex(branchName);
        if(index >= 0){
            Branch branch = branches.get(index);
            if(branch.modifyAccountNumber(name, oldAccountNumber, newAccountNumber)){
                System.out.println("Successful!");
                return true;
            }
        }
        System.out.println("Please try again.");
        return false;
    }

    public boolean checkTransactions(String branchName, String name, String accountNumber){
        int  index = searchBranchIndex(branchName);
        if(index >= 0){
            Branch branch = branches.get(index);
            if(branch.checkTransactions(name, accountNumber) >= 0.0){
                System.out.println("Successful!");
                return true;
            }
        }
        System.out.println("Please try again.");
        return false;
    }

    public boolean searchCustomers(String branchName, String name, String accountNumber){
        int  index = searchBranchIndex(branchName);
        if(index >= 0){
            Branch branch = branches.get(index);
            if(branch.searchCustomers(name, accountNumber)){
                System.out.println("Successful!");
                return true;
            }
        }
        System.out.println("Please try again.");
        return false;
    }

    public boolean printTransactions(String branchName, String name, String accountNumber){
        int  index = searchBranchIndex(branchName);
        if(index >= 0){
            Branch branch = branches.get(index);
            if(branch.printTransactions(name, accountNumber)){
                System.out.println("Successful!");
                return true;
            }
        }
        System.out.println("Please try again.");
        return false;
    }

    public boolean printCustomers(String branchName, boolean checkTransactions){
        int  index = searchBranchIndex(branchName);
        if(index >= 0){
            Branch branch = branches.get(index);
            if(branch.printCustomers(checkTransactions)){
                System.out.println("Successful!");
                return true;
            }
        }
        System.out.println("Please try again.");
        return false;
    }

    public boolean makeTransaction(String branchName, String name, String accountNumber, double transaction){
        int  index = searchBranchIndex(branchName);
        if(index >= 0){
            Branch branch = branches.get(index);
            if(branch.makeTransaction(name, accountNumber, transaction)){
                System.out.println("Successful!");
                return true;
            }
        }
        System.out.println("Please try again.");
        return false;
    }

    private int searchBranchIndex(String name){
        if(branches.size() <= 0){
            System.out.println("You don't have any branches in this bank.");
            return -1;
        }
        for(int i = 0; i < branches.size(); i++){
            if(branches.get(i).getName().equals(name)) return i;
        }
        return -1;
    }

    private boolean queryBranches(String name){
        for(Branch branch: branches){
            if(branch.getName().equals(name)) return true;
        }
        return false;
    }
}
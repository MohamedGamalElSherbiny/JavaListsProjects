package ListChallenges.BankAccountsExercise;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("National Bank of Egypt");
        bank.addBranch("October");
        bank.addCustomer("October", "Mohamed", "1", 5885);
        bank.addCustomer("October", "Omar","2", 9394);
        bank.addCustomer("October", "Ahmed","3", 1930.2);
        bank.addBranch("Nasr City");
        bank.addCustomer("Nasr City", "Mohamed","1", 5885);
        bank.addCustomer("Nasr City", "Omar","2", 9394);
        bank.addCustomer("Nasr City", "Ahmed","3", 1930.2);

        if(bank.printCustomers("October", false)) System.out.println("Printed!");
        if(bank.printCustomers("Nasr City", true)) System.out.println("Printed!");

        if(!bank.addCustomer("Sheraton","Salma", "1", 8495.28)){
            System.out.println("ERROR");
        }
        if(!bank.addBranch("October")){
            System.out.println("Branch already exists.");
        }
        if(!bank.makeTransaction("October","Mahmoud","4", 474.5)){
            System.out.println("Customer does not exist.");
        }
        if(!bank.addCustomer("October", "Mohamed", "1", 5904)){
            System.out.println("Customer Mohamed already exists");
        }

    }

}

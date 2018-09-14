package bankaccount;

import java.util.Scanner;

public class BankAccount {
    public static void main(String[] args) {

            Bank bank = new Bank();
            Scanner in = new Scanner(System.in);
            boolean quit = false;

            do{
               System.out.println("1.New account ");
               System.out.println("2.Deposit in Account");
               System.out.println("3.Withdraw in Account");
               System.out.println("4.Statement");
               System.out.println("Enter Choice or 0. quit");
               
               int userselection = in.nextInt();
               switch(userselection)
               {
                   case 1:
                       System.out.println("1.Chargeable Fee account");
                       System.out.println("2.Fixed Fee account");
                       int accountType = in.nextInt();
                       System.out.println("Money to deposit: ");
                       double initialDeposit = in.nextDouble();

                       if(accountType == 1)
                           bank.NewAccount(new ChargeableFee(initialDeposit));
                       else if(accountType == 2)
                           bank.NewAccount(new FixedFee(initialDeposit));
                       break;
                    case 2:
                       double deposit = in.nextDouble();
                       bank.getAccount().deposit(deposit);
                       break;
                    case 3:
                       System.out.println("Money to withdraw: ");
                       double withdrawal = in.nextDouble();
                       bank.getAccount().withdraw(withdrawal);
                       break;
                    case 4:
                       bank.getAccount().printStatement();
                       break;
                    case 0:
                        quit = true;
                        break;
                    default:
                        System.out.println("Wrong Choice: ");
                        break;
               }
            }while (!quit);
            System.out.println("Bye!");
        }
    }


abstract class Account {

    Account(double intialbalance) {
        balance = intialbalance;
    }
    
    public void printStatement() {
        System.out.println("Your current balance is: " + this.balance);
    }
            
    public void deposit(double depositedMoney) {
        balance += depositedMoney;
    }
    
    public void withdraw(double moneyToWithdraw) {
        if(moneyToWithdraw < balance)
            balance -= moneyToWithdraw;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    private double balance;  
}


class ChargeableFee extends Account {
    
    ChargeableFee(double intialbalance) {
        super(intialbalance);
    } 
    
    public void deposit(double depositedMoney) {
       super.deposit(depositedMoney);
       numberOfTransactions++;
    }    
    
    public void withdraw(double moneyToWithdraw) {
        super.withdraw(moneyToWithdraw + 0.50);
        numberOfTransactions++;
    }
    
    public void printStatement() {
        super.printStatement();
        System.out.println("Number of transactions: " + numberOfTransactions);
    }    
    
    private int numberOfTransactions = 0;
}

class FixedFee extends Account {
    FixedFee(double intialbalance) {
        super(intialbalance);
    } 
}

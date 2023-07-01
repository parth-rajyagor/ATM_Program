import java.util.*;
import java.text.*;

class Account
{
    DecimalFormat moneyFormat = new DecimalFormat("'₹'###,##0.00");
    Scanner menuInput = new Scanner(System.in);
    
    private int AN;
    private int PN;
    private double CB = 3000;
    private double SB = 1500;
    
    void setAccountNumber(int an)
    {
        AN = an;
    }
    
    void setPINNumber(int pn)
    {
        PN = pn;
    }
    
    int getAccountNumber()
    {
        return AN;
    }
    
    int getPINNumber()
    {
        return PN;
    }
    
    void getCurrentBalance()
    {
        System.out.println("Your Current Account Balance is: " + moneyFormat.format(CB));
    }
    
    void getSavingsBalance()
    {
        System.out.println("Your Savings Account Balance is: " + moneyFormat.format(SB));
    }
    
    void getCurrentWithdrawInput()
    {
        System.out.println("Your Current Account Balance is: " + moneyFormat.format(CB));
        System.out.println("Enter the amount you want to withdraw from your Current Account: ");
        double amount = menuInput.nextDouble();
        if(CB - amount >=0)
        {
            calcCurrentWithdraw(amount);
            System.out.println("\nTransaction Successfull.");
            System.out.println("Now, Your Current Account Balance is: " + moneyFormat.format(CB) + "\n");
        }
        else
        {
            System.out.println("Your balance is insufficient for this transaction.\n");
        }
    }
    
    double calcCurrentWithdraw(double amount)
    {
        CB = CB - amount;
        return CB;
    }
    
    void getSavingsWithdrawInput()
    {
        System.out.println("Your Savings Account Balance is: " + moneyFormat.format(SB));
        System.out.println("Enter the amount you want to withdraw from your Savings Account: ");
        double amount = menuInput.nextDouble();
        if(SB - amount >=0)
        {
            calcSavingsWithdraw(amount);
            System.out.println("\nTransaction Successfull.");
            System.out.println("Now, Your Savings Account Balance is: " + moneyFormat.format(SB) + "\n");
        }
        else
        {
            System.out.println("Your balance is insufficient for this transaction.\n");
        }
    }
    
    double calcSavingsWithdraw(double amount)
    {
        SB = SB - amount;
        return SB;
    }
    
    void getCurrentDepositInput()
    {
        System.out.println("Your Current Account Balance is: " + moneyFormat.format(CB));
        System.out.print("Enter the amount you want to deposit in your Current Account: ");
        double amount = menuInput.nextDouble();
        if(CB + amount >=0)
        {
            calcCurrentDeposit(amount);
            System.out.println("\nTransaction Successfull.");
            System.out.println("Now, Your Current Account Balance is: " + moneyFormat.format(CB) + "\n");
        }
        else
        {
            System.out.println("Please Enter Valid Amount.");
        }
    }
    
    double calcCurrentDeposit(double amount)
    {
        CB = CB + amount;
        return CB;
    }
    
    void getSavingsDepositInput()
    {
        System.out.println("Your Savings Account Balance is: " + moneyFormat.format(SB));
        System.out.println("Enter the amount you want to deposit in your Savings Account: ");
        double amount = menuInput.nextDouble();
        if(SB + amount >=0)
        {
            calcSavingsDeposit(amount);
            System.out.println("\nTransaction Successfull.");
            System.out.println("Now, Your Savings Account Balance is: " + moneyFormat.format(SB) + "\n");
        }
        else
        {
            System.out.println("Please Enter Valid Amount.");
        }
    }
    
    double calcSavingsDeposit(double amount)
    {
        SB = SB + amount;
        return SB;
    }
}

class OptionMenu extends Account
{
    Scanner menuInput = new Scanner(System.in);
    HashMap<Integer, Integer> data = new HashMap<>();
    
    void getLogin()
    {
        int TTT = 125125;
        do
        {
            try
            {
                data.put(11111,111);
                data.put(22222,222);
                data.put(33333,333);
                data.put(44444,444);
                data.put(55555,555);
                
                System.out.println("Welcome to KC COLLEGE ATM");
                System.out.print("\nEnter your Account Number: ");
                setAccountNumber(menuInput.nextInt());
                
                System.out.print("Enter your PIN number: ");
                setPINNumber(menuInput.nextInt());
                
                int P = getAccountNumber();
                int R = getPINNumber();
                
                if(data.containsKey(P) && data.get(P) == R)
                {
                    getAccountType();
                }
                else
                {
                    System.out.println("\nWrong Account Number or PIN Number.");
                    System.out.println("Please try again with valid Account Number.\n");
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("\nPlease Enter only numbers !!!");
                System.out.println("Characters and symbols are not allowed.");
                TTT = 125126;
            }
        }
        while(TTT == 125125);
    }
    
    void getAccountType()
    {
        System.out.println("Select the Account Type you want to Access.");
        System.out.println("Type 1: Current Account");
        System.out.println("Type 2: Savings Account");
        System.out.println("Type 3: Exit");
        System.out.print("Choice: ");
        int Select = menuInput.nextInt();
        switch(Select)
        {
            case 1:
                getCurrent();
                break;
            case 2:
                getSavings();
                break;
            case 3:
                System.out.println("Thank you using this ATM. \nVisit Again...");
                break;
            default:
                System.out.println("Invalid choice !!! \nPlease enter the valid choice.");
                break;
        }
    }
    
    void getCurrent()
    {
        System.out.println("Current Account");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw Funds");
        System.out.println("Type 3: Deposit Funds");
        System.out.println("Type 4: Exit");
        System.out.print("Enter your Choice: ");
        int Select = menuInput.nextInt();
        switch(Select)
        {
            case 1:
                getCurrentBalance();
                getAccountType();
                break;
            case 2:
                getCurrentWithdrawInput();
                getCurrent();
                break;
            case 3:
                getCurrentDepositInput();
                getCurrent();
                break;
            case 4:
                System.out.println("Thank you using this ATM. \nVisit Again...");
                break;
            default:
                System.out.println("Invalid choice !!! \nPlease enter the valid choice.");
                break;
        }
    }
    
    void getSavings()
    {
        System.out.println("Savings Account");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw Funds");
        System.out.println("Type 3: Deposit Funds");
        System.out.println("Type 4: Exit");
        System.out.print("Enter your Choice: ");
        int Select = menuInput.nextInt();
        switch(Select)
        {
            case 1:
                getSavingsBalance();
                getAccountType();
                break;
            case 2:
                getSavingsWithdrawInput();
                getSavings();
                break;
            case 3:
                getSavingsDepositInput();
                getSavings();
                break;
            case 4:
                System.out.println("Thank you using this ATM. \nVisit Again...");
                break;
            default:
                System.out.println("Invalid choice. \nPlease enter the valid choice.");
                break;
        }        
    }
}

public class ATM extends OptionMenu
{
    public static void main(String[] args)
    {
        OptionMenu obj = new OptionMenu();
        obj.getLogin();
    }
}
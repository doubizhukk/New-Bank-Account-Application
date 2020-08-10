package bankaccountapp;

public abstract class Account implements IBaseRate {
    //List common properties for savings and checking accounts
    private String name;
    private String sSN;
    private double balance;

    private static int index = 10000;
    protected String accountNumber;
    protected double rate;

    //constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit){
        this.name = name;
        this.sSN= sSN;
        balance = initDeposit;

        //set account number
        index++;
        this.accountNumber = setAccountNumber();

        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber(){
        String lastTwoOfSSN = sSN.substring(sSN.length()-2);
        int uniqueID = index;
        int randomNumber = (int)( Math.random() * Math.pow(10,3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound(){
        double accruedInterest = balance * (rate / 100);
        balance += accruedInterest;
        printBalance();
    }

    //list common methods
    public void deposit(double amount){
        balance += amount;
        printBalance();
    }
    public void withdraw(double amount){
        balance -= amount;
        printBalance();
    }
    public void transfer(String toWhere, double amount){
        balance -= amount;
        System.out.println("Transfering $" + amount + "to " + toWhere);
        printBalance();
    }
    public void printBalance(){
        System.out.println("Your balance is now: $" + balance);
    }
    public void showInfo(){
        System.out.println("Name: " + name +
                        "\nACCOUNT NUMBER: " + accountNumber +
                        "\nBALANCE: " + balance +
                        "\nRATE: " + rate
        );

    }
}

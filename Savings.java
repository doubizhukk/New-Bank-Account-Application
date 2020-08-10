package bankaccountapp;

public class Savings extends Account {
    //list properties specific to the saving account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // constructor to initialize settings for the saving properties
    public Savings(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepostBox();
    }

    @Override
    public void setRate(){
        rate = getBaseRate() - 0.25;

    }

    private void setSafetyDepostBox(){
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
    }

    //list any methods specific to saving account
    public void showInfo(){
        System.out.println("ACCOUNT TYPE: Saving");
        super.showInfo();
        System.out.println("your savings account features" +
                "\n safety deposit box id: " + safetyDepositBoxID +
                "\n safety deposit box key: " + safetyDepositBoxKey
                );
    }
}

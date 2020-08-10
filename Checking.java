package bankaccountapp;

public class Checking extends Account {
    // list properties specific to a checking account
    private int debitCardNumber;
    private int debitCardPIN;

    //constructor to initialize checking account properties
    public Checking(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    @Override
    public void setRate(){
        rate = getBaseRate() * 0.15;

    }

    public void setDebitCard(){
        debitCardNumber = (int) (Math.random() * Math.pow(10,12));
        debitCardPIN = (int) (Math.random() * Math.pow(10,4));
    }

    //list any methods specific to the checking account

    public void showInfo(){
        System.out.println("ACCOUNT TYPE: Checking");
        super.showInfo();
        System.out.println("your checking account features" +
                "\n debit card number: " + debitCardNumber +
                "\n debit card PIN: " + debitCardPIN
        );
    }
}

import java.util.Objects;
import java.util.UUID;

public class SBIUser implements BankInterface{
    private String name;
    private String accountNo;
    private double balance;
    private String password;
    private static double rateOfInterest;

    public SBIUser(String name , double balance , String password){
        this.name = name;
        this.balance = balance;
        this.password = password;

        this.rateOfInterest = 7;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    public String getAccountNo() {
        return accountNo;
    }

    public static double getRateOfInterest() {
        return rateOfInterest;
    }

    public static void setRateOfInterest(double rateOfInterest) {
        SBIUser.rateOfInterest = rateOfInterest;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance = balance+amount;
        return "Your Balance is Updated";
    }

    @Override
    public String withdrawMoney(int amount, String enteredPassword) {
        if(Objects.equals(enteredPassword,password)){
            if(amount > balance){
                return "Balance is Lower The Requested.";
            }
            else{
                balance = balance-amount;
                return "Withdraw Completed.";
            }
        }
        return "Password is worng.";
    }

    @Override
    public double calculateInterest(int years) {
        return (balance*years*rateOfInterest)/100;
    }
}

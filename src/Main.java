import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name , password , balance to create an account");

        

        // init
        String name = sc.nextLine();
        String password = sc.nextLine();
        double balance = sc.nextDouble();

        //create user
        SBIUser user = new SBIUser(name,balance,password);

        //add money
        String message = user.addMoney(100000);
        System.out.println(message);

        //withDraw money
        System.out.println("Enter amount you want to withdraw.");
        int money = sc.nextInt();
        System.out.println("Enter your pin.");
        String pin = sc.next();
        System.out.println(user.withdrawMoney(money,pin));

        //check balance
        System.out.println(user.checkBalance());

        //calculate interest
        System.out.println(user.calculateInterest(10));
    }
}
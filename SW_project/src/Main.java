import java.util.Scanner;
import java.util.Vector;

/**
 * Created by LENOVO on 16/12/20.
 * */

public class Main {

    public static void main(String[] args ){

        Account_modle account_modle=new Account_modle();
        Scanner in = new Scanner(System.in); //GUI

        while (true) {
            Account account;
            System.out.println("sign_in(s)/ log_in(l):"); //GUI

            String input = in.nextLine();

            if (input.equals("s")) {
                System.out.println("Teacher(t)/Student(s) :");//GUI
                input=in.nextLine();
                if (input.equals("t")){
                    account = new Teacher();
                } else {
                    account = new Student();
                }

                account.signin(account_modle);

            }

            else {

                System.out.println("User Name : ");//GUI
                String u_name = in.nextLine();
                System.out.println("Password : ");//GUI
                String pw = in.nextLine();
                account = new Account();
                account = account.login(u_name, pw, account_modle);

            }



        }

    }


}



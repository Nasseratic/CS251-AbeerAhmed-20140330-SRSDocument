import java.util.Scanner;
import java.util.Vector;

/**
 * Created by LENOVO on 16/12/20.
 * */

public class Main {

    public static void main(String[] args ){

        Account_modle account_modle=new Account_modle();
        GUI _GUI=new GUI();
        account_modle.loadAccountsData();
        while (true) {
            Account account;
            String inputs;
            inputs=_GUI.display_in_or_up();
            if (inputs.equals("s")) {

                inputs=_GUI.display_t_or_s();

                if (inputs.equals("t")){
                    account = new Teacher();
                } else {
                    account = new Student();
                }

                account.signUp(_GUI.display_signUp_form(),account_modle);
                account_modle.saveAccountsData();
            }

            else {
                String []u_name_pw =_GUI.display_login_form();

                account = new Account();
                account = account.login(u_name_pw[0], u_name_pw[1], account_modle);
            }


        }


    }


}


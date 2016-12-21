import java.util.Scanner;
import java.util.Vector;

/**
 * Created by LENOVO on 16/12/20.
 * */

public class Main {

    public static void main(String[] args ){

        Account_model account_model=new Account_model();
        GameModel gameModel = new GameModel();
        GUI _GUI=new GUI();

        //Loads all Accounts from Files
        account_model.loadAccountsData();
        gameModel.loadGames();

        while (true) {

            Account account; // The current Account
            Game game; // The current Game
            String inputs; //Just to Hold User Chose
            //get user choose sign up or log in
            inputs=_GUI.display_in_or_up();
            if (inputs.equals("s")) {

                //SD1 sign up
                inputs=_GUI.display_t_or_s();
                //get user choose to sign up as Student or Teacher
                if (inputs.equals("t")){
                    account = new Teacher();
                } else {
                    account = new Student();
                }
                //Sign up & save all info to Account_Model
                account.signUp(_GUI.display_signUp_form(),account_model);
                account_model.saveAccountsData();
            }

            else if (inputs.equals("l")){
                //get login info user name and password
                String []u_name_pw =_GUI.display_login_form();
                account = new Account();

                //Get the user Account
                account = account.login(u_name_pw[0], u_name_pw[1], account_model);

                if(account.verify().equals("Student")){
                    //SD2 play game
                    //The code for what a Student can do
                    while (true) {
                        inputs = _GUI.displayGames(gameModel);
                        if (inputs.equals("e")) {
                            break;
                        }
                        game = new Game();
                        game=game.choose(inputs, gameModel);
                        _GUI.display_score(   game.play()    ) ;

                    }
                }
                else if (account.verify().equals("Teacher")){
                    //SD3 add game
                    //The code for what a Teacher can do
                    game = new Game();
                    game.createGame();
                    gameModel.addGame(game);
                    gameModel.saveGamesData();

                }
                //Error then Exit
                else {
                    _GUI.error();
                }

            }
            //Eixt
            else if (inputs.equals("e")){
                _GUI.exit();
                return;
            }
            //Error then Exit
            else {
                _GUI.error();
                return;
            }


        }


    }


}


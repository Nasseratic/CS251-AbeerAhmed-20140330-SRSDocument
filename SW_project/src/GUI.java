import java.util.Scanner;

/**
 * Created by LENOVO on 16/12/20.
 */
class GUI{

    Scanner in = new Scanner(System.in);

    void display_score(int score){
        System.out.println("Score : "+score);
    }

    String display_in_or_up(){
        System.out.println("signUp(s)/ log_in(l)/exit(e):"); //GUI
        String input = in.nextLine();
        return input;
    }

     String displayGames(GameModel gameModel){
        for(int i=0; i<gameModel.getGames().size(); i++)
            System.out.println(i + "." + gameModel.getGames().get(i).getName());
         System.out.println("Enter Game Name : ");
        return in.nextLine();
    }

    String display_t_or_s(){
        System.out.println("Teacher(t)/Student(s):");//GUI
        String input = in.nextLine();
        return input;
    }

    String[] display_login_form(){
        String[] str = new String[2];
        System.out.println("User Name : ");//GUI
        str[0] = in.nextLine();
        System.out.println("Password : ");//GUI
        str[1] = in.nextLine();
        return str;
    }

    String[] display_signUp_form(){
        String[] str = new String[5];
        System.out.println("name:");
        str[0] = in.nextLine();
        System.out.println("age:");
        str[1] =in.nextLine();
        System.out.println("gender:");
        str[2] = in.nextLine();
        System.out.println("user name:");
        str[3]= in.nextLine();
        System.out.println("password:");
        str[4] = in.nextLine();

        return str;
    }

    void error(){
        System.out.println("Error..");
    }

    void exit(){
        System.out.println("exit ..");
    }

}

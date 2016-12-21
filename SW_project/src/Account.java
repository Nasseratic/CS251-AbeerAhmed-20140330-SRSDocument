import java.util.Scanner;

/**
 * Created by LENOVO on 16/12/20.
 */
class Account {
    protected String name;
    protected String gender;
    protected int age;
    protected String u_name;
    protected String pw;

    //Get Account with this User name & password or return null
    Account login(String u_name , String pw , Account_model model){

        int index = model.check(u_name,pw);
        if( index != -1){
            System.out.println("Welcome "+model.load(index).name +" .");
            return model.load(index);
        }

        System.out.println("Incorrect user name/password entered. Please try again.");
        return null;

    }

    //setting info to the object



    void signUp(String[] info,Account_model model){
        this.name=info[0];
        this.age=Integer.parseInt(info[1]);
        this.gender=info[2];
        this.u_name=info[3];
        this.pw=info[4];
        model.save(this);
    }

    //return the object type
    //Implemented for each child
    String verify(){
        return "";
    }

}

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

    Account login(String u_name , String pw , Account_modle modle){

        int index = modle.check(u_name,pw);
        if( index != -1){
            System.out.println("Welcome "+modle.load(index).name +" .");
            return modle.load(index);
        }

        System.out.println("Incorrect user name/password entered. Please try again.");
        return null;

    }

    void setInfo(String name , int age , String gender , String u_name , String pw ){

        this.name=name;
        this.age=age;
        this.gender=gender;
        this.u_name=u_name;
        this.pw=pw;

    }

    void signUp(String[] info,Account_modle modle){
        setInfo(info[0],Integer.parseInt(info[1]),info[2],info[3],info[4]);
        modle.save(this);
    }


    String verify(){

        return "";
    }

}

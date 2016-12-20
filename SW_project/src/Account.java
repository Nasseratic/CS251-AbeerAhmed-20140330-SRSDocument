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

    void signin(Account_modle modle){
        Scanner in = new Scanner(System.in);
        System.out.println("name:");
        String n = in.nextLine();
        System.out.println("age:");
        int a =Integer.parseInt(in.nextLine());
        System.out.println("gender:");
        String g = in.nextLine();
        System.out.println("user name:");
        String u = in.nextLine();
        System.out.println("password:");
        String p = in.nextLine();
        setInfo(n,a,g,u,p);
        modle.save(this);
    }


    String verify(){

        return "";
    }

}

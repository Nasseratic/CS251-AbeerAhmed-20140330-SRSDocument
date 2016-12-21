import java.io.*;
import java.util.Vector;

/**
 * Created by LENOVO on 16/12/20.
 */

class Account_model {


    private Vector<Account> accounts = new Vector<>();

    //Check User Name and Password
    int check(String u_name , String pw){
        for (int i = 0; i < accounts.size() ; i++) {

            if (accounts.elementAt(i).u_name.equals(u_name) && accounts.elementAt(i).pw.equals(pw)){
                return i;
            }

        }
        return -1;
    }

    //add this Account to Accounts
    void save(Account account){
        accounts.add(account);
    }

    //get Account by Index
    Account load (int index){

        return accounts.elementAt(index);
    }

    //save all Accounts to the file
    void saveAccountsData(){
     String file="";
        for (int i = 0; i <accounts.size() ; i++) {
            file+=accounts.elementAt(i).name+",";
            file+=accounts.elementAt(i).age+",";
            file+=accounts.elementAt(i).gender+",";
            file+=accounts.elementAt(i).u_name+",";
            file+=accounts.elementAt(i).pw+",";
            file+=accounts.elementAt(i).verify()+"_";
        }

        write("accounts.txt",file);
    }

    //load all Accounts from the file
    void loadAccountsData(){
        if(!read("accounts.txt").isEmpty()) {
            String[] file = read("accounts.txt").split("_");
            for (String str : file) {
                String[] attebuts = str.split(",");
                Account a;
                if(attebuts[5].equals("Teacher")) {
                    a= new Teacher();
                }
                else {
                    a= new Student();
                }
                a.setInfo(attebuts[0], Integer.parseInt(attebuts[1]), attebuts[2], attebuts[3], attebuts[4]);
                accounts.add(a);
            }
        }
    }

    //read from File accounts.txt
    public static String read(String path)  {
        String output="" ;
        try {
            FileReader fr =new FileReader(path);
            BufferedReader br =new BufferedReader(fr);
            String str="" ;

            while ( (str=br.readLine()) != null ){
                output+=str;
            }
        }
        catch (IOException e){
            System.out.println("Not found !");
        }
        return output;
    }

    //write to File accounts.txt
    public static void write(String path,String str )  {
        try {
            FileWriter fw = new FileWriter(path);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(str);
            pw.close();
        }
        catch (IOException e){
            System.out.println("ERORR");
        }
    }

}

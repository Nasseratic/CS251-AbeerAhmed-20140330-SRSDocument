import java.util.Vector;

/**
 * Created by LENOVO on 16/12/20.
 */
class Account_modle {

    private Vector<Account> accounts = new Vector<>();


    int check(String u_name , String pw){
        for (int i = 0; i < accounts.size() ; i++) {

            if (accounts.elementAt(i).u_name.equals(u_name) && accounts.elementAt(i).pw.equals(pw)){
                return i;
            }

        }
        return -1;
    }

    void save(Account account){
        accounts.add(account);
    }

    Account load (int index){

        return accounts.elementAt(index);
    }


}

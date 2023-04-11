class Account {
    private int accBal;
    private String accHolderName;

    public int getAccBal() {
        return accBal;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccBal(int accBal) {
        this.accBal = accBal;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    Account(int balance, String name) {
        this.accBal = balance;
        this.accHolderName = name;
    }

    public void getDetails() {
        System.out.println("Account Holder's name is " + this.getAccHolderName());
        System.out.println("Account balance is " + this.getAccBal());
    }
}

class SingleTonBanker {
    private int id;
    private static SingleTonBanker sb = null;

    private SingleTonBanker(int id) {
        this.id = id;
    }

    public static SingleTonBanker getInstance() {
        sb = new SingleTonBanker(101);

        return sb;
    }

    public void ShowMsg() {
        System.out.println(this.id);
    }

    public Account openAccount(int balance, String name) {
        return new Account(balance, name);
    }
}

public class bankaccsingleton {
    public static void main(String[] args) {
        SingleTonBanker s = SingleTonBanker.getInstance();
        Account a1 = s.openAccount(10000, "Dev");
        Account a2 = s.openAccount(2000, "Ronak");
        SingleTonBanker s1 = SingleTonBanker.getInstance();
        Account a3 = s1.openAccount(1000, "Khush");
        a1.getDetails();
        a2.getDetails();
        a3.getDetails();

        s.ShowMsg();
        s1.ShowMsg();
    }
}

package po73.kosenko.oop.model;

public class Account {
    private String number;
    private double balance;

    public Account() {
        this("",0);
    }

    public Account(String number, double balance) {
       this.balance = balance;
       this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}

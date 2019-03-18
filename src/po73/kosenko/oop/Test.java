package po73.kosenko.oop;

import po73.kosenko.oop.model.Account;

public class Test {
    public static void main(String[] args) {
        System.out.println("Я сделяль");
        lab1Tests();
    }

    public static void lab1Tests() {
        Account account1 = new Account();
        Account account2 = new Account("jhgf",10);
        System.out.println("balance Account1=" + account1.getBalance());
        System.out.println("number Account2=" + account2.getNumber());
    }
}

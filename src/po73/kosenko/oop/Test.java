package po73.kosenko.oop;

import po73.kosenko.oop.model.Account;
import po73.kosenko.oop.model.AccountManager;
import po73.kosenko.oop.model.Individual;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println ("Я сделяль");
        lab1Tests ( );
    }

    public static void lab1Tests() {
        Account account1 = new Account ( );
        Account account2 = new Account ("jhgf", 10);
        System.out.println ("balance Account1=" + account1.getBalance ( ));
        System.out.println ("number Account2=" + account2.getNumber ( ));

        Individual individual1 = new Individual ( );
        Individual individual2 = new Individual ( );
        Individual individual3 = new Individual ( );
        System.out.println ("Добавить " + individual1.add (account1));
        System.out.println ("Добавить с индексом " + individual1.add (1, account1));
        System.out.println ("Возвратить аккаунты " + individual1.get (1));
        System.out.println ("Есть ли аккаунт с заданным счетом " + individual1.hasAccount ("5"));
        System.out.println ("Возвратить изменные аккаунты " + individual1.change (1, account2));
        System.out.println ("Удалить аккаунт по индексу " + individual1.delete (1));
        System.out.println ("Возвратить аккаунты " + individual1.delete (1));
        System.out.println (individual1.delete ("апваппав"));
        System.out.println (individual1.getAccountsCount ( ));
        System.out.println (Arrays.deepToString (individual1.getAccounts ( )));
        System.out.println (Arrays.deepToString (individual1.sortedAccounts ( )));
        System.out.println (individual1.totalBalance ( ));

        AccountManager accountManager = new AccountManager (new Individual[]{individual1, individual2});
        System.out.println (accountManager.add (individual3));
        System.out.println (accountManager.add (1, individual1));
        System.out.println (accountManager.change (4, individual1));
        System.out.println (accountManager.delete (4));
        System.out.println (Arrays.deepToString ((accountManager.sortedIndividual ( ))));
        System.out.println (accountManager.get ("dfghg"));
        System.out.println (accountManager.delete ("45"));
        System.out.println (accountManager.change (4, individual1));
    }

}

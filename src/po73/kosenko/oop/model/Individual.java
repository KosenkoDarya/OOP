package po73.kosenko.oop.model;

public class Individual {
    private Account[] accounts;
    private int accountsCount;
    private static final int DEFAULT_LENGTH = 16;

    public Individual() {
        this(DEFAULT_LENGTH);
    }

    public Individual(int accountsLength) {
        this.accounts = new Account[accountsLength];
        this.accountsCount = 0;
    }

    public Individual(Account[] accounts) {
        Account[] newAccounts = new Account[accounts.length];
        System.arraycopy(accounts, 0, newAccounts,0, accounts.length);
        this.accounts = newAccounts;
        this.accountsCount = accounts.length;
    }

    public boolean add(Account account) {
        if (accountsCount == accounts.length){
            doubleArray();
        }
        accounts[accountsCount] = account;
        accountsCount++;
        return  true;
    }

    public boolean add(int index, Account account) {
        if (accountsCount == accounts.length){
            doubleArray();
        }
        System.arraycopy(accounts,index,accounts,accounts.length - index,accountsCount);
        accounts[index] = account;
        return true;
    }

    private void doubleArray(){
        Account[] doubleSizeAccount = new Account[accounts.length * 2];
        System.arraycopy(accounts,0,doubleSizeAccount,0,accountsCount);
        accounts = doubleSizeAccount;
    }

    public Account get(int index) {
        return accounts[index];
    }

    public Account get(String number) {
        for (Account account : accounts) {
            if (account.getNumber().equals(number)){
                return account;
            }
        }
        return null;
    }

    public boolean hasAccount(String number) {
        for (Account account : accounts) {
            if (account.getNumber().equals(number)) {
                return true;
            }
        }
        return false;
    }

    public Account change(int index, Account account) {
        Account oldAccount = accounts[index];
        accounts[index] = account;
        return oldAccount;
    }

    public Account delete(int index) {
        Account oldAccount = accounts[index];
        System.arraycopy(accounts,index + 1,accounts,index,accounts.length - index - 1);
        return oldAccount;
    }

    public Account delete(double balance) {
        for (int i = 0; i < accountsCount; i++) {
            if (balance == accounts[i].getBalance()) {
                return delete(i);
            }
        }
        return null;
    }

    public int getAccountsCount(){
         return accountsCount;
    }

    public Account[] getAccounts(){
        Account[] notNullAccounts = new Account[accountsCount];
        System.arraycopy(accounts,0,notNullAccounts,0,accountsCount);
        return notNullAccounts;
    }
    //todo СДЕЛАТЬ СОРТИРОВКУ

    public double totalBalance() {
        double totalBalance = 0;
        for (int i = 0; i < accountsCount; i++) {
            totalBalance += accounts[i].getBalance();
        }
        return totalBalance;
    }

}

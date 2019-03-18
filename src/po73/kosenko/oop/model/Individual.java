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


        return true;
    }
}

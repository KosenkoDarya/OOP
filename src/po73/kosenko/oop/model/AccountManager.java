package po73.kosenko.oop.model;

public class AccountManager {
    private Individual[] individuals; // массив физ.лиц
    private int individualCount;

    public AccountManager(int individualCount) {
        this.individuals = new Individual[individualCount];
        this.individualCount = individualCount;
    }

    public AccountManager(Individual[] individuals) {
        this.individuals = new Individual[individuals.length];
        System.arraycopy(individuals, 0, this.individuals, 0, individuals.length);
        individualCount = individuals.length;
    }

    private void doubleArray(){
        Individual[] doubleSizeIndividual = new Individual[individuals.length * 2];
        System.arraycopy(individuals,0,doubleSizeIndividual,0,individualCount);
        individuals = doubleSizeIndividual;
    }

    public boolean add(Individual individual) {
        if (individualCount == individuals.length){
            doubleArray();
        }
        individuals[individualCount] = individual;
        individualCount++;
        return  true;
    }

    public boolean add(int index, Individual individual) {
        if (individualCount == individuals.length){
            doubleArray();
        }
        System.arraycopy(individuals,index,individuals,individuals.length - index,individualCount);
        individuals[index] = individual;
        return true;
    }

    public Individual get(int index) { return individuals[index]; }

    public Individual change(int index, Individual individual) {
        Individual oldIndividual = individuals[index];
        individuals[index] = individual;
        return oldIndividual;
    }

    public Individual delete(int index) {
        Individual oldIndividual = individuals[index];
        System.arraycopy(individuals,index + 1,individuals,index,individuals.length - index - 1);
        return oldIndividual;
    }

    public int individualCount() {
        return individualCount;
    }
    public Individual arrayIndividual() { return individuals[individualCount]; }

    public Individual[] sortedIndividual(){
        Individual[] sortedIndividual = new Individual[individualCount];
        System.arraycopy(individuals,0,sortedIndividual,0,individualCount);
        for (int i = 0; i < individualCount; i++) {
            Individual min = sortedIndividual [i];
            int minIndex = i;
            for (int j = i + 1; j < individuals.length; j++) {
                if (sortedIndividual[j].totalBalance() < min.totalBalance()) {
                    min = sortedIndividual[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                Individual tmp = sortedIndividual[i];
                sortedIndividual[i] = sortedIndividual[minIndex];
                sortedIndividual[minIndex] = tmp;
            }
        }
        return sortedIndividual();
    }

    public Account get(String number) {
        for (Account account : accounts) {
            if (account.getNumber().equals(number)){
                return account;
            }
        }
        return null;
    }

    public Account delete(double balance) {
        for (int i = 0; i < accountsCount; i++) {
            if (balance == accounts[i].getBalance()) {
                return delete(i);
            }
        }
        return null;
    }


    public Account change(int index, Account account) {
        Account oldAccount = accounts[index];
        accounts[index] = account;
        return oldAccount;
    }


}

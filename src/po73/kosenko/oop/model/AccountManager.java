package po73.kosenko.oop.model;

public class AccountManager {
    private Individual[] individuals; // массив физ.лиц
    private int individualCount;

    public AccountManager(int individualCount) {
        this.individuals = new Individual[individualCount];
        this.individualCount = 0;
    }

    public AccountManager(Individual[] individuals) {
        this.individuals = new Individual[individuals.length];
        System.arraycopy(individuals, 0, this.individuals, 0, individuals.length);
        this.individualCount = individuals.length;
    }

    private void doubleArray() {
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
        return true;
    }

    public boolean add(int index, Individual individual) {
        if (individualCount == individuals.length){
            doubleArray();
        }
        System.arraycopy(individuals,index + 1,individuals, index, individualCount - index - 1);
        individuals[index] = individual;
        individualCount++;
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
        individualCount--;
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
            for (int j = i + 1; j < individualCount; j++) {
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
        return sortedIndividual;
    }

    public Account get(String number) {
        Account account;
        for (int i = 0; i < individualCount; i++) {
            if ((account = individuals[i].get(number)) != null)
                return account;
        }
        return null;
    }

    public Account delete(String number) {
        Account account;
        for (int i = 0; i < individualCount; i++) {
            if ((account = individuals[i].delete(number)) != null)
                return account;
        }
        return null;
    }


    public Account change(String number, Account account) {
        Individual individual;
        for (int i = 0; i < individualCount; i++) {
            individual = individuals[i];
            for (int j = 0; j < individual.getAccountsCount(); j++) {
                if (individual.get(j).getNumber().equals(number))
                    return individual.change(j, account);
            }
        }
        return null;
    }


}

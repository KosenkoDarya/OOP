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

    public Individual[] arrayIndividual() {
        Individual[] newIndidvidual = new Individual[individualCount];
        System.arraycopy(individuals, 0, newIndidvidual,0, individualCount);
        return newIndidvidual;
    }

    public Individual[] sortedIndividual(){
        Individual[] newIndividual = arrayIndividual();
        for (int i = 0; i < individualCount; i++) {
            Individual min = newIndividual[i];
            int minIndex = i;
            for (int j = i + 1; j < individualCount; j++) {
                if (newIndividual[j].totalBalance() < min.totalBalance()) {
                    min = newIndividual[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                Individual tmp = newIndividual[i];
                newIndividual[i] = newIndividual[minIndex];
                newIndividual[minIndex] = tmp;
            }
        }
        return newIndividual;
    }
    //todo сначала вызываешь hasAccount и если есть - соответсвующий метод. Это в следующих трех методах
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
        Account changedAccount;
        for (int i = 0; i < individualCount; i++) {
            if ((account = individuals[i].get(number)) != null)
                return account;
        }
        return null;
    }


}

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


}

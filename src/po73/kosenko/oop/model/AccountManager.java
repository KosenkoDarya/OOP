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


}

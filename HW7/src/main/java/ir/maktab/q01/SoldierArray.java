package ir.maktab.q01;

public class SoldierArray {

    private  Soldier[] soldiers = new Soldier[15];
    private int countOfAddedSoldier = 0;

    public void addSoldiers(Soldier soldiers) {
        this.soldiers[countOfAddedSoldier] = soldiers;
        countOfAddedSoldier++;
    }

    public Soldier getSoldier(int i) {
        return soldiers[i];
    }

}

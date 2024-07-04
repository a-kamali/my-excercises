package ir.maktab.q01;

public class Soldier {

    private Integer ID;
    private int initalSoldierRank;
    private int finalsoldierRank;
    private int[] soldierScores = new int[4];
    private int soldierTotalScore;

    public Soldier(Integer ID, int initalSoldierRank) {
        this.ID = ID;
        this.initalSoldierRank = initalSoldierRank;
    }


    public void shootingTest( int j,int score) {
        this.soldierScores[j] = score;
        this.soldierTotalScore += score;
    }


    public int getInitalSoldierRank() {
        return initalSoldierRank;
    }

    public void setFinalsoldierRank(ShootingTest shootingTest, int finalsoldierRank) {
        this.finalsoldierRank = finalsoldierRank;
        if(finalsoldierRank == 1){
            shootingTest.increasecountCorporals();
        }
    }

    public int getSoldierScores(int j) {
        return this.soldierScores[j];
    }

    public int getSoldierTotalScore() {
        return soldierTotalScore;
    }

    public int getFinalsoldierRank() {
        return finalsoldierRank;
    }


}

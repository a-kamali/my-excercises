package ir.maktab.q01;

public class ShootingTest {
    private static int countOfShootingTest = 0;
    private int countCorporals = 0;


    public ShootingTest() {
        countOfShootingTest++;
    }



    public int getCountOfShootingTest() {
        return countOfShootingTest;
    }

    public void increasecountCorporals(){
        countCorporals++;
    }

    public int getCountCorporals() {
        return countCorporals;
    }

    public void setCountCorporals(int countCorporals) {
        this.countCorporals = countCorporals;
    }

    public static void setCountOfShootingTest(int countOfShootingTest) {
        ShootingTest.countOfShootingTest = countOfShootingTest;
    }
}


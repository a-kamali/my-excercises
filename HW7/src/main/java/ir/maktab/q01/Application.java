package ir.maktab.q01;


public class Application {
    public static void main(String[] args) {
        boolean flag = true;
        int rank;
        int score;
        SoldierArray soldierArray = new SoldierArray();

        for (int i = 0; i < 15; i++) {
            rank = (int) ((Math.random() * (3)) + 1);
            Soldier soldier = new Soldier(i,rank);
            soldierArray.addSoldiers(soldier);
        }


        while (flag) {
            ShootingTest shootingTest = new ShootingTest();
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 4; j++) {
                    score = (int) (Math.random() * (10));
                    soldierArray.getSoldier(i).shootingTest(j,score);
                }

                if ( soldierArray.getSoldier(i).getSoldierTotalScore() >= 28) {
                    if ( soldierArray.getSoldier(i).getInitalSoldierRank() < 3) {
                        soldierArray.getSoldier(i).setFinalsoldierRank(shootingTest,soldierArray.getSoldier(i).getInitalSoldierRank() + 1);
                    } else {
                        soldierArray.getSoldier(i).setFinalsoldierRank(shootingTest,soldierArray.getSoldier(i).getInitalSoldierRank());
                    }
                } else {
                    if (soldierArray.getSoldier(i).getInitalSoldierRank() > 1) {
                        soldierArray.getSoldier(i).setFinalsoldierRank(shootingTest,soldierArray.getSoldier(i).getInitalSoldierRank() - 1);
                    } else {
                        soldierArray.getSoldier(i).setFinalsoldierRank(shootingTest,soldierArray.getSoldier(i).getInitalSoldierRank());
                    }
                }
            }
            System.out.println("Shooting Test " + shootingTest.getCountOfShootingTest());
            System.out.println("====================");
            for (int i = 0; i < 15; i++) {
                int ID = i + 1;
                System.out.println("Soldier ID" + "[" + ID + "]");
                for (int j = 0; j < 4; j++) {
                    int numberBullet = j + 1;
                    System.out.print("Bullet " + numberBullet + ": [" + soldierArray.getSoldier(i).getSoldierScores(j) + "]\n");
                }
                System.out.println(
                        "Final Score: [" + soldierArray.getSoldier(i).getSoldierTotalScore() + "]\n" +
                                "Initial Rank: [" + soldierArray.getSoldier(i).getInitalSoldierRank() + "]\n" +
                                "Final Rank: [" + soldierArray.getSoldier(i).getFinalsoldierRank() + "]\n");
                System.out.println("**********************");
            }

            System.out.println("Shooting test [" + shootingTest.getCountOfShootingTest()
                    + "] result: [" + (int)((1.0 * shootingTest.getCountCorporals() / 15)*100)
                    + "]% of soldiers are Corporals");

            if ((1.0 * shootingTest.getCountCorporals() / 15) < 0.6) {
                flag = false;
            }
            System.out.println();
        }

    }
}

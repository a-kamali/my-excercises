package ir.maktab;

public class q01FuncinalProgramming {
    public static void main(String[] args) {
        int[] initalSoldierRank = new int[15];
        int[] finalsoldierRank = new int[15];
        int[][] soldierScore = new int[15][4];
        int[] soldierTotalScore = new int[15];
        int rank;
        int number = 1 ; // Count Shooting Test
        int countCorporals = 0;
        boolean flag = true;


        while (flag) {
            for (int i = 0; i < 15; i++) {
                rank = (int) ((Math.random() * (3)) + 1);
                initalSoldierRank[i] = rank;
            }

            for (int i = 0; i < 15; i++) {
                int totalscore = 0;
                for (int j = 0; j < 4; j++) {
                    rank = (int) (Math.random() * (10));
                    totalscore += rank;
                    soldierScore[i][j] = rank;
                }
                soldierTotalScore[i] = totalscore;
                if (totalscore >= 28) {
                    if (initalSoldierRank[i] < 3) {
                        finalsoldierRank[i] = initalSoldierRank[i] + 1;
                    } else {
                        finalsoldierRank[i] = initalSoldierRank[i];
                    }
                } else {
                    if (initalSoldierRank[i] > 1) {
                        finalsoldierRank[i] = initalSoldierRank[i] - 1;
                    } else {
                        finalsoldierRank[i] = initalSoldierRank[i];
                    }
                }
            }
            System.out.println("Shooting Test " + number + "\n" +
                    "====================");
            for (int i = 0; i < 15; i++) {
                int ID = i + 1;
                System.out.println("Soldier ID" + "[" + ID + "]\n");
                for (int j = 0; j < 4; j++) {
                    int numberBullet = j + 1;
                    System.out.print("Bullet " + numberBullet + ": [" + soldierScore[i][j] + "]\n");
                }
                System.out.println(
                        "Final Score: [" + soldierTotalScore[i] + "]\n" +
                                "Initial Rank: [" + initalSoldierRank[i] + "]\n" +
                                "Final Rank: [" + finalsoldierRank[i] + "]\n");
                System.out.println("**********************");
            }
            for (int i : finalsoldierRank) {
                if (i == 1)
                    countCorporals++;
            }
            System.out.println("Shooting test [" + number + "] result: [" + (int)((1.0 * countCorporals / 15)*100) + "]% of soldiers are Corporals");

            if ((1.0 * countCorporals / 15) < 0.6) {
                flag = false;
            }else {
                number++; // increase count of Shooting Test
                countCorporals = 0;
            }
        }

    }
}

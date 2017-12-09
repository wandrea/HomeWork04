package hu.helixlab;

import java.util.Random;

/**
 * Created by Andrea on 2017.12.09..
 */
public class ArrayTest {
    private int[] array = new int[20];
    private int[][] matrix = new int[5][5];


    //For-ral végigmentem az üres tömbön és a generált random számokkal feltöltöttem.
    public void initArray() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomNum = random.nextInt(31) - 10;
            array[i] = randomNum;
        }
    }

    public int getSecondHighest() {
        // végigmentem a tömbön for-ral, megkerestem a maxot és az elõzõ maxot a secondMax-ba raktam,
        //ha az aktuális elem kisebb mint a max, de nagyobb mint a secondMax, akkor a secondMax-ba került.
        int max = array[0];
        int secondMax = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                secondMax = max;
                max = array[i];
            }
            if (max > array[i] && secondMax < array[i]) {
                secondMax = array[i];
            }
        }
        return secondMax;
    }


    public void initMatrix() {
        Random random = new Random();
        //forban forral :) végigmentem a mátrix elemein és feltöltöttem random számokkal 0 v 1-gyel.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int randomNum = random.nextInt(2);
                matrix[i][j] = randomNum;
            }
        }
    }

    public void searchNotNullRows() {
        boolean hasNullRow = false;
        //forral végigmenetem a  sorokon, majd egy másikkal a cellákon, megvizsgáltam ha
        //a cella értéke 0-volt, akkor átváltotta a hasNull.Kilépve a belsõ forból, ha nem váltott a hasNull, akkor
        //nem talált 0-t a sorban, ezért kiírja az indexét.Egy másik boolean, a hasNullRow itt átvált, így kilépve a külsõ
        //forból ha ez nem váltott át, akkor egyszer sem kellett kiírni a sor indexet,
        // így akkor legalább egy sorban volt 0 értékû elem.
        for (int i = 0; i < matrix.length; i++) {
            boolean hasNull = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    hasNull = true;
                }


            }

            if (!hasNull) {
                System.out.println(i);
                hasNullRow = true;
            }
        }
        if (!hasNullRow) {
            System.out.println("Nem találtam olyan sort amiben nincs 0 értékû elem.");
        }


    }
}

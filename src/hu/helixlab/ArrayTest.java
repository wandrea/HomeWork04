package hu.helixlab;

import java.util.Random;

/**
 * Created by Andrea on 2017.12.09..
 */
public class ArrayTest {
    private int[] array = new int[20];
    private int[][] matrix = new int[5][5];


    //For-ral v�gigmentem az �res t�mb�n �s a gener�lt random sz�mokkal felt�lt�ttem.
    public void initArray() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomNum = random.nextInt(31) - 10;
            array[i] = randomNum;
        }
    }

    public int getSecondHighest() {
        // v�gigmentem a t�mb�n for-ral, megkerestem a maxot �s az el�z� maxot a secondMax-ba raktam,
        //ha az aktu�lis elem kisebb mint a max, de nagyobb mint a secondMax, akkor a secondMax-ba ker�lt.
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
        //forban forral :) v�gigmentem a m�trix elemein �s felt�lt�ttem random sz�mokkal 0 v 1-gyel.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int randomNum = random.nextInt(2);
                matrix[i][j] = randomNum;
            }
        }
    }

    public void searchNotNullRows() {
        boolean hasNullRow = false;
        //forral v�gigmenetem a  sorokon, majd egy m�sikkal a cell�kon, megvizsg�ltam ha
        //a cella �rt�ke 0-volt, akkor �tv�ltotta a hasNull.Kil�pve a bels� forb�l, ha nem v�ltott a hasNull, akkor
        //nem tal�lt 0-t a sorban, ez�rt ki�rja az index�t.Egy m�sik boolean, a hasNullRow itt �tv�lt, �gy kil�pve a k�ls�
        //forb�l ha ez nem v�ltott �t, akkor egyszer sem kellett ki�rni a sor indexet,
        // �gy akkor legal�bb egy sorban volt 0 �rt�k� elem.
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
            System.out.println("Nem tal�ltam olyan sort amiben nincs 0 �rt�k� elem.");
        }


    }
}

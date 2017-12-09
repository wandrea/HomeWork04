package hu.helixlab;

import java.util.Random;

/**
 * Created by Andrea on 2017.12.09..
 */
public class ArrayTest {
    private int[] array = new int[20];
//For-ral végigmentem az üres tömbön és a generált random számokkal feltöltöttem.
    public void initArray(){
        Random random = new Random();
        for (int i = 0; i <array.length; i++) {
            int randomNum = random.nextInt(31)-10;
            array[i]=randomNum;
        }
    }
    public int getSecondHighest(){
        // végigmentem a tömbön for-ral, megkerestem a maxot és az elõzõ maxot a secondMax-ba raktam,
        //ha az aktuális elem kisebb mint a max, de nagyobb mint a secondMax, akkor a secondMax-ba került.
        int max=array[0];
        int secondMax=array[0];
        for (int i = 0; i <array.length; i++) {
            if(max<array[i]){
                secondMax=max;
                max=array[i];
            }
            if (max>array[i] && secondMax<array[i]){
                secondMax=array[i];
            }
        }
        return secondMax;
    }
}

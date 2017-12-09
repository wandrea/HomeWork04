package hu.helixlab;

import java.util.Random;

/**
 * Created by Andrea on 2017.12.09..
 */
public class ArrayTest {
    private int[] array = new int[20];
//For-ral v�gigmentem az �res t�mb�n �s a gener�lt random sz�mokkal felt�lt�ttem.
    public void initArray(){
        Random random = new Random();
        for (int i = 0; i <array.length; i++) {
            int randomNum = random.nextInt(31)-10;
            array[i]=randomNum;
        }
    }
    public int getSecondHighest(){
        // v�gigmentem a t�mb�n for-ral, megkerestem a maxot �s az el�z� maxot a secondMax-ba raktam,
        //ha az aktu�lis elem kisebb mint a max, de nagyobb mint a secondMax, akkor a secondMax-ba ker�lt.
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

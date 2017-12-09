package hu.helixlab;

import java.util.Random;

/**
 * Created by Andrea on 2017.12.09..
 */
public class PasswordGenerator {
    //Random jelszó generálás a paraméterként kapott szám hosszának megfelelő számú karakterrel.
//átállítva static-ra, meghívható példányosítás nélkül is (user konstruktorban)
    public static String generatePassword(int length) {
        //lehetséges karakterek
        String character = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!%?";
        //kell egy üres string mert csak ahhoz tudja hozzáfűzni a karaktereket, különben beleírja hogy null.
        String password = "";
        Random random = new Random();
        //foron belül minden egyes karakter egy random szám generátorral választok ki a lehetséges karakterek közül,
        // majd hozzáfűzöm a password stringhez, mindezt annyiszor ahány hosszúra kértem a hívásnál a passwordot.
        for (int i = 0; i < length; i++) {
            int randomNum = random.nextInt(character.length());
            password += character.charAt(randomNum);
        }
        return password;
    }
}

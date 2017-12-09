package hu.helixlab;


import java.util.*;
import java.util.Scanner;
import java.util.Random;

/**
 * Created by Andrea on 2017.12.07..
 */
public class UserRegistry {
    User[] userArray;

    public void printMenu() {
        System.out.println("*********Menu*********");
        System.out.println("****Print menu (0)****");
        System.out.println("**Print all User (1)**");
        System.out.println("***Add new User (2)***");
        System.out.println("****Modify User (3)***");
        System.out.println("****Delete User (4)***");
        System.out.println("*******Exit (5)*******");
    }

    public UserRegistry() {
        userArray = new User[10];
        init();
    }


    public void run() {
        Scanner scan = new Scanner(System.in);
        int numberOfMenu = -1;

        while (numberOfMenu != 5) {
            System.out.println("Válassz egy menüpontot: ");
            numberOfMenu = scan.nextInt();
            switch (numberOfMenu) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    printAllUser();
                    break;
                case 2:
                    addNewUser();
                    break;
                case 3:
                    modifyUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    System.out.println("Exit....");
                    break;
                default:
                    printMenu();
            }
        }
    }


    public void printAllUser() {
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null) {
                System.out.print("id: " + userArray[i].getId());
                System.out.print(" \t,firstname: " + userArray[i].getFirstName());
                System.out.print(" \t,lastname: " + userArray[i].getLastName());
                System.out.print(" \t,password: " + userArray[i].getPassword());
                System.out.println(" \t,age: " + userArray[i].getAge());

            }

        }
    }

    public void addNewUser() {
        boolean hadPlace = false;
        int max = 0;
        System.out.println("Új felhasználó létrehozása!");
        for (int i = 0; i < userArray.length; i++) {
            User userToCheck = userArray[i];
            if (userToCheck != null && userToCheck.getId() > max) {
                max = userToCheck.getId();
            }
        }

        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] == null) {
                User newUser = new User();
                newUser.setId(max + 1);
                System.out.println(" firstname: ");
                newUser.setFirstName(scan.next());
                System.out.println(" lastname: ");
                newUser.setLastName(scan.next());
                System.out.println(" password: ");
                newUser.setPassword(scan.next());
                System.out.println(" age: ");
                newUser.setAge(scan.nextInt());
                userArray[i] = newUser;
                hadPlace = true;
                break;
            }

        }
        if (!hadPlace) {
            System.out.println("nincs hely a tömbben");
        }
    }

    public void init() {
        for (int i = 0; i < userArray.length - 1; i++) {
            User initUser = new User();
            initUser.setFirstName("Szabó" + Math.random() * 100);
            initUser.setLastName("Béla" + Math.random() * 100);
            initUser.setPassword("password" + Math.random() * 100);
            initUser.setAge((int) (Math.random() * 100));
            initUser.setId(i);
            userArray[i] = initUser;
        }

    }

    public void deleteUser() {
        //Bekértem az id-t, a tömb elemein végigmenve megnéztem hogy van-e ilyen id-vel rendelkezõ user
        //illetve hogy az adott index-en van e user adatokkal.
        //ha van user és egyezik az id akkor törli azt az indexût a tömbbõl.
        //boolean-nal vizsgáltam, hogy egyáltalán van e ilyen azonosítójú, ha nincs akkor kiírja.
        Scanner scan = new Scanner(System.in);
        System.out.println("Kérem adja meg a törölni kívánt felhasználó azonosítóját: ");
        int inputId = scan.nextInt();
        boolean wasMatch = false;
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null && userArray[i].getId() == inputId) {
                wasMatch = true;
                userArray[i] = null;
            }

        }
        if (!wasMatch) {
            System.out.println("Nincs ilyen azonosítójú felhasználó!");
        }
    }

    public void modifyUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Kérem adja meg a törölni kívánt felhasználó azonosítóját: ");
        int inputId = scan.nextInt();
        boolean wasMatch = false;
        //végigmegyek a tömbön és megnézem van egyezés a bekér id és a user-ek idja között és ellenõrzöm hogy van-e
        //objektum azon az indexen ahol éppen van.
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null && inputId == userArray[i].getId()) {
                wasMatch = true;
                break;
            }
        }

        if (wasMatch == false) {
            System.out.println("Nem találtam ilyen id-jû felhasználót!");
        } else {
            System.out.println("Kérem adja meg a vezeték nevét: ");
            String inputFirstName = scan.next();
            System.out.println("Kérem adja meg a kereszt nevét: ");
            String inputLastName = scan.next();
            //ismét végigmegyek a tömbön és az id egyezésnél beállítom a neveket és generálok egy új jelszót.
            for (int i = 0; i < userArray.length; i++) {
                if (userArray[i] != null && inputId == userArray[i].getId()) {
                    userArray[i].setFirstName(inputFirstName);
                    userArray[i].setLastName(inputLastName);
                    userArray[i].setPassword(PasswordGenerator.generatePassword(10));
                }
            }
        }

    }

    public int countUser() {
        int count = 0;
        //végigmegyek a tömbön és ha nem null az adott indexen akkor adjon hozzá egyet a count-hoz
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null) {
                ++count;
            }
        }
        return count;
    }


}





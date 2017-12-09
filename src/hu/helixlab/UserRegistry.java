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
            System.out.println("V�lassz egy men�pontot: ");
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
        System.out.println("�j felhaszn�l� l�trehoz�sa!");
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
            System.out.println("nincs hely a t�mbben");
        }
    }

    public void init() {
        for (int i = 0; i < userArray.length - 1; i++) {
            User initUser = new User();
            initUser.setFirstName("Szab�" + Math.random() * 100);
            initUser.setLastName("B�la" + Math.random() * 100);
            initUser.setPassword("password" + Math.random() * 100);
            initUser.setAge((int) (Math.random() * 100));
            initUser.setId(i);
            userArray[i] = initUser;
        }

    }

    public void deleteUser() {
        //Bek�rtem az id-t, a t�mb elemein v�gigmenve megn�ztem hogy van-e ilyen id-vel rendelkez� user
        //illetve hogy az adott index-en van e user adatokkal.
        //ha van user �s egyezik az id akkor t�rli azt az index�t a t�mbb�l.
        //boolean-nal vizsg�ltam, hogy egy�ltal�n van e ilyen azonos�t�j�, ha nincs akkor ki�rja.
        Scanner scan = new Scanner(System.in);
        System.out.println("K�rem adja meg a t�r�lni k�v�nt felhaszn�l� azonos�t�j�t: ");
        int inputId = scan.nextInt();
        boolean wasMatch = false;
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null && userArray[i].getId() == inputId) {
                wasMatch = true;
                userArray[i] = null;
            }

        }
        if (!wasMatch) {
            System.out.println("Nincs ilyen azonos�t�j� felhaszn�l�!");
        }
    }

    public void modifyUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("K�rem adja meg a t�r�lni k�v�nt felhaszn�l� azonos�t�j�t: ");
        int inputId = scan.nextInt();
        boolean wasMatch = false;
        //v�gigmegyek a t�mb�n �s megn�zem van egyez�s a bek�r id �s a user-ek idja k�z�tt �s ellen�rz�m hogy van-e
        //objektum azon az indexen ahol �ppen van.
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null && inputId == userArray[i].getId()) {
                wasMatch = true;
                break;
            }
        }

        if (wasMatch == false) {
            System.out.println("Nem tal�ltam ilyen id-j� felhaszn�l�t!");
        } else {
            System.out.println("K�rem adja meg a vezet�k nev�t: ");
            String inputFirstName = scan.next();
            System.out.println("K�rem adja meg a kereszt nev�t: ");
            String inputLastName = scan.next();
            //ism�t v�gigmegyek a t�mb�n �s az id egyez�sn�l be�ll�tom a neveket �s gener�lok egy �j jelsz�t.
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
        //v�gigmegyek a t�mb�n �s ha nem null az adott indexen akkor adjon hozz� egyet a count-hoz
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] != null) {
                ++count;
            }
        }
        return count;
    }


}





package hu.helixlab;


import java.util.*;
import java.util.Scanner;
import java.util.Random;

/**
 * Created by Andrea on 2017.12.07..
 */
public class UserRegistry {
    User[] userArray;

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

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Exit....");
                    break;
                default:
                    printMenu();
            }
        }
    }


    public void printMenu() {
        System.out.println("*********Menu*********");
        System.out.println("****Print menu (0)****");
        System.out.println("**Print all User (1)**");
        System.out.println("***Add new User (2)***");
        System.out.println("****Modify User (3)***");
        System.out.println("****Delete User (4)***");
        System.out.println("*******Exit (5)*******");
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
}





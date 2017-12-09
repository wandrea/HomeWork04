package hu.helixlab;

public class Main {

    public static void main(String[] args) {
	UserRegistry ur = new UserRegistry();
        ur.printMenu();
        ur.run();
        System.out.println(ur.countUser());
    }
}

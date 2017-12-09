package hu.helixlab;

/**
 * Created by Andrea on 2017.12.07..
 */
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(int id, String firstName, String lastName,String password, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.age = age;
    }
    public User (User user){
        this.id=user.getId();
        this.firstName= user.getFirstName();
        this.lastName = user.getLastName();
        this.password = user.getPassword();
        this.age = user.getAge();
    }
}

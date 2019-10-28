package JaLaba3;
import java.util.Scanner;

public class User {
    private String name;
    private String login;
    private String password;
    private int price;
    private boolean cheak = false;
    private Scanner in = new Scanner(System.in);
    public User(){
        name = "judge";
        login = "admin";
        password = "1111";
    }

    public User(String n,String l,String p){
        name = n;
        login = l;
        password = p;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean cheak() {
        return cheak;
    }

    public void setCheak(boolean cheak){
        this.cheak = cheak;
    }

}

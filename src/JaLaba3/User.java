package JaLaba3;
import java.util.Scanner;

public class User {
    private String name;
    private String login;
    private String password;
    private int point;
    private Scanner in = new Scanner(System.in);
    public User(){
        name = "judge";
        login = "admin";
        password = "1111";
        point = -1000;
    }

    public User(String n,String l,String p){
        name = n;
        login = l;
        password = p;
        point = 0;
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

    public void setPoint(int point) {
        this.point = point;
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

    public int getPoint() {
        return point;
    }
}

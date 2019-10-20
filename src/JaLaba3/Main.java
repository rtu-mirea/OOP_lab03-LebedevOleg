package JaLaba3;


import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    static ArrayList<User> users = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean OK = true;
        int n;
        User admin = new User();
        users.add(admin);
        while (OK){
            System.out.println("1.Войти\n2.Зарегистрироваться\n3.Закрыть программу");
            n = in.nextInt();
            switch (n){
                case 1:
                    enter();
                    break;
                case 2:
                    regist();
                    for(User i : users)
                        System.out.println(i.getLogin() + " " + i.getPassword());
                    break;
                case 3:
                    OK = false;
                    System.out.println("Спасибо за использование программы");
                    break;
            }
        }
    }
    static void enter(){
        boolean n=false;
        int k;
        String log, pass;
        while (n == false) {
            System.out.print("Login:");
            log = in.next();
            pass = in.next();
            for (User i : users) {
                if (log.compareTo(users.get(0).getLogin()) == 0 && pass.compareTo(users.get(0).getPassword()) == 0) {
                    System.out.println("admin");
                    n = true;
                    break;
                }
                else if (i.getLogin().compareTo(log) ==  0 && i.getPassword().compareTo(pass) == 0) {
                    UserSystem userSystem = new UserSystem();
                    userSystem.main(users,i);
                    n = true;
                    break;
                }
            }
            if (n == false) {
                k =0;
                while (k > 2 || k < 1) {
                    System.out.println("Логин или пароль введен неверно. \n 1.Повторить ввод\n2.вернуться к начальному меню");
                    k = in.nextInt();
                    switch (k) {
                        case 1:
                            break;
                        case 2:
                            n = true;
                            break;
                    }
                }
            }
        }
    }
    static void regist(){
        String log="", pass = "",name = "";
        boolean n = true;
        System.out.println("Введите имя, логин и пароль для регистрации");
        while (n) {
            System.out.print("Name:");
            name = in.next();
            System.out.print("Login:");
            log = in.next();
            System.out.print("Password");
            pass = in.next();
            for (User i : users) {
                if (i.getLogin().compareTo(log) == 0) {
                    System.out.println("Введенный логин существует, пожалуйчта измените его");
                    n = true;
                    break;
                }
                n =false;
            }
        }
        User user = new User(name,log,pass);
        users.add(user);
    }

}

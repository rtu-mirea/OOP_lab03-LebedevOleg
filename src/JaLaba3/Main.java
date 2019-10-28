package JaLaba3;


import java.util.Scanner;
import java.util.ArrayList;

import static JaLaba3.Admin.*;


public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean OK = true;
        int n;
        ArrayList<User> users = Admin.getUsers();
        User admin = new User();
        users.add(admin);
        while (OK){
            System.out.println("1.Войти\n2.Зарегистрироваться\n3.Закрыть программу");
            try {
                n = Integer.parseInt(in.next());
                switch (n) {
                    case 1:
                        enter(users);
                        break;
                    case 2:
                        regist(users);
                        for (User i : users)
                            System.out.println(i.getLogin() + " " + i.getPassword());
                        break;
                    case 3:
                        OK = false;
                        System.out.println("Спасибо за использование программы");
                        break;
                }
            }
            catch (Exception e){}
        }
    }
    static void enter( ArrayList<User> users){
        boolean n=false;
        int k;
        String log, pass;
        while (n == false) {
            System.out.print("Login:");
            log = in.next();
            System.out.print("Password:");
            pass = in.next();
            if (log.compareTo("admin") == 0 && pass.compareTo("1111") == 0) {
                Admin admin = new Admin();
                admin.main();
                n = true;
                break;
            }
            for (User i : users) {
                 if (i.getLogin().compareTo(log) ==  0 && i.getPassword().compareTo(pass) == 0) {
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
    static void regist( ArrayList<User> users){
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
        Admin.setUsers(users);
    }
}

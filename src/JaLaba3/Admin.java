package JaLaba3;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private static Scanner in = new Scanner(System.in);
    private static int budjet;
    private static int min_summ;
    static ArrayList<User> players = new ArrayList<>();
    public void main(ArrayList<User> users){
        boolean OK = true;
        int n;
        users.sort(new Comparator<User>() {////////////фикс
            @Override
            public int compare(User o1, User o2) {
                if(o1.getPoint()<o2.getPoint())
                    return 1;
                else if(o1.getPoint()>o2.getPoint())
                    return -1;
                else
                    return 0;
            }
        });
        while(OK){
            System.out.println("1.Запустить конкурс\n2.Ввести бюджет конкурса\n3.Посмотреть участников\n4.выйти");
            n = in.nextInt();
            switch (n){
                case 1:
                    task(users);
                    break;
                case 2:
                    System.out.print("Введите бюджет конкурса: ");
                    budjet = in.nextInt();
                    System.out.print("Введите минималньую сумму которую могут получить участники: ");
                    min_summ = in.nextInt();
                    break;
                case 3:
                    for (User i: users){
                        System.out.println("Имя:" + i.getLogin() + " Баллы:"+ i.getPoint());
                    }
                    break;
                case 4:
                    OK = false;
                    break;
            }

        }
    }
    void task(ArrayList<User> users){
        if (budjet > 0) {
            for (int i = 0; i < users.size() - 1; i++) {
                players.add(users.get(i));
            }
            int i = 0, k = 9;
            while (i <= 2 && i < players.size()) {
                switch (i) {
                    case 1:
                        players.get(i).setPrice(budjet / 100 * 60);
                        break;
                    case 2:
                        players.get(i).setPrice(budjet / 100 * 15);
                        break;
                    case 3:
                        players.get(i).setPrice(budjet / 100 * 10);
                        break;
                }
                i++;
            }
            budjet = budjet / 100 * 15;
            while (i < players.size() && k > 0) {
                players.get(i).setPrice(budjet / 100 * k);
                i++;
                k--;
            }
            System.out.println("\t ***ПОЗДРАВЛЯЕМ ПОБЕДИТЕЛЕЙ!***");
            for (int x = 0; x < players.size(); x++) {
                if (players.get(x).getPrice() >= min_summ)
                    System.out.println(x + ".Логин " + players.get(x).getLogin() + " Приз: " + players.get(x).getPrice());
            }
        }
        else
            System.out.println("Вы не ввели бюджет, боюсь без бюджета все плохо:(");
    }
}

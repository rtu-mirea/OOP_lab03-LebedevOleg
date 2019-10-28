package JaLaba3;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private static Scanner in = new Scanner(System.in);
    private static int budjet;
    private int min_summ;
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Project> project = new ArrayList<>();
    public void main(){
        boolean OK = true;
        int n;
        project.sort(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                if (o1.getPoint() < o2.getPoint())
                    return 1;
                else if (o1.getPoint() > o2.getPoint())
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
                    for (Project i: project){
                        System.out.println("Имя:" + i.getUser().getLogin() + " Баллы:"+ i.getPoint() + " Название проекта:" + i.getName());
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
            int i = 0, k = 9;
            while (i <= 2 && i < project.size()) {
                switch (i) {
                    case 0:
                        project.get(i).getUser().setPrice(budjet / 100 * 60);
                        break;
                    case 1:
                        project.get(i).getUser().setPrice(budjet / 100 * 15);
                        break;
                    case 2:
                        project.get(i).getUser().setPrice(budjet / 100 * 10);
                        break;
                }
                i++;
            }
            budjet = budjet / 100 * 15;
            while (i < project.size() && k > 0) {
                project.get(i).getUser().setPrice(budjet / 100 * k);
                i++;
                k--;
            }
            System.out.println("\t ***ПОЗДРАВЛЯЕМ ПОБЕДИТЕЛЕЙ!***");
            for (int x = 0; x < project.size(); x++) {
                if (project.get(x).getUser().getPrice() >= min_summ)
                    System.out.println(x + ".Логин " + project.get(x).getUser().getLogin() +" Название проекта:"+ project.get(x).getName() + " Приз: " + project.get(x).getUser().getPrice());
            }
        }
        else
            System.out.println("Вы не ввели бюджет, боюсь без бюджета все плохо:(");
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        Admin.users = users;
    }

    public static ArrayList<Project> getProject() {
        return project;
    }

    public static void setProject(ArrayList<Project> project) {
        Admin.project = project;
    }
}

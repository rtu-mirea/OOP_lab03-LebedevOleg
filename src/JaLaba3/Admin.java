package JaLaba3;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private static Scanner in = new Scanner(System.in);
    static ArrayList<User> players = new ArrayList<>();
    public void main(ArrayList<User> users){
        boolean OK = true;
        int n;
        while(OK){
            System.out.println("1.Запустить конкурс(БЕЗ БЮДЖЕТА НЕ ЗАПУСКАТЬ)\n2.Ввести бюджет конкурса\n3.Посмотреть участников\nвыйти");
            n = in.nextInt();
            switch (n){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    OK = false;
                    break;
            }

        }
    }
}

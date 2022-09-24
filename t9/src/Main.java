import java.util.Scanner;
import java.util.function.Consumer;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Short_distance r1 = new Short_distance();
        Long_distance r2 = new Long_distance();
        Long_jump j1 = new Long_jump();
        High_jump j2 = new High_jump();

        Consumer<String> pr = System.out::print;
        Consumer<String> pr1 = System.out::println;
        int n;
        pr.accept("Сколько мест в сборной?");
        n = sc.nextInt();
        Main[] a = new Main[n];
        Form[] arr = {r1, r2, j1, j2};

        var athlete = new Athlete("Татарстан");
        for (int i = 0; i < n; i++) {
            a[i] = new Main();
            athlete = Athlete.register();

            pr1.accept("Виды ");
            for (int j = 0; j < arr.length; j++) {
                pr1.accept((j + 1) + ". " + arr[j].getName());
            }
            pr.accept("Какой у вас вид?");
            int m = sc.nextInt();
            athlete.Vid(arr[m - 1]);
            pr1.accept(i + 1 + ") ");
            athlete.output();
        }
    }
}




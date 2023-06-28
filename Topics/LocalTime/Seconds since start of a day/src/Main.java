import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int second = scanner.nextInt();
        LocalTime localTime = LocalTime.ofSecondOfDay(second);
        System.out.println(localTime);
    }
}
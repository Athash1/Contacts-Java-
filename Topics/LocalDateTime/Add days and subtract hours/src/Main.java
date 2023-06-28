import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDateTime localDateTime = LocalDateTime.parse(scanner.next());
        int day = scanner.nextInt();
        int hours = scanner.nextInt();
        System.out.println(localDateTime.plusDays(day).minusHours(hours));
    }
}
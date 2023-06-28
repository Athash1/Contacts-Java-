import java.util.EnumSet;
import java.util.Scanner;

public class Main {

    enum Alphabets {
        A, B, E, O, T, U, L, I
    }

    EnumSet<Alphabets> enumSet;

        public static void main(String[] args) {
        Main object = new Main();

        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine().trim();

        // Change Code below this line
        switch (string) {
            case "setOfVowels":
                object.enumSet = EnumSet.of(Alphabets.A,Alphabets.E,Alphabets.O,Alphabets.U,Alphabets.I);
                break;
            case "setOfConsonants":
                object.enumSet = EnumSet.of(Alphabets.B,Alphabets.T,Alphabets.L);
                break;
            case "containsAOnly":
                object.enumSet = EnumSet.of(Alphabets.A);
                break;
            case "empty":
                object.enumSet = EnumSet.noneOf(Alphabets.class);
                break;
            case "exceptT-A-E":
                object.enumSet = EnumSet.of(Alphabets.B,Alphabets.O,Alphabets.U,Alphabets.L,Alphabets.I);
                break;
            default : System.out.println("ERROR");
                break;
       }
        System.out.println(object.enumSet);
        // Change the code above this line
    }
}
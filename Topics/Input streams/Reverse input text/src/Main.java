import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String string = reader.readLine();
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.reverse();
        System.out.println(stringBuilder);
        reader.close();
    }
}
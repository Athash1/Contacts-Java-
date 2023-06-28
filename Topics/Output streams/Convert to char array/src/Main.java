import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        // implement the method
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        ArrayList<Character> charList = new ArrayList<>();
        for (String str :
                words) {
            charArrayWriter.write(str);
            for (char c:
                 str.toCharArray()) {
                charList.add(c);
            }
        }
        char[] chars = new char[charList.size()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = charList.get(i);
        }
        return chars;
    }
}


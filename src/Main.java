import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static int CountDirections() throws IOException {
        File input = new File("input.txt");
        Scanner scnr = new Scanner(input);
        String line;
        int linia = 0;
        int count = 0;
        int number = 0;
        String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine","1","2","3","4","5","6","7","8","9"};
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (scnr.hasNextLine()) {
            String inp = scnr.nextLine();
            number=0;
            for(String word : words) {
                number++;
                for (Matcher m = Pattern.compile(word, Pattern.CASE_INSENSITIVE).matcher(inp); m.find(); )
                    if(number<10) {
                        map.put(m.start(),number);
                    }
                    else{
                        map.put(m.start(),Integer.parseInt(m.group()));
                    }
            }

            int b = map.get(Collections.max(map.keySet()));
            int a = map.get(Collections.min(map.keySet()));
            System.out.println(a*10+b);
            count = count + (10 * Integer.parseInt(String.valueOf(a)) + Integer.parseInt(String.valueOf(b)));
            System.out.println(linia);
            map.clear();
        }
        return count;
    }


    public static void main(String[] args) throws IOException {

        int count = 0;
        count = CountDirections();
        System.out.println(count);
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String args []) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        String length = reader.readLine();
        System.out.println("Total inputs "+length);
        for(int i=0; i<length.length();i++) {
            String str = reader.readLine();
            list.add(str);
        }

        RomanNumerals romanNumerals = new RomanNumerals();
        for(String str: list) {
            int value = romanNumerals.convertToValue(str);
            if(value>0) {
                System.out.println(str+" value is "+value);
            } else {
                System.out.println("I have no idea what you are talking about");
            }

        }


    }
}

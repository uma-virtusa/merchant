import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RomanNumerals {

    private int getValue(char letter) {

        switch (letter) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }

        return 0;
    }

    /**
    *find the duplicate characters and return list of duplicates
    **/
    private List<Character> findDuplicates(List<Character> list) {

        Set<Character> uniques = new HashSet<>();
        List<Character> duplicateCharList =
                list.stream()
                        .filter(e -> !uniques.add(e))
                        .distinct()
                        .collect(Collectors.toList());
        return duplicateCharList;
    }


    public boolean validateCharacterFrequency(List<Character> list, String string) {

        Map<Character, Integer> charFrequencyMap = findFrequency(list);
        List<Character> duplicateCharList = findDuplicates(list);

        for(Character charc: duplicateCharList) {
            switch(charc) {
                case 'D':
                    return false;
                case 'L':
                    return false;
                case 'V':
                    return false;
            }

            String charFreq = CharFrequency.getCharFrequency(charc);
            if(!(null == charFreq) && string.contains(charFreq)){
                return false;
            }

        }

        return true;
    }

    private Map<Character, Integer> findFrequency(List<Character> string) {

        Map<Character,Integer> charFrequencyMap = new HashMap<>();
        for (int i = 0; i < string.size(); i++) {
            char c = string.get(i);
            if (charFrequencyMap.containsKey(c)) {
                int cnt = charFrequencyMap.get(c);
                charFrequencyMap.put(c, ++cnt);
            } else {
                charFrequencyMap.put(c, 1);
            }
        }
        return charFrequencyMap;
    }

    public int convertToValue(String str)
    {
        List<Character> list = str.chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());
        boolean isValid = validateCharacterFrequency(list, str);

        if(!isValid) {
            return 0;
        }
        // Initialize result
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            // Getting value of symbol s[i]
            int s1 = getValue(str.charAt(i));

            // Getting value of symbol s[i+1]
            if (i + 1 < str.length()) {
                int s2 = getValue(str.charAt(i + 1));

                // Comparing both values
                if (s1 >= s2) {
                    // Value of current symbol
                    // is greater or equalto
                    // the next symbol
                    result = result + s1;
                }
                else {
                    // Value of current symbol is
                    // less than the next symbol
                    result = result + s2 - s1;
                    i++;
                }
            }
            else {
                result = result + s1;
                i++;
            }
        }

        return result;
    }

}

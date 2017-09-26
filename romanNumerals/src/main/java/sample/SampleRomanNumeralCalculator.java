package sample;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SampleRomanNumeralCalculator {

    private static Map<String, Integer> translation;

    static {
        translation = Collections.unmodifiableMap(new HashMap<String, Integer>() {
            {
                put("I", 1);
            }
        });
    }

    public String add(String numeralOne, String numeralTwo) {
        int oneCount = count(numeralOne, numeralTwo, "I");
        if(oneCount == 4) return "IV";
        if(oneCount == 5) return "V";
        return numeralOne + numeralTwo;
    }

    private int count(String numeralOne, String numeralTwo, String target) {
        int total = 0;
        for (char character : (numeralOne + numeralTwo).toCharArray()) {
            String letter = String.valueOf(character);
            if(letter.equals(target)){
                total++;
            }
        }
        return total;
    }
}

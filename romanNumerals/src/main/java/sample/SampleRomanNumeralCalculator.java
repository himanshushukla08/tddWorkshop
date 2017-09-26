package sample;

import java.util.*;

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
        Counter counterOne = count(numeralOne);
        Counter counterTwo = count(numeralTwo);

        int total = counterOne.value() + counterTwo.value();

        return new RomanNumerals().convert(total);
    }

    private Counter count(String numeralOne) {
        Counter counter = new Counter();

        for (Character character : reverse(numeralOne)) {
            String letter = String.valueOf(character);
            if(letter.equals("I")){
                counter.countOne();
            }
            if(letter.equals("V")){
                counter.countFive();
            }
            if(letter.equals("X")){
                counter.countTen();
            }
        }
        return counter;
    }

    private List<Character> reverse(String numeral) {
        List<Character> characters = new ArrayList<>();

        for(char character :numeral.toCharArray()){
            characters.add(character);
        }

        Collections.reverse(characters);

        return characters;
    }

    private class Counter {
        private int subtractingOnes = 0;
        private int addingOnes = 0;
        private int fives = 0;
        private int tens = 0;
        private boolean subtractOne = false;

        private void countOne(){
            if(subtractOne){
                subtractingOnes++;
            }else{
                addingOnes++;
            }
            subtractOne = false;
        }

        private void countFive(){
            fives++;
            subtractOne = true;
        }

        private void countTen(){
            tens++;
            subtractOne = true;
        }

        private int value(){
            return (tens * 10) + (fives * 5) + addingOnes - subtractingOnes;
        }
    }
}

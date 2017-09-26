package sample;

public class SampleFizzBuzz {
    public static String convert(int number) {
        String output = "";

        if(isDivisible(number, 3)) output += "Fizz";
        if(isDivisible(number, 5)) output += "Buzz";
        if(output.isEmpty()) output += Integer.toString(number);

        return output;
    }

    private static boolean isDivisible(int number, int by) {
        return number % by == 0;
    }
}

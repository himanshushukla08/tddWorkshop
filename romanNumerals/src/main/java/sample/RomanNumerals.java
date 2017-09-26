package sample;

import sample.Conversion;

import java.util.Arrays;
import java.util.List;

public class RomanNumerals {

    private List<Conversion> conversions;

    public RomanNumerals() {
        conversions = Arrays.asList(
                new Conversion(1000, "M"),
                new Conversion(900, "CM", 100),
                new Conversion(500, "D", 100),
                new Conversion(400, "CD", 100),
                new Conversion(100, "C"),
                new Conversion(90, "XC", 10),
                new Conversion(50, "L", 10),
                new Conversion(40, "XL", 10),
                new Conversion(10, "X"),
                new Conversion(9, "IX", 1),
                new Conversion(5, "V", 1),
                new Conversion(4, "IV", 1),
                new Conversion(1, "I"));
    }

    public String convert(int number) {
        Builder romanNumeral = new Builder(number, "");
        for (Conversion conversion : conversions) {
            append(romanNumeral, conversion);
        }

        return romanNumeral.toString();
    }


    private void append(Builder builder, Conversion conversion) {
        while (builder.count(conversion.getRange()) >= (conversion.getNumber() / conversion.getRange())) {
            builder.append(conversion.getRomanNumeral());
            builder.subtract(conversion.getNumber());
        }
    }
}

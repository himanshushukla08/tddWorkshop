package sample;

public class Conversion {

    private int number;
    private String romanNumeral;
    private int range;

    public Conversion(int number, String romanNumeral) {
        this.number = number;
        this.romanNumeral = romanNumeral;
        this.range = number;
    }

    public Conversion(int number, String romanNumeral, int range) {
        this.number = number;
        this.romanNumeral = romanNumeral;
        this.range = range;
    }

    public int getNumber() {
        return number;
    }

    public String getRomanNumeral() {
        return romanNumeral;
    }

    public int getRange() {
        return range;
    }
}

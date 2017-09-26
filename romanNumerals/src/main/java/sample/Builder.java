package sample;

public class Builder {
    private int number;
    private String romanNumeral;

    public Builder(int number, String romanNumeral) {
        this.number = number;
        this.romanNumeral = romanNumeral;
    }

    public void subtract(int value) {
        number = number - value;
    }

    public void append(String part) {
        romanNumeral += part;
    }

    public int count(int amount) {
        return number / amount % 10;
    }

    @Override
    public String toString() {
        return romanNumeral;
    }
}

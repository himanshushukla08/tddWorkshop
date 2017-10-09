package sample.stub;

import sample.FutureDateProvider;

public class FutureDateProviderStub implements FutureDateProvider {

    private int month;
    private int day;
    private int year;

    public FutureDateProviderStub(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    @Override
    public int getFutureMonth() {
        return month;
    }

    @Override
    public int getFutureDay() {
        return day;
    }

    @Override
    public int getFutureYear() {
        return year;
    }
}

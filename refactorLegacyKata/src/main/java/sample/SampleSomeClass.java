package sample;

public class SampleSomeClass {

    String myRandomFlag = "";
    private RandomWrapper random;

    public SampleSomeClass(RandomWrapper random) {
        this.random = random;
    }

    public String someMethod() {

        if ((this.thingOne() || (!this.thingOne() && this.thingTwo())) && this.thingThree()) {
            myRandomFlag = "Bacon";
        } else {
            myRandomFlag = "Tofu";
        }

        return myRandomFlag;
    }

    public boolean thingOne() {
        return random.nextBoolean();
    }

    public boolean thingTwo() {
        return random.nextBoolean();
    }

    public boolean thingThree() {
        return random.nextBoolean();
    }

}

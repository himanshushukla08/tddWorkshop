package sample;

public class SampleSomeClass {

    String myRandomFlag = "";
    private RandomWrapper random;

    public SampleSomeClass(RandomWrapper random) {
        this.random = random;
    }

    public String someMethod() {

        if ((random.nextBoolean() || (!random.nextBoolean() && random.nextBoolean())) && random.nextBoolean()) {
            myRandomFlag = "Bacon";
        } else {
            myRandomFlag = "Tofu";
        }

        return myRandomFlag;
    }
}

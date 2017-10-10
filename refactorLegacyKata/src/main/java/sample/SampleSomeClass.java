package sample;

public class SampleSomeClass {

    private RandomWrapper random;

    public SampleSomeClass(RandomWrapper random) {
        this.random = random;
    }

    public String someMethod() {

        if ((random.nextBoolean() || (!random.nextBoolean() && random.nextBoolean())) && random.nextBoolean()) {
            return "Bacon";
        } else {
            return "Tofu";
        }
    }
}

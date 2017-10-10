package sample.stub;

import sample.RandomWrapper;

import java.util.Iterator;

public class RandomWrapperStub implements RandomWrapper {

    private Iterator<Boolean> answers;

    public RandomWrapperStub(Iterator<Boolean> answers) {
        this.answers = answers;
    }

    @Override
    public boolean nextBoolean() {
        return answers.next();
    }
}

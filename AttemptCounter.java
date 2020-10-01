package lesson4;

import org.w3c.dom.ls.LSOutput;

public class AttemptCounter {
    private static AttemptCounter instance;
    private int count;
    private AttemptCounter() {count = 0;};

    public static AttemptCounter getInstance() {
        if (instance == null) {
            instance = new AttemptCounter();
        }
        return instance;
    }
    void count() throws TooManyLoginAttemptsException{
        if (count == 5) {
            throw new TooManyLoginAttemptsException("Совершено слишком много попыток входа");
        }
        count+=1;
    }
    void refresh(){
        count = 0;
    }
    String status() {
        if (5-count == 0) return "Попыток больше нет.";
        return "Ещё "+Integer.toString(5-count)+" попытки.";
    }

}

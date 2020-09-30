package lesson4;

public class AttemptCounter {
    private static AttemptCounter instance;
    private int count;
    private AttemptCounter() {int count = 0;};

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
}
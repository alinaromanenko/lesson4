package lesson4;


import java.io.IOException;
import java.util.Map;


public class AccountManagerImpl implements MailAccountManager{
    private CSVparser csv;
    AccountManagerImpl(){
         this.csv= new CSVparser("base.csv");
    }
    @Override
    public void registerNewAccount(String email, String password, Person person) throws IOException {
        try {
            if (csv.reader().containsKey(email)) throw new DuplicateAccountException("Ошибка!Данный аккаунт присутсвует в базе");
            csv.writer(email, password, person);
        }
        catch (DuplicateAccountException error){
            error.printStackTrace();
        }
    }

    @Override
    public void removeAccount(String email, String password) throws IOException {
        if (csv.reader().containsKey(email) & csv.reader().get(email)[0].equals(password)){
            Map<String, String[]> newCsv = csv.reader();
            newCsv.remove(email);
            csv.rewriter(newCsv);
        }
    }

    @Override
    public boolean hasAccount(String email) throws IOException {
        return csv.reader().containsKey(email);
    }

    @Override
    public Person getPerson(String email, String password) throws TooManyLoginAttemptsException, IOException {
        AttemptCounter counter = AttemptCounter.getInstance();
        try {
            if (!csv.reader().containsKey(email) || !csv.reader().get(email)[0].equals(password)) {
                counter.count();
                throw new WrongCredentialsException("Ошибка! Неверный логин или пароль."+counter.status());
            }
        }
        catch (WrongCredentialsException error){
            error.printStackTrace();
            return null;
        }
        counter.refresh();
        return new Person(csv.reader().get(email)[1], csv.reader().get(email)[2]);
    }

    @Override
    public int numOfAccounts() throws IOException {
        return csv.reader().size();
    }
}

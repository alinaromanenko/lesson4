package lesson4;

import javenue.csv.Csv;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.DuplicateFormatFlagsException;


public class AccountManagerImpl implements MailAccountManager{
    private CSVparser csv;
    AccountManagerImpl(){
         this.csv= new CSVparser("base.csv");
    }
    @Override
    public void registerNewAccount(String email, String password, Person person) throws DuplicateAccountException, IOException {
        System.out.println(csv.reader().get(email)[0]);
        if (csv.reader().containsKey(email)) throw new DuplicateAccountException("Ошибка!Данный аккаунт присутсвует в базе");
        csv.writer(email, password, person);
    }

    @Override
    public void removeAccount(String email, String password) throws IOException {
        if (csv.reader().containsKey(email) & csv.reader().get(email)[0].equals(password)) csv.reader().remove(email);//rewriter()


    }

    @Override
    public boolean hasAccount(String email) throws IOException {
        return csv.reader().containsKey(email);
    }

    @Override
    public Person getPerson(String email, String password) throws TooManyLoginAttemptsException {
        return null;
    }

    @Override
    public int numOfAccounts() {
        return 0;
    }
}

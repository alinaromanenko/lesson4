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
         this.csv= new CSVparser("base.txt");
         //"/Users/Programming.LAPTOP-SIV4CDTS/IdeaProjects/NSU/src/lesson4/base.csv"
    }
    @Override
    public void registerNewAccount(String email, String password, Person person) throws DuplicateAccountException, IOException {
        //if (csv.reader().containsKey(email)) throw new DuplicateAccountException("Данный аккаунт присутсвует в базе");
        csv.writer(email, password, person);
    }

    @Override
    public void removeAccount(String email, String password) {

    }

    @Override
    public boolean hasAccount(String email) {
        return false;
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

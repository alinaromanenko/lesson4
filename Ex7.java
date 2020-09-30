package lesson4;

import java.io.IOException;

public class Ex7 {
    public static void main(String[] args) throws IOException, DuplicateAccountException {
        Person alina = new Person("Alina", "27.05.2000");
        Person rick = new Person("Rick", "07.11.2003");
        AccountManagerImpl AMI = new AccountManagerImpl();

        AMI.registerNewAccount("ali@yandex.ru", "12345", alina);
        AMI.registerNewAccount("rick@yandex.ru", "12345", rick);

        //AMI.removeAccount("ali@yandex.ru", "12345");

        System.out.println(AMI.hasAccount("ali@yandex.ru"));

        System.out.println(AMI.numOfAccounts());

        try {
            System.out.println(AMI.getPerson("rick@yandex.ru", "12345").getName()+" "+AMI.getPerson("rick@yandex.ru", "12345").getBirthday());
            AMI.getPerson("ric@yandex.ru", "12345");
        }
        catch (WrongCredentialsException|TooManyLoginAttemptsException error){
            error.printStackTrace();
        }

    }
}

package lesson4;

import java.io.IOException;

public class Ex7 {
    public static void main(String[] args) {
        Person alina = new Person("Alina", "27.05.2000");
        Person rick = new Person("Rick", "07.11.2003");
        AccountManagerImpl AMI = new AccountManagerImpl();
        try{
        AMI.registerNewAccount("ali@yandex.ru", "12345", alina);
        AMI.registerNewAccount("rick@yandex.ru", "12345", rick);
        }
        catch (DuplicateAccountException|IOException error){
            error.printStackTrace();
        }
    }
}

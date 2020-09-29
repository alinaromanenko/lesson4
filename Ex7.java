package lesson4;

import java.io.IOException;

public class Ex7 {
    public static void main(String[] args) {
        Person alina = new Person("Alina", "27.05.2000");
        AccountManagerImpl AMI = new AccountManagerImpl();
        try{
        AMI.registerNewAccount("ali@yandex.ru", "12345", alina);
        }
        catch (DuplicateAccountException|IOException error){
            error.printStackTrace();
        }


    }
}

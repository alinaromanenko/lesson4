package lesson4;

public class WrongCredentialsException extends Exception {
    WrongCredentialsException(String message){
        System.out.println(message);
    }
}


package lesson4;


class TooManyLoginAttemptsException  extends Exception {
    TooManyLoginAttemptsException(String message){
        System.out.println(message);
    }
}
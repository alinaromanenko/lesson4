package lesson4;

class DuplicateAccountException extends Exception {
        DuplicateAccountException(String message){
            System.out.println(message);
        }
}

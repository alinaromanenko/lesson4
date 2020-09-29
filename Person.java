package lesson4;

public class Person {
    private String name;
    private String  birthday;

    Person (String name, String birthday){
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }
}

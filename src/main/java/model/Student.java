package model;

public class Student {
    private String surname;

    private String name;

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public Student(String vSurname, String vName) {
        this.surname = vSurname;
        this.name = vName;
    }
}

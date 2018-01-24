package exercises.lesson4;

import java.util.Calendar;

public class Student {

    public enum Gender {
        MALE, FEMALE;
    }

    private String firstName;
    private String lastName;
    private int birthYear;
    private Gender gender;

    public Student(String firstName, String lastName, int birthYear, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - (birthYear + 1);
    }
}

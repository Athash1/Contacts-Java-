package contacts;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.LocalDateTime;


class Person extends Contact implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String surname;
    private String  birthday;
    private String gender;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String  getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        try {
            LocalDate.parse(birthday);
            this.birthday = birthday;
        } catch (DateTimeParseException e) {
            System.out.println("Bad birth date!");
            this.birthday = "[no data]";
        }
    }

    public void setGender(String gender) {
        if (gender.equals("M") || gender.equals("F")) {
            this.gender = gender;
        } else {
            System.out.println("Bad gender!");
            this.gender = "[no data]";
        }
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return ("Name: " + getName() + "\n" +
                "Surname: " + getSurname() + "\n" +
                "Birth date: " + getBirthday() + "\n" +
                "Gender: " + getGender() + "\n" +
                "Number: " + getNumber() + "\n" +
                "Time created: " + getCreatedTime() + "\n" +
                "Time last edit: " + getLastModifiedTime() + "\n");
    }

}
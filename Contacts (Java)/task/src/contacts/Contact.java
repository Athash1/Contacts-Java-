package contacts;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class Contact implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;

    private String number = "[no number]";
    private LocalDateTime createdTime;
    private LocalDateTime lastModifiedTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String hasNumber(String number) {
        return number.isEmpty() ? "[no number]" : number;
    }

    public boolean isValidNumber(String number) {
        String pattern = "^\\+?(\\(\\w+\\)|\\w+[ -]\\(\\w{2,}\\)|\\w+)([ -]\\w{2,})*";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(number);
        return matcher.matches();
    }


    public String getNumber() {
        return hasNumber(number);
    }

    public void setNumber(String number) {
        if (isValidNumber(number)) {
            this.number = number;
        }
        else {
            this.number = "[no number]";
        }
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public Contact setCreatedTime() {
        this.createdTime = LocalDateTime.now();;
        return this;
    }

    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public Contact setLastModifiedTime() {
        this.lastModifiedTime = LocalDateTime.now();;
        return this;
    }
}

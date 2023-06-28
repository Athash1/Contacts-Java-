package contacts;

import java.io.Serial;
import java.io.Serializable;

public class Organization extends Contact implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String address;

    public String getAddress() {
        return address;
    }

    public Organization setAddress(String address) {
        this.address = address;
        return this;
    }


    @Override
    public String toString() {
        return ("Organization name: " + getName() + "\n" +
                "Address: " + getAddress() + "\n" +
                "Number: " + getNumber() + "\n" +
                "Time created: " + getCreatedTime() + "\n" +
                "Time last edit: " + getLastModifiedTime() + "\n");
    }
}

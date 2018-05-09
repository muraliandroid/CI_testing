package murali.myapplication.databinding;

/**
 * Created by shyleenrodrigues on 2/9/18.
 */

public class UserClass {

    String firstName;
    String lastName;

    public UserClass(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

package author;

import java.util.Date;

public class Author {
    private String name;
    private Date birthdate;

    public Author(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getBirthdate() { return birthdate; }
    public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }
}

package ru.job4j.map;

public class Person {
    private int id;
    private String firstName;
    private String lastName;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Person guest = (Person) obj;
        return id == guest.id
                && (firstName == guest.firstName
                || (firstName != null && firstName.equals(guest.getFirstName())))
                && (lastName == guest.lastName || (lastName != null && lastName .equals(guest.getLastName())
        ));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = 31 * result + id;
        result = 31 * result + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }
}

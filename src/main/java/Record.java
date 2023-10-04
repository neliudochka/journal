import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class Record {
    private String name;
    private String surname;
    private String birthday;
    private String phoneNumber;

    //вулиця, будинок, квартира
    private Address address;

    //зробити перевірку вхідних даних
    public Record(String name, String surname, String birthday,String phoneNumber, String address) {
        setName(name);
        setSurname(surname);
        setBirthday(birthday);
        setPhoneNumber(phoneNumber);
        setAddress(address);
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name must contain at least one character");
        } else {
            this.name = name;
        }
    }

    public void setSurname(String surname) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The surname must contain at least one character");
        } else {
            this.surname = surname;
        }
    }

    //покращити вивід
    static class DateValidator {
        public static final String dateFormat = "dd.MM.yyyy";
        public static boolean isValid(String date) {
            try {
                LocalDate.parse(date, DateTimeFormatter.ofPattern(dateFormat));
            } catch (DateTimeParseException e) {
                return false;
            }
            return true;
        }
    }
    public void setBirthday(String birthday) {
        if (DateValidator.isValid(birthday)) {
            this.birthday = birthday;
        } else {
            throw new IllegalArgumentException("The birth date must be in such format: " + DateValidator.dateFormat);
        }
    }

    static class PhoneNumberValidator {
        private final static String pattern = "^\\+\\d+";
        public final static String format = "+nnnn...";
        public final static int lowerLimit = 5;
        public final static int higherLimit = 20;
        public static void validate(String phoneNumber) {
            if (!phoneNumber.matches(pattern)) {
                throw new IllegalArgumentException("Phone number must match format: " + format);
            };
            if (lowerLimit >= phoneNumber.length() || phoneNumber.length() >= higherLimit) {
                throw new IllegalArgumentException("Phone number must at contain from " + lowerLimit + " to " + higherLimit + " numbers");
            }
        }
    }
    public void setPhoneNumber(String phoneNumber) {
        try {
            PhoneNumberValidator.validate(phoneNumber);
            this.phoneNumber = phoneNumber;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    class Address {
        //вул будинок квартира
        private String street;
        private String building;
        private String apartment;

        public Address(String street, String building, String apartment) {
            if (street.isEmpty()) {
                throw new IllegalArgumentException("The street name must contain at least one character");
            }
            if (building.isEmpty()) {
                throw new IllegalArgumentException("The street name must contain at least one character");
            }
            if (apartment.isEmpty()) {
                throw new IllegalArgumentException("The street name must contain at least one character");
            }
            this.street = street;
            this.building = building;
            this.apartment = apartment;
        }

        @Override
        public String toString() {
            return "Street: " + street +
                    "Building: " + building +
                    "Apartment: " + apartment;
        }

    }
    public void setAddress(String address) {
        String[] addressArr = address.split("\\s*,+\\s*");
        if (addressArr.length != 3) {
            throw new IllegalArgumentException("The address must consist 3 fields: street, building, apartment \n" +
                    "and use comma as a delimiter");
        }
        try {
            Address addressObj = new Address(addressArr[0], addressArr[1], addressArr[2]);
            this.address = addressObj;
        } catch (IllegalArgumentException exception) {
            throw exception;
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Birthday: " + birthday + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Address: " + address;
    }

}

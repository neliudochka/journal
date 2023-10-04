import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecordTest {
    Record record = new Record("Mila",
            "Gorbunova",
            "01.02.2003",
            "+380506821652",
            "Kyiv, Hell, 12");


    //ім'я
    @Test
    public void setNameCorrectInput() {
        try {
            record.setName("JB");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void setNameIncorrectInput() {
        String exceptionMessage = "The name must contain at least one character";
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                record.setName(""));
        assertEquals(exceptionMessage, exception.getMessage());
    }

    //дата
    @Test
    public void dateValidatorIsValidTrue() {
        assertTrue(Record.DateValidator.isValid("22.03.2004"));
    }

    @Test
    public void dateValidatorIsValidFalse() {
        assertFalse(Record.DateValidator.isValid("22.03.20048"));
    }

    @Test
    public void dateValidatorIsValidWrongFormat() {
        assertFalse(Record.DateValidator.isValid("3 Dec 2011"));
    }

    @Test
    public void setDataCorrectInput() {
        try {
            record.setBirthday("01.01.2000");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void setDataIncorrectInput() {
        String exceptionMessage = "The birth date must be in such format: " + Record.DateValidator.dateFormat;
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                record.setBirthday("01/01/2000"));
        assertEquals(exceptionMessage, exception.getMessage());
    }

    //номер телефону
    @Test
    public void setPhNumberCorrectInput() {
        try {
            record.setPhoneNumber("+1234567");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void setPhNumberWrongFormat() {
        String exceptionMessage = "Phone number must match format: " + Record.PhoneNumberValidator.format;
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                record.setPhoneNumber("786-307-3615"));
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void setPhNumberWrongNumberOfDigits() {
        String exceptionMessage = "Phone number must at contain from " + Record.PhoneNumberValidator.lowerLimit
                + " to " + Record.PhoneNumberValidator.higherLimit + " numbers";
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                record.setPhoneNumber("+3333"));
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    public void setAddressCorrectInput() {
        record.setAddress("St Colonia,2B, 1");
    }

    @Test
    public void setAddressWrongFormat() {
        String exceptionMessage = "The address must consist 3 fields: street, building, apartment \n" +
                "and use comma as a delimiter";
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                record.setAddress("St Colonia 2B 1"));
        assertEquals(exceptionMessage, exception.getMessage());
    }
}
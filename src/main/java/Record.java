public class Record {
    final private String name;
    private final String surname;
    private final String birthday;
    private final String phoneNumber;

    //вулиця, будинок, квартира
    private final String address;

    //зробити перевірку вхідних даних
    public Record(String name, String surname, String birthday,String phoneNumber, String address) {
      this.name = name;
      this.surname = surname;
      this.birthday = birthday;
      this.phoneNumber = phoneNumber;
      this.address = address;
    };

    //покращити вивід

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Birthday: " + birthday + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Address: " + address + "\n";
    }
}

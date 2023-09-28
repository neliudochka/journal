import java.util.ArrayList;

public class Journal {
    //структура даних для збереження записів
    private final ArrayList<Record> records = new ArrayList<>();

    //додати запис
    public void add (String name, String surname, String birthday,String phoneNumber, String address) {
        Record newRecord = new Record(name, surname, birthday, phoneNumber, address);
        records.add(newRecord);
        //
    }

    //подивитися записи
    public void show () {
        for (int i =0; i < records.size(); i++) {
            System.out.println("\t" + "Record " + i);
            System.out.println(records.get(i));
            System.out.println("-----------------------");
        }
    }

}

/*

Для цього потрібно:
    • організувати введення даних з командної строки і передати результат введення у відповідну сутність;
    • перевіряти на правильність введення даних (зберігаючи правильно введені) і в разі
     повної коректності всіх даних – передати їх до відповідного класу в моделі;
     якщо дані не відповідають необхідному формату, то запропонувати повторне введення.
    • відображати всі записи журналу.
 */


public class Main {
    public static void main(String[] args) {
        //введення з терміналу
        //перевірка значень
        //передача їх у клас
        Journal journal = new Journal();
        journal.add("Mila", "Gorbunova", "", "", "");
        journal.add("Liza", "Gorbunova", "", "", "tam ze");

        journal.show();
    }
}


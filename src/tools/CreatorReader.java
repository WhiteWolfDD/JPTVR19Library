package tools;

import entity.Reader;
import java.util.Scanner;

public class CreatorReader {
    Scanner scanner = new Scanner(System.in);

    public Reader getReader() {
        Reader reader = new Reader();
        System.out.println("--- Создание читателя ---");
        System.out.println("Введите имя читателя: ");
        reader.setFirstname(scanner.nextLine());
        System.out.println("Введите фамилию читателя: ");
        reader.setLastname(scanner.nextLine());
        System.out.println("Введите телефон читателя: ");
        reader.setPhone(scanner.nextLine());
        return reader;
    }
    
}
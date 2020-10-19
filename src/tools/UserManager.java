package tools;

import entity.Reader;
import entity.User;
import java.util.Scanner;

public class UserManager {
    public User createUser() {
        ReaderManager readerManager = new ReaderManager();
        Reader reader = readerManager.createReader();
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Создание пользователя ---");
        System.out.print("Введите логин: ");
        user.setLogin(scanner.nextLine());
        System.out.print("Введите пароль: ");
        user.setPassword(scanner.nextLine());
        System.out.print("Укажите роль: ");
        user.setRole(scanner.nextInt());
        return user;
    }
    public void addUserToArray(User user, User[] users){
        for (int i = 0; i < users.length; i++) {
            if(users[i] == null){
                users[i]=user;
                break;
            }
        }
    }

    public void printListUsers(User[] users) {
        for (int i = 0; i < users.length; i++) {
            if(users[i]!= null){
                System.out.printf("%3d. Логин: %s%n     Пароль: %s%n     Роль: %s%n"
                        ,i+1
                        ,users[i].getLogin()
                        ,users[i].getPassword()
                        ,users[i].getRole()
                );
                System.out.println("--------------------------------");
            }
        }
    }

}
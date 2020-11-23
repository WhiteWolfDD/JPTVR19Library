/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.creators;

import entity.Reader;
import entity.User;
import entity.dbcontrollers.ReaderFacade;
import java.util.List;
import java.util.Scanner;

import entity.dbcontrollers.UserFacade;
import factory.FactoryFacade;
import security.SecureManager;

public class UserManager {
        private Scanner scanner = new Scanner(System.in);
        private ReaderFacade readerFacade = FactoryFacade.getReaderFacade();
        private UserFacade userFacade = FactoryFacade.getUserFacade();

    public User createUser() {
        ReaderManager readerManager = new ReaderManager();
        Reader reader = readerManager.createReader();
        readerFacade.create(reader);
        User user = new User();
        System.out.println("--- Создание пользователя ---");
        System.out.print("Введите логин: ");
        user.setLogin(scanner.nextLine());
        System.out.print("Введите пароль: ");
        user.setPassword(scanner.nextLine());
        int numRole;
        do{
            System.out.print("Список ролей: ");
            for (int i = 0; i < SecureManager.role.values().length; i++) {
                System.out.printf("%d. %s%n"
                        ,i+1
                        ,SecureManager.role.values()[i]
                );
            }
            System.out.println("Укажите номер роли: ");
            String numRoleStr = scanner.nextLine();
            try {
                numRole = Integer.parseInt(numRoleStr);
                break;
            } catch (Exception e) {
                System.out.println("Вводите указанные цифры!");
            }
        }while(true);
        
        user.setRole(SecureManager.role.values()[numRole - 1].toString());
        user.setReader(reader);
        System.out.println("Пользователь создан: "+user.toString());
        userFacade.create(user);
        return user;
    }

    public void addUserToArray(User user, List<User> listUsers) {
        listUsers.add(user);
    }

    public void printListUsers(List<User> listUsers) {
        for (int i = 0; i < listUsers.size(); i++) {
            if(listUsers.get(i) != null){
                System.out.println(listUsers.get(i) + ". " + listUsers.get(i).getId().toString());
            }
        }   
    }
    
}

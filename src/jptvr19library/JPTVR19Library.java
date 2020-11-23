/**
 * Шаги подключения базы к приложению.
 * 1. Запустить базу данных ("jptvr19library")
 * 2. Создать пользователя базы (user = "jptvr19library") и пароль (password = "jptvr19library")
 * 3. Подключить поставщика постоянства (persistence provider) EclipseLink(JPA 2.1)
 * 4. Подлючить драйвер базы даннх (mysql-connector)
 * 5. Сущностные классы пометить аннотациями (@Entity, @Id, @GenerationValue и др.  (см. Изучаем Java EE 7))
 * 6. Создать persistence unit в файле persistence.xml
 * 7. Добавить сущности в файл persistence.xml
 * 8. Создать класс, который отвечает за работу с базой данных (SaveToBase)
 * 9. В бизнес-логике приложения использовать объект этого класса для сохранения данных в базу
 */
package jptvr19library;

import factory.ConnectorSingleton;

public class JPTVR19Library {

    public static void main(String[] args) {
        App app = new App();
        try {
            app.run();
        } finally {
            ConnectorSingleton connect = ConnectorSingleton.getInstance();
            if (connect.getEntityManager() != null){
                connect.getEntityManager().close();
            }
            if (connect.getEntityManagerFactory() != null){
                connect.getEntityManagerFactory().close();
            }
        }
    }
    
}

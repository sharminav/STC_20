package lesson_15;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 1) Спроектировать базу
 *    - Таблица USER содержит поля id, name, birthday, login_ID, city, email, description
 *    - Таблица ROLE содержит поля id, name (принимает значения Administration, Clients, Billing), description
 *    - Таблица USER_ROLE содержит поля id, user_id, role_id
 *    - Типы полей на ваше усмотрению, возможно использование VARCHAR(255)
 *
 * 2) Через jdbc интерфейс сделать запись данных(INSERT) в таблицу
 *    a) Используя параметризированный запрос
 *    b) Используя batch процесс
 * 3) Сделать параметризированную выборку по login_ID и name одновременно
 * 4) Перевести connection в ручное управление транзакциями
 *    a) Выполнить 2-3 SQL операции на ваше усмотрение (например, Insert в 3 таблицы – USER, ROLE, USER_ROLE) между sql операциями установить логическую точку сохранения(SAVEPOINT)
 *    б) Выполнить 2-3 SQL операции на ваше усмотрение (например, Insert в 3 таблицы – USER, ROLE, USER_ROLE) между sql операциями установить точку сохранения (SAVEPOINT A), намеренно ввести некорректные данные на последней операции, что бы транзакция откатилась к логической точке SAVEPOINT A
 */
public class Test {

    private static final String db = "jdbc:postgresql://localhost:5432/stc";
    private static final String user = "postgres";
    private static final String password = "qwe123";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        WorkDB workDB = new WorkDB();
        Connection connection = workDB.getConnection(db, user, password, true);
        workDB.getDBMetadata(connection);

        // Вставка при помощи параметризованого запроса
        String insertParams = workDB.insertRow(connection);
        System.out.println(insertParams);

        // Вставка при помощи Batch
        String insertBatch = workDB.insertRowBatch(connection);
        System.out.println(insertBatch);

        // параметризованная выборка
        workDB.selectUser(connection, "user_6".concat("%"), "user_login_6".concat("%"));

        connection.close();

        connection = workDB.getConnection(db, user, password, false);
        workDB.insertWithSavePoint(connection, 6);




    }

}

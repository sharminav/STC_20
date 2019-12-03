package lesson_15;

import java.sql.*;
import java.util.Formatter;

/**
 * Класс для работы с базой данны
 */

public class WorkDB {

    /**
     * Получение подключения к БД
     * @param dbConnectionString строгка соединения с БД
     * @return соеднение с БД
     * @throws SQLException
     */
    public Connection getConnection (String dbConnectionString, String userName, String password, Boolean autoCoomit) throws SQLException {
        Connection connection =  DriverManager.getConnection(dbConnectionString, userName, password);
        connection.setAutoCommit(autoCoomit);
        return connection;
    }

    /**
     * Получения описания БД
     * @param connection соединение с БД
     * @throws SQLException
     */
    public void getDBMetadata(Connection connection) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println("db connection test");
        System.out.println("database: " + metaData.getDatabaseProductName() + " " + metaData.getDatabaseProductVersion());
    }

    /**
     * Вставка при помощи параметризованного запроса
     * @param connection соединение с БД
     * @return результат выполнения
     */
    public String insertRow(Connection connection) throws SQLException {
        PreparedStatement insertStmt = getInsertDataUser(connection);
        insertStmt.executeUpdate();
        return  "insert ok";
    }

    /**
     * Вставка при помощи batch
     * @param connection
     * @return результат выполнения
     * @throws SQLException
     */
    public String insertRowBatch(Connection connection) throws SQLException {
        PreparedStatement insertStmt = getInsertDataUser(connection);
        insertStmt.addBatch();
        insertStmt.executeBatch();
        return  "insert batch ok";
    }

    /**
     * Подготовка данных для вставки в таблицу USER
     * @param connection соединение с БД
     * @return PreparedStatement
     */
    private PreparedStatement getInsertDataUser(Connection connection) {
        String query =  "INSERT INTO public.\"USER\"(" +
                        "name, birthday, \"login_ID\",  city, email, description)" +
                        "VALUES (?, ?, ?, ?, ?, ?);";
        try  {
            PreparedStatement insertStmt = connection.prepareStatement(query);
            String id  = Integer.toString((int)(Math.random() * 100));
            insertStmt.setString(1, "user_" + id);
            insertStmt.setDate(2, new Date(119, 11, 0), null);
            insertStmt.setString(3, "user_login_" + id);
            insertStmt.setString(4, "city" + id);
            insertStmt.setString(5, "email_" + id);
            insertStmt.setString(6, "description_" + id);
            return insertStmt;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Подготовка данных для вставки в таблицу USER_ROLE
     * @param connection соединение с БД
     * @return PreparedStatement
     */
    private PreparedStatement getInsertDataUserRole(Connection connection, int userID, int roleID) {
        String query =  "INSERT INTO public.\"USER_ROLE\" (" +
                "user_id, role_id) " +
                "VALUES (?, ?);";
        try  {
            PreparedStatement insertStmt = connection.prepareStatement(query);
            insertStmt.setInt(1, userID);
            insertStmt.setInt(2, roleID);
            return insertStmt;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    /**
     * Паремкетризованная выборка из таблицы USER
     * @param connection соединение с БД
     * @param name имя пользователя (для запроса)
     * @param loginid логин пользователя (для запроса)
     * @throws SQLException
     */
    public void selectUser(Connection connection, String name, String loginid) throws SQLException {
        Statement pstmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
        Formatter formatter = new Formatter();
        formatter.format("select * from public.\"USER\" where name like '%s' and \"login_ID\" like '%s'",  name, loginid) ;
        //System.out.println(formatter.toString());
        System.out.println("==========================");
        ResultSet rs = pstmt.executeQuery(formatter.toString());
        while (rs.next()) {
            System.out.println("row ID - " + rs.getInt("id"));
            System.out.println("name - " + rs.getString("name"));
            System.out.println("birthday - " + rs.getDate("birthday"));
            System.out.println("login_ID - " + rs.getString("login_ID"));
            System.out.println("city - " + rs.getString("city"));
            System.out.println("email - " + rs.getString("email"));
            System.out.println("description - " + rs.getString("description"));
            System.out.println("==========================");
        }
    }

    public void insertWithSavePoint(Connection connection) throws SQLException {

        Savepoint savepoint1 = null;

        try {
            PreparedStatement insertStmt = getInsertDataUser(connection);
            insertStmt.executeUpdate();

            insertStmt = getInsertDataUser(connection);
            insertStmt.executeUpdate();

            savepoint1 = connection.setSavepoint("sp1");

            insertStmt = getInsertDataUserRole(connection, 1, 1);
            insertStmt.executeUpdate();

        }
        catch (Exception ex) {
            System.out.println("ERROR");
            connection.rollback(savepoint1);
            System.out.println("rollback ok");
        }
        connection.commit();
    }




}

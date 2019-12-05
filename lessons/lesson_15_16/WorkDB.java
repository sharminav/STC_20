package lesson_15_16;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.Formatter;
import java.util.logging.LogManager;

/**
 * Класс для работы с базой данны
 */

public class WorkDB {

    static Logger logger = Logger.getLogger(Test.class.getName());

    /**
     * Получение подключения к БД
     * @param dbConnectionString строгка соединения с БД
     * @return соеднение с БД
     * @throws SQLException
     */
    public Connection getConnection (String dbConnectionString, String userName, String password, Boolean autoCommit){
        try {
            Connection connection = DriverManager.getConnection(dbConnectionString, userName, password);
            connection.setAutoCommit(autoCommit);
            logger.info("db connection ok");
            return connection;
        }
        catch (SQLException ex) {
            logger.error("db connection error");
            return null;
        }
    }

    /**
     * Получения описания БД
     * @param connection соединение с БД
     */
    public void getDBMetadata(Connection connection) {
        try {
            DatabaseMetaData metaData = connection.getMetaData();
        }
        catch (SQLException ex ) {
            ex.printStackTrace();
        }
    }

    /**
     * Вставка при помощи параметризованного запроса
     * @param connection соединение с БД
     * @return результат выполнения
     */
    public String insertRow(Connection connection) {
        try {
            PreparedStatement insertStmt = getInsertDataUser(connection);
            insertStmt.executeUpdate();
            logger.info("insert row success");
            return  "insert ok";
        }
        catch (SQLException ex) {
            logger.error("error insert row");
            return  "error";
        }
    }

    /**
     * Вставка при помощи batch
     * @param connection
     * @return результат выполнения
     */
    public String insertRowBatch(Connection connection)  {
        try {
            PreparedStatement insertStmt = getInsertDataUser(connection);
            insertStmt.addBatch();
            insertStmt.executeBatch();
            logger.info("insert row batch success");
            return  "insert ok";
        }
        catch (SQLException ex) {
            logger.error("error insert batch row");
            return  "error";
        }
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

    /**
     * ВЫполнение транзакций с SavePoint и Rollback
     * @param connection строка соединения
     * @throws SQLException
     */
    public void insertWithSavePoint(Connection connection, int userID) throws SQLException {

        Savepoint savepoint1 = null;

        try {
            PreparedStatement insertStmt = getInsertDataUser(connection);
            insertStmt.executeUpdate();

            insertStmt = getInsertDataUser(connection);
            insertStmt.executeUpdate();

            savepoint1 = connection.setSavepoint("sp1");

            insertStmt = getInsertDataUserRole(connection, userID, 1);
            insertStmt.executeUpdate();

            logger.info("savepoint ok");

        }
        catch (Exception ex) {
            //System.out.println("ERROR");
            logger.error(ex.getMessage());
            connection.rollback(savepoint1);
            logger.info("rollback ok");
            //System.out.println("rollback ok");
        }
        connection.commit();
    }




}

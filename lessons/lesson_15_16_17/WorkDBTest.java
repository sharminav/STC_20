package lesson_15_16_17;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.Mockito.*;

/**
 * JUnit тестирвоание
 * Mockito
 */

class WorkDBTest {

    private WorkDB workDB;
    private Connection connectionManager;
    private static final String db = "jdbc:postgresql://localhost:5432/stc";
    private static final String user = "postgres";
    private static final String password = "qwe123";
    static Logger logger = Logger.getLogger(lesson_15_16_17.Test.class.getName());


    /**
     * Метод, выполняющийся перед запуском тестов
     */
    @BeforeEach
    void setUp() {
        logger.trace("BeforeEach");
        PropertyConfigurator.configure("log4j.properties");
        workDB = new WorkDB();
        connectionManager = workDB.getConnection(db, user, password, true);
        //connectionManager = spy(workDB.getConnection(db, user, password, true));
    }

    /**
     * Метод, выполняющийся после запуска тестов
     * @throws SQLException
     */
    @AfterEach
    void tearDown () throws SQLException {
        logger.trace("AfterEach");
        connectionManager.close();
    }

    /**
     * Тестовый метод
     */
    @DisplayName("Тестирование запроса Select")
    @Test
    void selectQuery() throws SQLException {
        assumeTrue(workDB != null);
        assertDoesNotThrow(() -> workDB.selectUser(connectionManager, "user_%", "login_%"));
    }
}
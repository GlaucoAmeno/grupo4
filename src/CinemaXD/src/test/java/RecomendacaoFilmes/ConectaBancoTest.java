/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecomendacaoFilmes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author azaroth
 */
public class ConectaBancoTest {

    public ConectaBancoTest() {
    }

    Connection connection;

    @Before
    public void before() throws ClassNotFoundException, SQLException {
        connection = ConectaBanco.conectaBanco();
    }

    @After
    public void after() throws SQLException {
        connection.close();
    }

    @Test
    public void closeStatementShouldCloseStatement() throws SQLException {
        Statement stmt = connection.createStatement();
        try {
            if (null != stmt) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        assertTrue(stmt.isClosed());
    }

}

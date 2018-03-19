package no.hiof.larseknu.databasetest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MinDatabase {

    public static Connection connect()
    {
        Connection connection = null;

        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dyrehagedb?useSSL=false", "root", "drossap");
        }
        catch(SQLException sqle)
        {
            System.err.println(""+sqle.getMessage());
        }

        return connection;
    }
}

package no.hiof.larseknu.databasetest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AnimalMapper {

    private Connection connection;

    public AnimalMapper(Connection connection) {
        this.connection = connection;
    }

    public Dyr hentDyr(int id) {
        try
        {
            //Lag et nytt statement objekt
            Statement stmnt = connection.createStatement();

            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM dyr WHERE id = " + id + ";");
            resultSet.next();

            int dyreId = resultSet.getInt(1);
            return new Dyr(dyreId, resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
        }
        catch(SQLException sqle)
        {
            System.err.println("Feil: "+sqle);
            return null;
        }
    }

    public ArrayList<Dyr> hentAlleDyr() {
        ArrayList<Dyr> dyreListe = new ArrayList<>();

        try
        {
            //Lag et nytt statement objekt
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM dyr;");

            while (resultSet.next()) {
                int dyreId = resultSet.getInt(1);
                dyreListe.add(new Dyr(dyreId, resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
            }
        }
        catch(SQLException sqle)
        {
            System.err.println("Feil: "+sqle);
        }

        return dyreListe;
    }

    public void leggTilDyr(Dyr etDyr)  {
        try
        {
            //Lag et nytt statement objekt
            Statement statement = connection.createStatement();

            String sql = String.format("INSERT INTO dyr (animal, young, female, male, collective_noun) " +
                    "VALUES('%s','%s','%s','%s','%s');",
                    etDyr.getAnimal(), etDyr.getYoung(), etDyr.getMale(), etDyr.getFemale(), etDyr.getCollectiveNoun());

            statement.executeUpdate(sql);
        }
        catch(SQLException sqle)
        {
            System.err.println("Feil: "+sqle);
        }
    }

    public void slettDyr(int id) {

        try
        {
            //Lag et nytt statement objekt
            Statement statement = connection.createStatement();

            String sql = String.format("DELETE FROM dyr WHERE id = %d;", id);

            statement.executeUpdate(sql);
        }
        catch(SQLException sqle)
        {
            System.err.println("Feil: "+sqle);
        }
    }
}

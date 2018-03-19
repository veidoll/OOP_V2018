package no.hiof.larseknu.databasetest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class DyrDoa {

    private Connection connection;

    public DyrDoa(Connection connection) {
        this.connection = connection;
    }

    public Dyr hentDyrMedId(int id) {
        try
        {
            //Lag et nytt statement objekt
            Statement stmnt = connection.createStatement();

            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM dyr WHERE iddyr = " + id + ";");

            if (resultSet.next()) {

                int dyreId = resultSet.getInt("iddyr");
                String navn = resultSet.getString("navn");
                String art = resultSet.getString("art");
                String fodselsDatoString = resultSet.getString("fodselsdato");
                LocalDate fodselsdato = LocalDate.parse(fodselsDatoString);

                return new Dyr(dyreId, navn, art, fodselsdato);
            }
        }
        catch(SQLException sqle)
        {
            System.err.println("Feil: "+sqle);

        }

        return null;
    }

    public ArrayList<Dyr> hentAlleDyr() {
        ArrayList<Dyr> dyreListe = new ArrayList<>();

        try
        {
            //Lag et nytt statement objekt
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM dyr;");

            while (resultSet.next()) {
                dyreListe.add(new Dyr(resultSet.getInt("iddyr"),
                        resultSet.getString("navn"),
                        resultSet.getString("art"),
                        LocalDate.parse(resultSet.getString("fodselsdato"))));
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

            String sql = String.format("INSERT INTO dyr (navn, art, fodselsdato) " +
                    "VALUES('%s','%s','%s');",
                    etDyr.getNavn(), etDyr.getArt(), etDyr.getFodselsDato());

            statement.execute(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next())
                etDyr.setId((int) resultSet.getLong(1));
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

            String sql = String.format("DELETE FROM dyr WHERE iddyr = %d;", id);

            statement.executeUpdate(sql);
        }
        catch(SQLException sqle)
        {
            System.err.println("Feil: "+sqle);
        }
    }

    public void oppdaterDyr(Dyr etDyr) {
        try
        {
            //Lag et nytt statement objekt
            Statement statement = connection.createStatement();

            String sql = String.format("UPDATE dyr " +
                            "SET navn = '%s', art = '%s', fodselsdato = '%s' " +
                            "WHERE iddyr = %d;",
                    etDyr.getNavn(), etDyr.getArt(), etDyr.getFodselsDato().toString(), etDyr.getId());

            statement.executeUpdate(sql);
        }
        catch(SQLException sqle)
        {
            System.err.println("Feil: "+sqle);
        }
    }
}

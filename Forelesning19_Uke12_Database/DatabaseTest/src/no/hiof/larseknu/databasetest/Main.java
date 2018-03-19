package no.hiof.larseknu.databasetest;

import java.sql.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException {
        Main.postGrestest();

        Connection connection = MinDatabase.connect();

        DyrDoa dyrDoa = new DyrDoa(connection);

        System.out.println(dyrDoa.hentDyrMedId(20));

        System.out.println(dyrDoa.hentAlleDyr());


        for (Dyr etDyr : dyrDoa.hentAlleDyr()) {
            System.out.println(etDyr.getNavn() + " -- " + etDyr.getArt());
        }


        Dyr ape = new Dyr(0, "Julius", "Ape", LocalDate.now());

        dyrDoa.leggTilDyr(ape);

        ape.setNavn("JuliusJr");

        dyrDoa.oppdaterDyr(ape);

        System.out.println(dyrDoa.hentDyrMedId(ape.getId()));

        dyrDoa.slettDyr(ape.getId());

        connection.close();

    }

    public static void postGrestest() {
        String url = "jdbc:postgresql://localhost:5432/dyrehagedb";

        String bruker = "postgres";
        String passord = "drossap";

        try {
            Connection connection = DriverManager.getConnection(url, bruker, passord);

            String sporring = "SELECT * FROM dyr;";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sporring);

            while (resultSet.next()) {
                int dyrid = resultSet.getInt(1);
                String navn = resultSet.getString(2);
                String art = resultSet.getString(3);
                String fodselsdato = resultSet.getString(4);

                System.out.println(new Dyr(dyrid, navn, art, LocalDate.parse(fodselsdato)));
            }
        }
        catch (SQLException e) {
            System.out.println("Klarte ikke koble til databasen: " + e.getMessage());
        }
    }
}

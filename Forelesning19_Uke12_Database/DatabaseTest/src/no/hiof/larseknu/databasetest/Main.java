package no.hiof.larseknu.databasetest;

import java.sql.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Connection connection = MinDatabase.connect();

        AnimalMapper animalMapper = new AnimalMapper(connection);

        System.out.println(animalMapper.hentDyr(1));

        System.out.println(animalMapper.hentAlleDyr());


        for (Dyr etDyr:
             animalMapper.hentAlleDyr()) {
            System.out.println(etDyr.getAnimal() + " -- " + etDyr.getMale());
        }


        Dyr ape = new Dyr(0, "Ape", "Monkey", "Apee", "Apa", "Horde");

        animalMapper.leggTilDyr(ape);


        animalMapper.slettDyr(209);

    }

    public void test() {
        String url = "jdbc:postgresql://localhost:5432/postgres";

        String bruker = "postgres";
        String passord = "drossap";

        try {
            Connection connection = DriverManager.getConnection(url, bruker, passord);

            String sporring = "SELECT * FROM dyr;";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sporring);

            while (resultSet.next()) {
                String dyrid = resultSet.getString(1);
                String navn = resultSet.getString(2);
                String art = resultSet.getString(3);
                String fodselsdato = resultSet.getString(4);

                //System.out.println(new Dyr(Integer.parseInt(dyrid), navn, art, LocalDate.parse(fodselsdato)));
            }
        }
        catch (SQLException e) {
            System.out.println("Klarte ikke koble til databasen: " + e.getMessage());
        }
    }
}

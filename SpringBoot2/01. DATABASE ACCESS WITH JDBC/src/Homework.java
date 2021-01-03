import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Homework {

    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    public static final String MINIONS_TABLE_NAME = "minions_db";

    private Connection connection;

    private BufferedReader reader;

    public Homework() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void setConnection(String user, String password) throws SQLException {

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        connection = DriverManager
                .getConnection(CONNECTION_STRING + MINIONS_TABLE_NAME, properties);
    }

    public void getVillainsNamesEx2() throws SQLException {
        String query = "SELECT v.name, COUNT(mv.minion_id) AS 'count'\n" +
                "FROM villains AS v\n" +
                "JOIN minions_villains mv on v.id = mv.villain_id\n" +
                "GROUP BY v.id\n" +
                "HAVING `count`> 15\n" +
                "ORDER BY `count` DESC;";

        PreparedStatement statement = connection
                .prepareStatement(query);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n",
                    resultSet.getString(1),
                    resultSet.getInt(2));
        }


    }

    public void getMinionNamesEx3() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter villain id:");
        int villainId = Integer.parseInt(reader.readLine());


        String villainName = getEntityNameById(villainId, "villains");

        if (villainName == null) {
            System.out.printf("No villain with id %d", villainId);
            return;
        }
        System.out.printf("Villain: %s%n", villainName);

        String query = "SELECT m.name, m.age FROM minions AS m\n" +
                "JOIN minions_villains mv on m.id = mv.minion_id\n" +
                "WHERE mv.villain_id= ?";

        PreparedStatement statement = connection
                .prepareStatement(query);
        statement.setInt(1, villainId);

        ResultSet resultSet = statement.executeQuery();

        int counter = 1;
        while (resultSet.next()) {
            System.out.printf("%d. %s %d%n"
                    , counter++
                    , resultSet.getString("name")
                    , resultSet.getInt("age"));
        }


    }

    private String getEntityNameById(int entityId, String tableName) throws SQLException {
        String query = String.format("SELECT name From %s WHERE id= ?", tableName);

        PreparedStatement statement = connection
                .prepareStatement(query);

        statement.setInt(1, entityId);

        ResultSet resultSet = statement.executeQuery();

        return resultSet.next() ? resultSet.getString("name") : null;
    }


    public void getMinionEx4() throws IOException, SQLException {
        System.out.printf("Enter minions info: name, age, town name: ");
        String[] minionInfo = reader.readLine().split("\\s+");

        System.out.printf("Enter Villain name: ");
        String villainName = reader.readLine();

        String minionName = minionInfo[0];
        int age = Integer.parseInt(minionInfo[1]);
        String townName = minionInfo[2];

        int townId = getEntityIdByName(townName, "towns");

        if (townId < 0) {
            insertEntityInTowns(townName);
            System.out.printf("Town %s was added to the database.%n", townName);
        }

        if(!checkIfEntityExist(villainName,"villains")) {
        insertVillain(villainName);
        }

        insertMinion(minionName,age,townId);

        int minionId=getEntityId(minionName,"minions");
        int villainId=getEntityId(villainName,"villains");

        hireMinion(minionId,villainId);

        System.out.println(String.format("Successfully added %s to be minion of %s",minionName,villainName));


    }

    private boolean checkIfEntityExist(String name, String tableName) throws SQLException {

        String query = "SELECT * FROM " + tableName + " WHERE name= ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);

        ResultSet resSet = statement.executeQuery();

        if (resSet.next()) {
            return true;
        }

        return false;
    }


    private void insertEntityInTowns(String townName) throws SQLException {
        String query = "INSERT INTO towns(name) value (?)";

        PreparedStatement statement = connection
                .prepareStatement(query);
        statement.setString(1, townName);
        statement.execute();
    }

    private int getEntityIdByName(String entityName, String tableName) throws SQLException {
        String query = String.format("SELECT id FROM %s WHERE name=?", tableName);
        // String query = String.format("SELECT id FROM " + tableName + " WHERE name=?", tableName); vtori na4in

        PreparedStatement statement = connection
                .prepareStatement(query);
        statement.setString(1, entityName);

        ResultSet resultSet = statement.executeQuery();

        return resultSet.next() ? resultSet.getInt(1) : -1;
    }

    private void insertVillain(String villainName) throws SQLException {

        String query =String
                .format("INSERT INTO villains(name, evilness_factor) VALUES('%s','evil')",villainName);

        PreparedStatement prStatement=connection.prepareStatement(query);

        prStatement.execute();
        System.out.println(String.format("Villain %s was added to the database.", villainName));
    }

    private int getEntityId(String name,String tableName) throws SQLException {
        String query=String.format("SELECT id FROM " +
                "%s WHERE name=%s",tableName,name);

        // evgeni parvanov 070017300

        PreparedStatement prSatement=connection.prepareStatement(query);
        ResultSet resultSet=prSatement.executeQuery();

        resultSet.next();

        return resultSet.getInt(1);
    }

private void insertMinion(String minionName, int age ,int townId) throws SQLException {

        String query=String
                .format("INSERT INTO minions(name, age, town_id) VALUES('%s','%d','%d')",minionName,age,townId);

        PreparedStatement prStatement=connection.prepareStatement(query);

        prStatement.execute();

}

private void hireMinion(int minionId,int villainId) throws SQLException {

        String query=String
                .format("INSERT INTO minions_villains(minion_id, villain_id VALUES(%d, %d)",minionId,villainId);

        PreparedStatement prStatement=connection.prepareStatement(query);
        prStatement.execute();


}


    public void changeTownNameCasingEx5() throws IOException, SQLException {
        System.out.println("Entry country name:");

        String countryName = reader.readLine();

        String query = "UPDATE towns SET name = UPPER(name) WHERE country= ?";

        PreparedStatement statement = connection
                .prepareStatement(query);

        statement.setString(1, countryName);

        int townsAffected = statement.executeUpdate();

        System.out.printf("%d town names were affected.%n", townsAffected);

    }

    public void IncreaseAgeStoredProcedureEx9() throws IOException, SQLException {
        System.out.println("Enter minion_id: ");
        int minionID = Integer.parseInt(reader.readLine());

        String query = "CALL usp_get_older(?)";  // tyka. vuprositelniq e parametur koito my podavame

        CallableStatement callableStatement = connection
                .prepareCall(query);

        callableStatement.setInt(1, minionID);   // tova otiva  po gore na purva poziciq
        // ako imahme o6te edin parametur 6tqhme da imame o6te edin red i da imame ot vtora poziciq
        callableStatement.execute();
    }

    public void PrintAllMinionsNameEx7() throws SQLException {
        System.out.println("You will see all minions:");

        String queryFirst = "SELECT * FROM minions";

        String queryLast = "SELECT * FROM MINIONS\n" +
                "ORDER BY id DESC";

        String queryCount = "SELECT COUNT(name) FROM minions";

        PreparedStatement statementCount = connection.prepareStatement(queryCount);
        ResultSet resultSetCount = statementCount.executeQuery();


        PreparedStatement statementFirst = connection.prepareStatement(queryFirst);
        PreparedStatement statementLast = connection.prepareStatement(queryLast);

        ResultSet resultSetFirst = statementFirst.executeQuery();
        ResultSet resultSetLast = statementLast.executeQuery();

        while (resultSetLast.next() && resultSetFirst.next()) {

            System.out.printf("%s%n", resultSetFirst.getString("name"));
            System.out.printf("%s%n", resultSetLast.getString("name"));
        }


    }
}


import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class Homework {
    private static final String
            DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver",
            CONNECTION_URL = "jdbc:mysql://localhost:3306/",
            DATABASE_NAME = "minions_db";

    public void loadDatabaseDriver() {
        try {
            Class.forName(DATABASE_DRIVER);
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
            return;
        }
        System.out.printf("DB Driver successfully loaded: '%s'", DATABASE_DRIVER).println();
    }

    private Connection connection;

    public void setConnectionToDatabase(String user, String password) {
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        try {
            this.connection = DriverManager.getConnection(String.format("%s%s", CONNECTION_URL, DATABASE_NAME), properties);
        } catch (SQLException exception) {
            exception.printStackTrace();
            return;
        }
        System.out.printf("Successfully connected to DB with URL: '%s'",
                String.format("%s%s", CONNECTION_URL, DATABASE_NAME))
                .println();
    }

    public void getVillainsNamesExercise2() {
        String getVillainNameAndNumberOfMinionsSqlStatement =
                "SELECT v.`name` AS `name_of_villain`, COUNT(mv.`minion_id`) AS `number_of_minions`\n" +
                "FROM `villains` AS v\n" +
                "LEFT JOIN `minions_villains` AS mv\n" +
                "ON v.`id` = mv.`villain_id`\n" +
                "GROUP BY mv.`villain_id`\n" +
                "HAVING `number_of_minions` > 15\n" +
                "ORDER BY `number_of_minions` DESC;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getVillainNameAndNumberOfMinionsSqlStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                System.out.printf("%s %d",
                        resultSet.getString("name_of_villain"),
                        resultSet.getInt("number_of_minions"))
                        .println();
            }
        }
        catch (SQLException exception) { exception.printStackTrace(); }
    }

    public void getMinionNamesExercise3() {
        Scanner sc = new Scanner(System.in);
        int paramVillainId = Integer.parseInt(sc.nextLine());
        String getVillainNameSqlStatement =
                "SELECT `name` AS `name_of_villain`\n" +
                "FROM `villains`\n" +
                "WHERE `id` = ?;",
                getMinionNamesSqlStatement =
                "SELECT DISTINCT m.`name` AS `name_of_minion`, m.`age` AS `age_of_minion`\n" +
                "FROM `minions` AS m\n" +
                "INNER JOIN `minions_villains` AS mv\n" +
                "ON m.`id` = mv.`minion_id`\n" +
                "WHERE mv.`villain_id` = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getVillainNameSqlStatement);
            preparedStatement.setInt(1, paramVillainId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()) {
                System.out.printf("No villain with ID %d exists in the database.", paramVillainId)
                        .println();
                return;
            }
            System.out.printf("Villain: %s", resultSet.getString("name_of_villain"))
                    .println();
            preparedStatement = connection.prepareStatement(getMinionNamesSqlStatement);
            preparedStatement.setInt(1, paramVillainId);
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while(resultSet.next()) {
                ++count;
                System.out.printf("%d. %s %d",
                        count,
                        resultSet.getString("name_of_minion"),
                        resultSet.getInt("age_of_minion"))
                        .println();
            }
        }
        catch (SQLException exception) { exception.printStackTrace(); }
    }
    public void addMinionExercise4() {
        Scanner sc = new Scanner(System.in);
        List<String> minionInformation = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
        String minionName = minionInformation.get(1), minionTown = minionInformation.get(3);
        int minionAge = Integer.parseInt(minionInformation.get(2));
        String villainName = sc.nextLine().split("\\s+")[1];
        String insertTownSqlStatement =
                "INSERT INTO `towns` (`name`)\n" +
                "VALUES\n" +
                "(?)";
        String insertMinionSqlStatement =
                "INSERT INTO `minions` (`name`, `age`, `town_id`)\n" +
                "VALUES\n" +
                "(?, ?, ?);";
        String insertVillainSqlStatement =
                "INSERT INTO `villains` (`name`, `evilness_factor`)\n" +
                "VALUES\n" +
                "(?, 'evil');\n";
        String insertRelationSqlStatement =
                "INSERT INTO `minions_villains`\n" +
                "VALUES\n" +
                "(?, ?);";
        try {
            int townId = this.checkExistence("towns", minionTown);
            if(townId == -1) {
                //insert town
                PreparedStatement insertTown = this.connection.prepareStatement(insertTownSqlStatement);
                insertTown.setString(1, minionTown);
                insertTown.executeUpdate();
                townId = this.checkExistence("towns", minionTown);
                System.out.printf("Town %s was added to the database.", minionTown).println();
            }
            int minionId = this.checkExistence("minions", minionName);
            if(minionId == -1) {
                //insert minion
                PreparedStatement insertMinion = this.connection.prepareStatement(insertMinionSqlStatement);
                insertMinion.setString(1, minionName);
                insertMinion.setInt(2, minionAge);
                insertMinion.setInt(3, townId);
                insertMinion.executeUpdate();
                minionId = this.checkExistence("minions", minionName);
            }
            int villainId = this.checkExistence("villains", villainName);
            if(villainId == -1) {
                //insert villain
                PreparedStatement insertVillain = this.connection.prepareStatement(insertVillainSqlStatement);
                insertVillain.setString(1, villainName);
                insertVillain.executeUpdate();
                villainId = this.checkExistence("villains", villainName);
                System.out.printf("Villain %s was added to the database.", villainName).println();
            }
            PreparedStatement insertRelation = this.connection.prepareStatement(insertRelationSqlStatement);
            insertRelation.setInt(1, minionId);
            insertRelation.setInt(2, villainId);
            System.out.printf("Successfully added %s to be minion of %s.", minionName, villainName).println();
        }
        catch (SQLException exception) { exception.printStackTrace(); }
    }

    private int checkExistence(String table, String name) {
        String sqlStatement =
                String.format("SELECT `id`\n" +
                "FROM %s\n" +
                "WHERE `name` = ?;", table);
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) return resultSet.getInt("id");
        }
        catch (SQLException exception) { exception.printStackTrace(); }
        return -1;
    }
    public void changeTownNamesCasingExercise5() {
        Scanner sc = new Scanner(System.in);
        String country = sc.nextLine();
        String updateTownsToUppercaseSqlStatement =
                "UPDATE `towns`\n" +
                "SET `name` = UPPER(`name`)\n" +
                "WHERE `country` = ?;";
        String getTownsAffectedSqlStatement =
                "SELECT `name`\n" +
                "FROM `towns`\n" +
                "WHERE `country` = ?;";
        try {
            PreparedStatement updateTownsToUppercase = connection.prepareStatement(updateTownsToUppercaseSqlStatement);
            updateTownsToUppercase.setString(1, country);
            updateTownsToUppercase.executeUpdate();
            PreparedStatement getTownsAffected = connection.prepareStatement(getTownsAffectedSqlStatement);
            getTownsAffected.setString(1, country);
            ResultSet resultSet = getTownsAffected.executeQuery();
            if(!resultSet.next()) {
                System.out.println("No town names were affected.");
                return;
            }
            List<String> townsAffected = new ArrayList<>();
            townsAffected.add(resultSet.getString("name"));
            while(resultSet.next()) townsAffected.add(resultSet.getString("name"));
            System.out.printf("%d town names were affected.", townsAffected.size()).println();
            System.out.println(String.join(", ", townsAffected));
        }
        catch (SQLException exception) { exception.printStackTrace(); }
    }

    public void removeVillainExercise6() {
        Scanner sc = new Scanner(System.in);
        int paramVillainId = Integer.parseInt(sc.nextLine());
        String getVillainNameSqlStatement =
                "SELECT `name`\n" +
                "FROM `villains`\n" +
                "WHERE `id` = ?;";
        String deleteRelationSqlStatement =
                "DELETE FROM `minions_villains`\n" +
                "WHERE `villain_id` = ?;";
        String deleteVillainSqlStatement =
                "DELETE FROM `villains`\n" +
                "WHERE `id` = ?;";
        try {
            this.connection.setAutoCommit(false);
            PreparedStatement getVillainName = this.connection.prepareStatement(getVillainNameSqlStatement);
            getVillainName.setInt(1, paramVillainId);
            ResultSet resultSetGetVillainName = getVillainName.executeQuery();
            if(!resultSetGetVillainName.next()) {
                System.out.println("No such villain was found");
                this.connection.rollback();
                return;
            }
            PreparedStatement deleteRelation = this.connection.prepareStatement(deleteRelationSqlStatement);
            deleteRelation.setInt(1, paramVillainId);
            int countMinions = deleteRelation.executeUpdate();
            PreparedStatement deleteVillain = this.connection.prepareStatement(deleteVillainSqlStatement);
            deleteVillain.setInt(1, paramVillainId);
            System.out.printf("%s was deleted", resultSetGetVillainName.getString("name")).println();
            System.out.printf("%d minions released", countMinions).println();
            this.connection.commit();
        }
        catch (SQLException exception) { exception.printStackTrace(); }
    }

    public void printAllMinionNamesExercise7() {
        String getMinionNamesSqlStatement =
                "SELECT `name`\n" +
                "FROM `minions`;";
        try {
            PreparedStatement getMinionNames = connection.prepareStatement(getMinionNamesSqlStatement);
            ResultSet resultSet = getMinionNames.executeQuery();
            List<String> minionNames = new ArrayList<>();
            while(resultSet.next()) minionNames.add(resultSet.getString("name"));
            for (int i = 0; i < minionNames.size() / 2; i++) {
                System.out.println(minionNames.get(i));
                System.out.println(minionNames.get(minionNames.size() - i - 1));
            }
            if(minionNames.size() % 2 == 1) System.out.println(minionNames.get(minionNames.size() / 2 + 1));
        }
        catch (SQLException exception) { exception.printStackTrace(); }
    }

    public void increaseMinionsAgeExercise8() {
        Scanner sc = new Scanner(System.in);
        List<Integer> paramMinionsId = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String updateMinionsSqlStatement =
                "UPDATE `minions`\n" +
                "SET `name` = LOWER(`name`), `age` = `age` + 1\n" +
                "WHERE `id` = ?;";
        String getMinionsInformationSqlStatement =
                "SELECT `name`, `age`\n" +
                "FROM `minions`;";
        try {
            PreparedStatement updateMinions = this.connection.prepareStatement(updateMinionsSqlStatement);
            for(int i = 0; i < paramMinionsId.size(); i++) {
                updateMinions.setInt(1, paramMinionsId.get(i));
                updateMinions.executeUpdate();
            }
            PreparedStatement getMinionsInformation = this.connection.prepareStatement(getMinionsInformationSqlStatement);
            ResultSet resultSet = getMinionsInformation.executeQuery();
            while(resultSet.next()) {
                System.out.printf("%s %d",
                        resultSet.getString("name"),
                        resultSet.getInt("age"))
                        .println();
            }
        }
        catch (SQLException exception) { exception.printStackTrace(); }
    }

    public void increaseAgeStoredProcedureExercise9() {
        Scanner sc = new Scanner(System.in);
        int paramMinionId = Integer.parseInt(sc.nextLine());
        String callProcedureSqlStatement = "CALL usp_get_older(?);";
        String getMinionInformationSqlStatement =
                "SELECT `name`, `age`\n" +
                "FROM `minions`\n" +
                "WHERE `id` = ?;";
        try {
            PreparedStatement callProcedure = this.connection.prepareStatement(callProcedureSqlStatement);
            callProcedure.setInt(1, paramMinionId);
            callProcedure.executeUpdate();
            PreparedStatement getMinionInformation = this.connection.prepareStatement(getMinionInformationSqlStatement);
            getMinionInformation.setInt(1, paramMinionId);
            ResultSet resultSet = getMinionInformation.executeQuery();
            if(resultSet.next()) {
                System.out.printf("%s %d", resultSet.getString("name"), resultSet.getInt("age"))
                        .println();
            }
        }
        catch (SQLException exception) { exception.printStackTrace(); }
    }
}
import com.mysql.jdbc.ResultSetRow;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PersonDbManager {
    private static final String SQL_CREATE = "CREATE TABLE PERSONS"
            + "("
            + " UID INT NOT NULL AUTO_INCREMENT,"
            + " NAME VARCHAR(100) NOT NULL,"
            + " AGE DECIMAL(15, 2) NOT NULL,"
            + " PRIMARY KEY (UID)"
            + ")";
    private static final String SQL_INSERT = "INSERT INTO PERSONS (NAME, AGE) VALUES (?,?)";
    private static final String SQL_SELECT = "SELECT * FROM PERSONS";


    public void createTable() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/test?useSSL=false", "root", "Finecut1988");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_CREATE)) {

            preparedStatement.execute();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dropTable() {

        String SQL_DROP = "DROP TABLE IF EXISTS PERSONS";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/test?useSSL=false", "root", "Finecut1988");
             Statement statement = conn.createStatement()) {

            // if DDL failed, it will raise an SQLException
            statement.execute(SQL_DROP);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertPerson(Person person) {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/test?useSSL=false", "root", "Finecut1988");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

                preparedStatement.setString(1, person.getName());
                preparedStatement.setInt(2, person.getAge());

            int row = preparedStatement.executeUpdate();

            // rows affected
            //System.out.println(row); // 1

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Person> selectPersons() {
        List<Person> personList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/test?useSSL=false", "root", "Finecut1988");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Person obj = new Person();

                long uid = resultSet.getLong("UID");
                String name = resultSet.getString("NAME");
                int age = resultSet.getInt("AGE");

                obj.setUid(uid);
                obj.setName(name);
                obj.setAge(age);
                personList.add(obj);
                //System.out.println(obj);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return personList;
    }
}

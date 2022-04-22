


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        try (Statement statement = Util.getConnection()) {
            statement.executeUpdate("CREATE TABLE if not exists users (" +
                    "id MEDIUMLONG not null AUTO_INCREMENT, " +
                    "name VARCHAR (30) not null , " +
                    "lastName VARCHAR (30) not null, " +
                    "age BYTE not null" +
                    "primary key (id))");
        } catch (ClassNotFoundException s) {
            System.out.printf("Driver is not installed");
        } catch (SQLException s) {
            System.out.printf("Do not have access to DB");
        }
    }

    public void dropUsersTable() {
        try (Statement statement = Util.getConnection()) {
            statement.executeUpdate("drop table users");
        } catch (ClassNotFoundException s) {
            System.out.printf("Driver is not installed");
        } catch (SQLException s) {
            System.out.printf("Do not have access to DB");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Statement statement = Util.getConnection()) {
            statement.executeUpdate("insert into users ," +
                    "(name, lastName, age) values " +
                    "(name, lastName, age)");
        } catch (ClassNotFoundException s) {
            System.out.printf("Driver is not installed");
        } catch (SQLException s) {
            System.out.printf("Do not have access to DB");
        }
    }

    public void removeUserById(long id) {
        try (Statement statement = Util.getConnection()) {
            statement.execute("delete from users" +
                    "where id = id");
        } catch (ClassNotFoundException s) {
            System.out.printf("Driver is not installed");
        } catch (SQLException s) {
            System.out.printf("Do not have access to DB");
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try (Statement statement = Util.getConnection()) {
            ResultSet resultSet = statement.executeQuery("select  * from users");
            while (resultSet.next()) {
                list.add(new User(resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getByte("age")));
            }
        } catch (ClassNotFoundException s) {
            System.out.printf("Driver is not installed");
        } catch (SQLException s) {
            System.out.printf("Do not have access to DB");
        }
        return null;
    }

    public void cleanUsersTable() {
        try (Statement statement = Util.getConnection()) {
            statement.executeUpdate("delete from * users");
        } catch (ClassNotFoundException s) {
            System.out.printf("Driver is not installed");
        } catch (SQLException s) {
            System.out.printf("Do not have access to DB");
        }
    }
}

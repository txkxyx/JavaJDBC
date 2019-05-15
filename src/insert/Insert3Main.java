package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert3Main {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/development?useSSL=false&serverTimezone=JST";
		String user = "root";
		String password = "";

		try (Connection connection = DriverManager.getConnection(url, user, password)) {

			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into t_project(pno,eno,rno) values (?,?,?);");
			preparedStatement.setInt(1, 4);
			preparedStatement.setInt(2, 1);
			preparedStatement.setInt(3, 10);
			preparedStatement.executeUpdate();

			preparedStatement.clearParameters();

			preparedStatement.setInt(1, 4);
			preparedStatement.setInt(2, 3);
			preparedStatement.setInt(3, 20);
			preparedStatement.executeUpdate();

			preparedStatement.clearParameters();

			preparedStatement.setInt(1, 4);
			preparedStatement.setInt(2, 9);
			preparedStatement.setInt(3, 30);
			preparedStatement.executeUpdate();

			preparedStatement.clearParameters();

			preparedStatement.setInt(1, 4);
			preparedStatement.setInt(2, 11);
			preparedStatement.setInt(3, 40);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

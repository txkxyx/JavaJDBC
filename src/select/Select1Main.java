package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select1Main {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/development?useSSL=false&serverTimezone=JST";
		String user = "root";
		String password = "";

		try (Connection connection = DriverManager.getConnection(url, user, password)) {

			PreparedStatement preparedStatement = connection.prepareStatement(
					"select ename, salary from m_employee where ename like '%A' order by salary desc;");

			ResultSet resultSet = preparedStatement.executeQuery();

			System.out.println("| ename | salary | \n|-------|--------|");
			while (resultSet.next()) {
				String ename = resultSet.getString("ename");
				int salary = resultSet.getInt("salary");
				System.out.println("| " + ename + " | " + salary + " |");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

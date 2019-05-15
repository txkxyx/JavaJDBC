package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select2Main {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/development?useSSL=false&serverTimezone=JST";
		String user = "root";
		String password = "";

		try (Connection connection = DriverManager.getConnection(url, user, password)) {

			PreparedStatement preparedStatement = connection
					.prepareStatement("select avg(salary) as average from m_employee where hire_date >= '2000/1/1';");

			ResultSet resultSet = preparedStatement.executeQuery();

			System.out.println("| average |\n|--------|");
			while (resultSet.next()) {
				float average = resultSet.getFloat("average");
				System.out.println("| " + average + " | ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

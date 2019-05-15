package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Question1Main {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/development?useSSL=false&serverTimezone=JST";
		String user = "root";
		String password = "";

		try (Connection connection = DriverManager.getConnection(url, user, password)) {

			System.out.println("Connection Success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

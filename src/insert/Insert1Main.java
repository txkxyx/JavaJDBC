package insert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Insert1Main {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/development?useSSL=false&serverTimezone=JST";
		String user = "root";
		String password = "";

		try (Connection connection = DriverManager.getConnection(url, user, password)) {

			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into m_employee(eno,ename,hire_date,salary,address) values (?,?,?,?,?);");
			preparedStatement.setInt(1, 11);
			preparedStatement.setString(2, "SATO");
			preparedStatement.setDate(3, Date.valueOf(LocalDate.now()));
			preparedStatement.setInt(4, 300000);
			preparedStatement.setString(5, "Tokyo");

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

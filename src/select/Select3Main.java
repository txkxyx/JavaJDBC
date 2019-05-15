package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select3Main {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/development?useSSL=false&serverTimezone=JST";
		String user = "root";
		String password = "";

		try (Connection connection = DriverManager.getConnection(url, user, password)) {

			PreparedStatement preparedStatement = connection.prepareStatement(
					"select pname, ename, rname from t_project join m_employee on t_project.eno = m_employee.eno inner join m_project on t_project.pno = m_project.pno inner join m_role on t_project.rno = m_role.rno order by t_project.pno desc, t_project.rno asc;");

			ResultSet resultSet = preparedStatement.executeQuery();

			System.out.println("| pname | ename | rname |\n|--------|--------|--------|");
			while (resultSet.next()) {
				String pname = resultSet.getString("pname");
				String ename = resultSet.getString("ename");
				String rname = resultSet.getString("rname");
				System.out.println("| " + pname + " | " + ename + " | " + rname + " | ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

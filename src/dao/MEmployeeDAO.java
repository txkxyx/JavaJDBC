package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MEmployeeDAO {
	protected Connection connection;

	public MEmployeeDAO(Connection connection) {
		this.connection = connection;
	}

	public List<MEmployee> findAll() throws SQLException {
		try (PreparedStatement preparedStatement = connection.prepareStatement("select * from m_employee;")) {
			ResultSet resultSet = preparedStatement.executeQuery();
			List<MEmployee> employeeList = new ArrayList<>();
			while (resultSet.next()) {
				MEmployee mEmployee = new MEmployee(resultSet.getInt("eno"), resultSet.getString("ename"),
						resultSet.getDate("hire_date"), resultSet.getInt("salary"), resultSet.getString("address"));
				employeeList.add(mEmployee);

			}
			return employeeList;
		}
	}

	public MEmployee findByPrimaryKey(int eno) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("select * from m_employee where pno = ?;")) {
			preparedStatement.setInt(1, eno);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				MEmployee mEmployee = new MEmployee(resultSet.getInt("eno"), resultSet.getString("ename"),
						resultSet.getDate("hire_date"), resultSet.getInt("salary"), resultSet.getString("address"));
				return mEmployee;
			}
			throw new DataNoFoundException();
		}
	}

	public int create(MEmployee mEmployee) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("insert into m_employee(eno,ename,hire_date,salary,address) values (?,?,?,?,?);")) {
			preparedStatement.setInt(1, mEmployee.getEno());
			preparedStatement.setString(2, mEmployee.getEname());
			preparedStatement.setDate(3, mEmployee.getHire_date());
			preparedStatement.setInt(4, mEmployee.getSalary());
			preparedStatement.setString(5, mEmployee.getAddress());

			int count = preparedStatement.executeUpdate();

			return count;
		}
	}

	public int update(MEmployee mEmployee, int eno) throws SQLException {
		try (PreparedStatement preparedStatement = connection.prepareStatement(
				"update m_employee set eno = ?,ename = ?,hire_date = ?,salary = ?,address = ? where eno = ?;")) {
			preparedStatement.setInt(1, mEmployee.getEno());
			preparedStatement.setString(2, mEmployee.getEname());
			preparedStatement.setDate(3, mEmployee.getHire_date());
			preparedStatement.setInt(4, mEmployee.getSalary());
			preparedStatement.setString(5, mEmployee.getAddress());
			preparedStatement.setInt(6, eno);

			int count = preparedStatement.executeUpdate();

			return count;
		}
	}

	public int delete(int eno) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("delete from m_employee where eno = ?;")) {
			preparedStatement.setInt(1, eno);

			int count = preparedStatement.executeUpdate();

			return count;
		}
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MProjectDAO {
	protected Connection connection;

	public MProjectDAO(Connection connection) {
		this.connection = connection;
	}

	public List<MProject> findAll() throws SQLException {
		try (PreparedStatement preparedStatement = connection.prepareStatement("select * from m_project;")) {
			ResultSet resultSet = preparedStatement.executeQuery();
			List<MProject> mprojectList = new ArrayList<>();
			while (resultSet.next()) {
				MProject mProject = new MProject(resultSet.getInt("pno"), resultSet.getString("pname"));
				mprojectList.add(mProject);

			}
			return mprojectList;
		}
	}

	public MProject findByPrimaryKey(int pno) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("select * from  m_project where pno = ?;")) {
			preparedStatement.setInt(1, pno);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				MProject mProject = new MProject(resultSet.getInt("pno"), resultSet.getString("pname"));
				return mProject;
			}
			throw new DataNoFoundException();
		}
	}

	public int create(MProject mProject) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("insert into m_project(pno,pname) values (?,?);")) {
			preparedStatement.setInt(1, mProject.getPno());
			preparedStatement.setString(2, mProject.getPname());
			int count = preparedStatement.executeUpdate();

			return count;
		}
	}

	public int update(MProject mProject, int pno) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("update m_project set pno = ?,pname = ? where pno = ?;")) {
			preparedStatement.setInt(1, mProject.getPno());
			preparedStatement.setString(2, mProject.getPname());
			preparedStatement.setInt(3, pno);

			int count = preparedStatement.executeUpdate();

			return count;
		}
	}

	public int delete(int pno) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("delete from m_project where pno = ?;")) {
			preparedStatement.setInt(1, pno);

			int count = preparedStatement.executeUpdate();

			return count;
		}
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TProjectDAO {
	protected Connection connection;

	public TProjectDAO(Connection connection) {
		this.connection = connection;
	}

	public List<TProject> findAll() throws SQLException {
		try (PreparedStatement preparedStatement = connection.prepareStatement("select * from t_project;")) {
			ResultSet resultSet = preparedStatement.executeQuery();
			List<TProject> tProjectList = new ArrayList<>();
			while (resultSet.next()) {
				TProject tProject = new TProject(resultSet.getInt("id"), resultSet.getInt("pno"),
						resultSet.getInt("eno"), resultSet.getInt("rno"));
				tProjectList.add(tProject);

			}
			return tProjectList;
		}
	}

	public TProject findByPrimaryKey(int id) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("select * from  t_project where id = ?;")) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				TProject tProject = new TProject(resultSet.getInt("id"), resultSet.getInt("pno"),
						resultSet.getInt("eno"), resultSet.getInt("rno"));
				return tProject;
			}
			throw new DataNoFoundException();
		}
	}

	public List<TProject> findByPno(int pno) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("select * from  t_project where pno = ?;")) {
			preparedStatement.setInt(1, pno);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<TProject> tProjectList = new ArrayList<>();
			while (resultSet.next()) {
				TProject tProject = new TProject(resultSet.getInt("id"), resultSet.getInt("pno"),
						resultSet.getInt("eno"), resultSet.getInt("rno"));
				tProjectList.add(tProject);
			}
			return tProjectList;
		}
	}

	public int create(TProject tProject) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("insert into t_project(pno,eno,rno) values (?,?,?);")) {
			preparedStatement.setInt(1, tProject.getPno());
			preparedStatement.setInt(2, tProject.getEno());
			preparedStatement.setInt(3, tProject.getRno());
			int count = preparedStatement.executeUpdate();

			return count;
		}
	}

	public int update(TProject tProject, int id) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("update t_project set pno = ?,eno = ?,rno = ? where id = ?;")) {
			preparedStatement.setInt(1, tProject.getPno());
			preparedStatement.setInt(2, tProject.getEno());
			preparedStatement.setInt(3, tProject.getRno());
			preparedStatement.setInt(4, id);

			int count = preparedStatement.executeUpdate();

			return count;
		}
	}

	public int delete(int rno) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("delete from t_project where rno = ?;")) {
			preparedStatement.setInt(1, rno);

			int count = preparedStatement.executeUpdate();

			return count;
		}
	}
}

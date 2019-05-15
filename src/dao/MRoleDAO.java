package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MRoleDAO {

	protected Connection connection;

	public MRoleDAO(Connection connection) {
		this.connection = connection;
	}

	public List<MRole> findAll() throws SQLException {
		try (PreparedStatement preparedStatement = connection.prepareStatement("select * from m_project;")) {
			ResultSet resultSet = preparedStatement.executeQuery();
			List<MRole> mRoleList = new ArrayList<>();
			while (resultSet.next()) {
				MRole mRole = new MRole(resultSet.getInt("rno"), resultSet.getString("rname"));
				mRoleList.add(mRole);

			}
			return mRoleList;
		}
	}

	public MRole findByPrimaryKey(int rno) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("select * from  m_project where rno = ?;")) {
			preparedStatement.setInt(1, rno);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				MRole mRole = new MRole(resultSet.getInt("rno"), resultSet.getString("rname"));
				return mRole;
			}
			throw new DataNoFoundException();
		}
	}

	public int create(MRole mRole) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("insert into m_project(rno,rname) values (?,?);")) {
			preparedStatement.setInt(1, mRole.getRno());
			preparedStatement.setString(2, mRole.getRname());
			int count = preparedStatement.executeUpdate();

			return count;
		}
	}

	public int update(MRole mRole, int rno) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("update m_project set rno = ?,rname = ? where rno = ?;")) {
			preparedStatement.setInt(1, mRole.getRno());
			preparedStatement.setString(2, mRole.getRname());
			preparedStatement.setInt(3, rno);

			int count = preparedStatement.executeUpdate();

			return count;
		}
	}

	public int delete(int rno) throws SQLException {
		try (PreparedStatement preparedStatement = connection
				.prepareStatement("delete from m_project where rno = ?;")) {
			preparedStatement.setInt(1, rno);

			int count = preparedStatement.executeUpdate();

			return count;
		}
	}

}

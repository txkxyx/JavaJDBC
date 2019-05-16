package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
	static final String URL = "jdbc:mysql://localhost:3306/development?useSSL=false&serverTimezone=JST";
	static final String USER = "root";
	static final String PASSWORD = "";

	public static void main(String[] args) {

		MEmployee[] mEmployeeList = { new MEmployee(12, "OKADA", Date.valueOf("2016-09-21"), 300000, "Osaka"),
				new MEmployee(13, "YAMAGUCHI", Date.valueOf("2017-12-14"), 280000, "Hyogo"),
				new MEmployee(14, "KATAOKA", Date.valueOf("2018-03-02"), 240000, "Ishikawa") };
		MProject[] mProjectList = { new MProject(5, "Python Project"), new MProject(6, "IoTProject") };
		TProject[] tProjectList = { new TProject(5, 5, 10), new TProject(5, 6, 20), new TProject(5, 9, 30),
				new TProject(5, 12, 40), new TProject(6, 2, 10), new TProject(6, 3, 20), new TProject(6, 14, 30),
				new TProject(6, 13, 40) };

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			connection.setAutoCommit(false);

			try {
				MEmployeeDAO mEmployeeDAO = new MEmployeeDAO(connection);
				for (MEmployee mEmployee : mEmployeeList) {
					mEmployeeDAO.create(mEmployee);
				}

				MProjectDAO mProjectDAO = new MProjectDAO(connection);
				for (MProject mProject : mProjectList) {
					mProjectDAO.create(mProject);
				}

				connection.commit();

				TProjectDAO tProjectDAO = new TProjectDAO(connection);
				for (TProject tProject : tProjectList) {
					tProjectDAO.create(tProject);
				}
				connection.commit();

				List<TProject> t5Projects = tProjectDAO.findByPno(5);
				showTProject(t5Projects);
				List<TProject> t6Projects = tProjectDAO.findByPno(6);
				showTProject(t6Projects);

			} catch (SQLException e) {
				connection.rollback();
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void showTProject(List<TProject> tProjects) {
		System.out.println(" id | pno | eno | rno |");
		System.out.println("-----------------------");
		for (TProject tProject : tProjects) {
			System.out.printf(" %2d | %3d | %3d | %3d |\n", tProject.getId(), tProject.getPno(), tProject.getEno(),
					tProject.getRno());
		}
		System.out.println();
	}
}

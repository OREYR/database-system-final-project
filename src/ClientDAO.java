package net.insurancemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.insurancemanagement.model.Client;


public class ClientDAO {
	
	String jdbcURL = "jdbc:mysql://127.0.0.1:3306/insurance_claim?useSSL=false";
	String jdbcUsername = "root";
    	String jdbcPassword = "20220421";
	
	private static final String INSERT_CLIENT_SQL = "INSERT INTO client" + "  (lastName, firstName, middleInitial,"
			+ "birthDate, age, gender, ssn, mailAddress, fraudRate) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_CLIENT_BY_ID = "select id, lastName, firstName, middleInitial,"
			+ "birthDate, age, gender, ssn, mailAddress, fraudRate from client where id =?";
	private static final String SELECT_ALL_CLIENTS = "select * from client";
	private static final String DELETE_CLIENT_SQL = "delete from client where id = ?;";
	private static final String UPDATE_CLIENT_BY_ID = "update client set lastName = ?, firstName = ?, middleInitial = ?, "
			+ "birthDate = ?, age = ?, gender = ?, ssn = ?, mailAddress = ?,  fraudRate = ? where id = ?;";
	
	public ClientDAO() {
	}
			

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertClient(Client client) throws SQLException {
		System.out.println(INSERT_CLIENT_SQL);
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL)) {
			preparedStatement.setString(1, client.getLastName());
			preparedStatement.setString(2, client.getFirstName());
			preparedStatement.setString(3, client.getMiddleInitial());
			preparedStatement.setString(4, client.getBirthDate());
			preparedStatement.setInt(5, client.getAge());
			preparedStatement.setString(6, client.getGender());
			preparedStatement.setString(7, client.getSsn());
			preparedStatement.setString(8, client.getMailAddress());
			preparedStatement.setDouble(9, client.getFraudRate());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Client selectClientByID(int id) {
		Client client = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				String middleInitial = rs.getString("middleInitial");
				String birthDate = rs.getString("birthDate");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String ssn = rs.getString("ssn");
				String mailAddress = rs.getString("mailAddress");
				Double fraudRate = rs.getDouble("fraudRate");
				client = new Client(id, lastName, firstName, middleInitial,
						birthDate, age, gender, ssn, mailAddress, fraudRate);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return client;
	}
	

	public List<Client> selectAllClients() {

		
		List<Client> clients = new ArrayList<>();
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENTS);) {
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

	
			while (rs.next()) {
				int id = rs.getInt("id");
				String lastName = rs.getString("lastName");
				String firstName = rs.getString("firstName");
				String middleInitial = rs.getString("middleInitial");
				String birthDate = rs.getString("birthDate");
				int age= rs.getInt("age");
				String gender = rs.getString("gender");
				String ssn = rs.getString("ssn");
				String mailAddress = rs.getString("mailAddress");
				Double fraudRate = rs.getDouble("fraudRate");
				
				clients.add(new Client(id, lastName, firstName, middleInitial,
						birthDate, age, gender, ssn, mailAddress, fraudRate));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return clients;
	}

	public boolean deleteClient(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateClient(Client client) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENT_BY_ID);) {
			statement.setString(1, client.getLastName());
			statement.setString(2, client.getFirstName());
			statement.setString(3, client.getMiddleInitial());
			statement.setString(4, client.getBirthDate());
			statement.setInt(5, client.getAge());
			statement.setString(6, client.getGender());
			statement.setString(7, client.getSsn());
			statement.setString(8, client.getMailAddress());
			statement.setDouble(9, client.getFraudRate());
			statement.setInt(10, client.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}

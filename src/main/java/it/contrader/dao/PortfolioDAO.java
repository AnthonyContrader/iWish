package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Portfolio;



public class PortfolioDAO implements DAO<Portfolio> {
	
	private final String QUERY_ALL = "SELECT * FROM portfolio";
	private final String QUERY_CREATE = "INSERT INTO portfolio (totalmoney, revenue, outputs) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM portfolio WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE portfolio SET totalmoney=?, revenue=?, outputs=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM portfolio WHERE id=?";

	public PortfolioDAO() {

}
	public List<Portfolio> getAll() {
		List<Portfolio> portfolioList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Portfolio portfolio;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				float totalmoney = resultSet.getFloat("totalmoney");
				float revenue = resultSet.getFloat("revenue");
				float outputs = resultSet.getFloat("outputs");
				portfolio = new Portfolio(totalmoney, revenue, outputs);
				portfolio.setId(id);
				portfolioList.add(portfolio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return portfolioList;
	}

	public boolean insert(Portfolio portfolioToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setFloat(1, portfolioToInsert.getTotalmoney());
			preparedStatement.setFloat(2, portfolioToInsert.getRevenue());
			preparedStatement.setFloat(3, portfolioToInsert.getOutputs());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Portfolio read(int portfolioId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, portfolioId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			float totalmoney, revenue, outputs;

			totalmoney = resultSet.getFloat("totalmoney");
			revenue = resultSet.getFloat("revenue");
			outputs = resultSet.getFloat("outputs");
			Portfolio portfolio = new Portfolio(totalmoney, revenue, outputs);
			portfolio.setId(resultSet.getInt("id"));

			return portfolio;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Portfolio portfolioToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (portfolioToUpdate.getId() == 0)
			return false;

		Portfolio portfolioRead = read(portfolioToUpdate.getId());
		if (!portfolioRead.equals(portfolioToUpdate)) {
			try {
				// Fill the portfolioToUpdate object
				if (portfolioToUpdate.getTotalmoney() == 0)  {
					portfolioToUpdate.setTotalmoney(portfolioRead.getTotalmoney());
				}

				if (portfolioToUpdate.getRevenue() == 0)   {
					portfolioToUpdate.setRevenue(portfolioRead.getRevenue());
				}

				if (portfolioToUpdate.getOutputs() == 0) {
					portfolioToUpdate.setOutputs(portfolioRead.getOutputs());
				}

				// Update the portfolio
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setFloat(1, portfolioToUpdate.getTotalmoney());
				preparedStatement.setFloat(2, portfolioToUpdate.getRevenue());
				preparedStatement.setFloat(3, portfolioToUpdate.getOutputs());
				preparedStatement.setInt(4, portfolioToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
}


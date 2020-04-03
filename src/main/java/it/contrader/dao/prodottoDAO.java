package it.contrader.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Prodotto;

public class prodottoDAO {

	private final String QUERY_ALL = "SELECT * FROM prodotto";
	private final String QUERY_CREATE = "INSERT INTO prodotto (name, description, price, priority) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM prodotto WHERE id=?";
	private final String QUERY_UPDATE ="UPDATE prodotto SET name=?, description=?, price=?, priority=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM prodotto WHERE id=?";
	
	public prodottoDAO() {
		
	}
	
	public List<Prodotto> getAll() {
		List<Prodotto> prodottoList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Prodotto prodotto;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				float price = resultSet.getFloat("price");
				int priority = resultSet.getInt("priority");
				prodotto = new Prodotto(name, description, price, priority);
				prodotto.setId(id);
				prodottoList.add(prodotto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodottoList;
	}
	
	public boolean insert(Prodotto prodottoToInsert ) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, prodottoToInsert.getName());
			preparedStatement.setString(2, prodottoToInsert.getDescription());
			preparedStatement.setLong(3, (long) prodottoToInsert.getPrice());
			preparedStatement.setLong(4, prodottoToInsert.getPriority());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public Prodotto read(int prodottoId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, prodottoId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, description;
			float price;
			int priority;

			name = resultSet.getString("name");
			description = resultSet.getString("description");
			price = resultSet.getFloat("price");
			priority = resultSet.getInt("priority");
			Prodotto prodotto = new Prodotto(name, description, price, priority);
			prodotto.setId(resultSet.getInt("id"));
			return prodotto;
		} catch (SQLException e) {
			return null;
		}
		
	}
	
	public boolean update(Prodotto prodottoToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (prodottoToUpdate.getId() == 0)
			return false;

		Prodotto prodottoRead = read(prodottoToUpdate.getId());
		if (!prodottoRead.equals(prodottoToUpdate)) {
			try {
				// Riempi prodottoToUpdate object
				if (prodottoToUpdate.getName() == null || prodottoToUpdate.getName().equals("")) {
					prodottoToUpdate.setName(prodottoRead.getName());
				}
				
				if (prodottoToUpdate.getDescription() == null || prodottoToUpdate.getDescription().equals("")) {
				prodottoToUpdate.setDescription(prodottoRead.getDescription());

				}
				if (prodottoToUpdate.getPrice() < 0) {
					prodottoToUpdate.setPrice(prodottoRead.getPrice());
				}

				if (prodottoToUpdate.getPriority() <= 0) {
					prodottoToUpdate.setPriority(prodottoRead.getPriority());
				}

				// Update Prodotto
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, prodottoToUpdate.getName());
				preparedStatement.setString(2, prodottoToUpdate.getDescription());
				preparedStatement.setFloat(3, prodottoToUpdate.getPrice());
				preparedStatement.setInt(4, prodottoToUpdate.getPriority());
				preparedStatement.setInt(5, prodottoToUpdate.getId());
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

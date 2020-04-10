package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Prodotto;

public class ProdottoDAO implements DAO<Prodotto> {

	private final String QUERY_ALL = "SELECT * FROM prodotto";
	private final String QUERY_CREATE = "INSERT INTO prodotto (name, description, price, priority, proprietario, categoria, wishlist_id) VALUES (?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM prodotto WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE prodotto SET name=?, description=?, price=?, priority=?, categoria=?, wishlist_id=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM prodotto WHERE id=?";
	
	public ProdottoDAO() {
		
	}
	
	public List<Prodotto> getAll() {
		List<Prodotto> prodottiList = new ArrayList<>();
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
				String proprietario = resultSet.getString("proprietario");
				int id_categoria_fk = resultSet.getInt("categoria");
				int id_whishlist_fk = resultSet.getInt("wishlist_id");
				prodotto = new Prodotto(name, description, price, priority, proprietario, id_categoria_fk, id_whishlist_fk);
				prodotto.setId(id);
				prodottiList.add(prodotto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodottiList;
	}
	
	public boolean insert(Prodotto prodottoToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, prodottoToInsert.getName());
			preparedStatement.setString(2, prodottoToInsert.getDescription());
			preparedStatement.setFloat(3, prodottoToInsert.getPrice());
			preparedStatement.setInt(4, prodottoToInsert.getPriority());
			preparedStatement.setString(5, prodottoToInsert.getProprietario());
			if (prodottoToInsert.getId_categoria_fk() == null)
				{
				preparedStatement.setNull(6, java.sql.Types.NULL);
				} else {
			preparedStatement.setInt(6, prodottoToInsert.getId_categoria_fk());}
			if (prodottoToInsert.getId_whishlist_fk() == null)
			{
			preparedStatement.setNull(7, java.sql.Types.NULL);
			} else {
			preparedStatement.setInt(7, prodottoToInsert.getId_whishlist_fk());}
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
			Float price;
			Integer priority;
			String proprietario;
			Integer id_categoria_fk;
			Integer id_wishlist_fk;
			name = resultSet.getString("name");
			description = resultSet.getString("description");
			price = resultSet.getFloat("price");
			priority = resultSet.getInt("priority");
			proprietario = resultSet.getString("proprietario");
			id_categoria_fk = resultSet.getInt("categoria");
			id_wishlist_fk = resultSet.getInt("wishlist_id");
			
			Prodotto prodotto = new Prodotto(name, description, price, priority, proprietario, id_categoria_fk, id_wishlist_fk);
			prodotto.setId(resultSet.getInt("id"));
			
			return prodotto;
		} catch (SQLException e) {
			return null;
		}
	}
	
	public boolean update(Prodotto prodottoToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if (prodottoToUpdate.getId() == 0)
			return false;
		
		Prodotto prodottoRead = read(prodottoToUpdate.getId());
		if (!prodottoRead.equals(prodottoToUpdate)) {
			try {
				if (prodottoToUpdate.getName() == null || prodottoToUpdate.getName().contentEquals("")) {
					prodottoToUpdate.setName(prodottoRead.getName());
				}
				
				if (prodottoToUpdate.getDescription() == null || prodottoToUpdate.getDescription().contentEquals("")) {
					prodottoToUpdate.setDescription(prodottoRead.getDescription());
				}
				
				if (prodottoToUpdate.getPrice() <0) {
					prodottoToUpdate.setPrice(prodottoRead.getPrice());
				}
				
				if (prodottoToUpdate.getPriority()  == 0) {
					prodottoToUpdate.setPriority(prodottoRead.getPriority());
				}
				
//				if (prodottoToUpdate.getId_categoria_fk()  == null) {
//					prodottoToUpdate.setId_categoria_fk(prodottoRead.getId_categoria_fk());
//				}
//				
//				if (prodottoToUpdate.getId_categoria_fk()  == null) {
//					prodottoToUpdate.setId_whishlist_fk(prodottoRead.getId_whishlist_fk());
//				}
				
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, prodottoToUpdate.getName());
				preparedStatement.setString(2, prodottoToUpdate.getDescription());
				preparedStatement.setFloat(3, prodottoToUpdate.getPrice());
				preparedStatement.setInt(4, prodottoToUpdate.getPriority());
				if (prodottoToUpdate.getId_categoria_fk() == null)
					{
						preparedStatement.setNull(5, java.sql.Types.NULL);
					} else {
				preparedStatement.setInt(5, prodottoToUpdate.getId_categoria_fk());}
				if (prodottoToUpdate.getId_whishlist_fk() == null)
				{
					preparedStatement.setNull(6, java.sql.Types.NULL);
				} else {
				preparedStatement.setInt(6, prodottoToUpdate.getId_whishlist_fk());}
				preparedStatement.setInt(7, prodottoToUpdate.getId());
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


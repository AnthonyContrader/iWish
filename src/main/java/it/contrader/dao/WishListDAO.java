package it.contrader.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import it.contrader.model.WishList;
import it.contrader.utils.ConnectionSingleton;

public class WishListDAO implements DAO<WishList> {
	private final String QUERY_ALL = "SELECT * FROM WishList";
	private final String QUERY_CREATE = "INSERT INTO WishList (name, description, proprietario) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM WishList WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE WishList SET name=?, description=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM WishList WHERE id=?";
	
	public WishListDAO() {}
	
	public List<WishList> getAll(){
		List<WishList> wishlistList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			WishList wishlist;
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				String proprietario = resultSet.getString("proprietario");
				wishlist = new WishList(name, description, proprietario);
				wishlist.setId(id);
				wishlistList.add(wishlist);
				}
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return wishlistList;
	}
	
	public boolean insert(WishList wishlistToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, wishlistToInsert.getName());
			preparedStatement.setString(2, wishlistToInsert.getDescription());
			preparedStatement.setString(3, wishlistToInsert.getProprietario());
			preparedStatement.execute();
			return true;
		}catch(SQLException e) {
			return false;
		}
	}
	
	public WishList read(int wishlistId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, wishlistId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, description, proprietario;
			name = resultSet.getString("name");
			description = resultSet.getString("description");
			proprietario = resultSet.getString("proprietario");
			WishList wishlist = new WishList(name, description, proprietario);
			wishlist.setId(resultSet.getInt("id"));
			return wishlist;
		}catch(SQLException e) {
			return null;
		}
		
	}
	
	public boolean update(WishList wishlistToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if(wishlistToUpdate.getId()==0) {
			return false;
		}
		WishList wishlistRead = read(wishlistToUpdate.getId());
		
		
		if(!wishlistRead.equals(wishlistToUpdate)) {
		try {
			
			if(wishlistToUpdate.getName()==null || wishlistToUpdate.getName().equals("")) {
				wishlistToUpdate.setName(wishlistRead.getName());
			}
			
			if(wishlistToUpdate.getDescription()==null || wishlistToUpdate.getDescription().equals("")) {
				wishlistToUpdate.setDescription(wishlistRead.getDescription());
			}
			
			PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setString(1, wishlistToUpdate.getName());
			preparedStatement.setString(2, wishlistToUpdate.getDescription());
			preparedStatement.setInt(3, wishlistToUpdate.getId());
			int a = preparedStatement.executeUpdate();
			if(a>0) return true;
			
			else	return false;
			
		}catch(SQLException e) {
			return false;}
		}
		return false;
	}
	
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if(n!=0)
				return true;
			
		}catch(SQLException e) {}
		return false;
	}
	
}

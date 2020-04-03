package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.WishList;

/**
 * @author Francesco
 */

public class WishListDAO {
	
	private final String QUERY_ALL = "SELECT * FROM wishlist";
	private final String QUERY_CREATE = "INSERT INTO wishlist (name, description) VALUES (?, ?)";
	private final String QUERY_READ = "SELECT * FROM wishlist WHERE id = ?";
	private final String QUERY_UPDATE = "UPDATE wishlist SET name = ?, description = ?  WHERE id = ?";
	private final String QUERY_DELETE = "DELETE FROM wishlist WHERE id = ?";
	
	public WishListDAO() {}
	
	public List<WishList> getAll()
	{
		List<WishList> wishLists = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			WishList wishList;
			while(resultSet.next()) 
			{
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				
				wishList = new WishList(name, description);
				wishList.setId(id);
				wishLists.add(wishList);
				
				
			}
			
		} catch(SQLException e) 
		{
			e.printStackTrace();
		}
		
		return wishLists;
	}
	
	public boolean insert(WishList wishlistToInsert)
	{
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, wishlistToInsert.getName());
			preparedStatement.setString(2, wishlistToInsert.getDescription());
			preparedStatement.execute();
			return true;
		}catch(SQLException e) {
			return false;
		}
		
	}
	
	public  WishList read(int wishlistId) 
	{
		Connection connection = ConnectionSingleton.getInstance();
		try
		{
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
		preparedStatement.setInt(1, wishlistId);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		String name, description;
		
		name = resultSet.getString("name");
		description = resultSet.getString("description");
		
		WishList wishlist = new WishList(name, description);
		wishlist.setId(resultSet.getInt("id"));
		return wishlist;
		}catch(SQLException e) {
			return null;
		}
	}
	
	//UPDATE
	public boolean update(WishList wishlistToUpdate) 
	{
		Connection connection = ConnectionSingleton.getInstance();
		
		if(wishlistToUpdate.getId() == 0) 
		{
			return false;
		}
		
		WishList wishlistRead = read(wishlistToUpdate.getId());
		if(!wishlistRead.equals(wishlistToUpdate)) {
			try {
				//If a field is null or empty, this field is not edited
				if(wishlistToUpdate.getName() == null || wishlistToUpdate.getName().contentEquals("")) 
				{
					wishlistToUpdate.setName(wishlistRead.getName());
				}
				if(wishlistToUpdate.getDescription() == null || wishlistToUpdate.getDescription().contentEquals("")) 
				{
					wishlistToUpdate.setDescription(wishlistRead.getDescription());
				}
				
				//Update the wishlist
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, wishlistToUpdate.getName());
				preparedStatement.setString(2, wishlistToUpdate.getDescription());
				preparedStatement.setInt(3, wishlistToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if(a>0) return true;
				else return false;
				
			}
			catch(SQLException e) {
				return false;
				}
		}
		return false;
	}
	
	//DELETE
	public boolean delete(int id) 
	{
		Connection connection = ConnectionSingleton.getInstance();
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if(n!=0) return true;
		}
		catch(SQLException e) {}
		return false;
	}
	
	
	
	
	
	
	
	

}

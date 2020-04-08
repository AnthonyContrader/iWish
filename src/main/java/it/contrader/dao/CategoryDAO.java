package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Category;


public class CategoryDAO implements DAO<Category> {
	
	private final String QUERY_ALL = "SELECT * FROM category";
	private final String QUERY_CREATE = "INSERT INTO category (name, description, date, rating, tags) VALUES (?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM category WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE category SET name=?, description=?, date=?, rating=?, tags=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM cateogry WHERE id=?";

	public CategoryDAO() {
		
	}
   
	public List<Category> getAll() {
		List<Category> categoriesList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Category category;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				String date = resultSet.getString("date");
				int rating = resultSet.getInt("rating");
				String tags = resultSet.getString("tags");
				category = new Category(name, description, date, rating, tags);
				category.setId(id);
				categoriesList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoriesList;
	}

	public boolean insert(Category categoryToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, categoryToInsert.getName());
			preparedStatement.setString(2, categoryToInsert.getDescription());
			preparedStatement.setString(3, categoryToInsert.getDate());
			preparedStatement.setInt(4, categoryToInsert.getRating());
			preparedStatement.setString(5, categoryToInsert.getTags());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}
	
	public Category read(int categoryId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, categoryId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, description, date;
			Integer rating;
			String tags;

			name = resultSet.getString("name");
			description = resultSet.getString("description");
			date = resultSet.getString("date");
			rating = resultSet.getInt("rating");
			tags = resultSet.getString("tags");
			Category category = new Category(name, description, date, rating, tags);
			category.setId(resultSet.getInt("id"));

			return category;
		} catch (SQLException e) {
			return null;
		}

	}
	
	public boolean update(Category categoryToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		if (categoryToUpdate.getId() == 0)
			return false;

		Category categoryRead = read(categoryToUpdate.getId());
		if (!categoryRead.equals(categoryToUpdate)) {
			try {
				
				if (categoryToUpdate.getName() == null || categoryToUpdate.getName().equals("")) {
					categoryToUpdate.setName(categoryRead.getName());
				}

				if (categoryToUpdate.getDescription() == null || categoryToUpdate.getDescription().equals("")) {
					categoryToUpdate.setDescription(categoryRead.getDescription());
				}

				if (categoryToUpdate.getDate() == null || categoryToUpdate.getDate().equals("")) {
					categoryToUpdate.setDate(categoryRead.getDate());
				}
				if (categoryToUpdate.getRating() == 0 ) {
					categoryToUpdate.setRating(categoryRead.getRating());
				}

				if (categoryToUpdate.getTags() == null || categoryToUpdate.getTags().equals("")) {
					categoryToUpdate.setTags(categoryRead.getTags());
				}

				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, categoryToUpdate.getName());
				preparedStatement.setString(2, categoryToUpdate.getDescription());
				preparedStatement.setString(3, categoryToUpdate.getDate());
				preparedStatement.setInt(4, categoryToUpdate.getRating());
				preparedStatement.setString(5, categoryToUpdate.getTags());
				preparedStatement.setInt(6, categoryToUpdate.getId());
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
	
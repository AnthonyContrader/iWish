package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Progress;

public class progressDAO {
     
	// query il lignuaggio sql con il modificatore "final" perché non devono essere modificate
	private final String QUERY_ALL = "SELECT * FROM progress";
	private final String QUERY_CREATE = "INSERT INTO progress (cash, time, expectation) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM progress WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE progress SET cash=?, time=?, expectation=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM progress WHERE id=?";


     // costruttore vuoto

	public progressDAO() {
     }
      
     public List<Progress> getAll(){
    	 List<Progress> progressList= new ArrayList<>();  //la lista dei progressi viene associato un array
    	 Connection connection = ConnectionSingleton.getInstance();
    	 try {
    	 Statement statement = connection.createStatement();
    	 ResultSet resultSet = statement.executeQuery(QUERY_ALL);
    	 Progress progress;
    	 while(resultSet.next()) {
    		int id = resultSet.getInt("id");
    		float cash = resultSet.getFloat("cash");
    		double time=resultSet.getDouble("time");
    		double expectation =resultSet.getDouble("expectation");
    		progress = new Progress (time,expectation,cash);
    		progress.setId(id);
    		progressList.add(progress);
    		}
    	 }catch(SQLException e) {
    		e.printStackTrace();
    	 } 
         return progressList;
     }	 
    
    	 
     public boolean insert(Progress progressToInsert) {
    	 Connection connection = ConnectionSingleton.getInstance();
    	 try {
    		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
    		preparedStatement.setDouble(1, progressToInsert.getTime());
    		preparedStatement.setDouble(2, progressToInsert.getExpectation());
    		preparedStatement.setFloat(3, progressToInsert.getCash());
    		preparedStatement.execute();
    		return true;
    		}catch (SQLException e) {
    			return false;
    		}
    	 
    	 
     }
    	 
     public Progress read(int progressId) {
    	 Connection connection = ConnectionSingleton.getInstance();
    	 try {
    		 
    		 PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
    		 preparedStatement.setInt(1,  progressId);
    		 ResultSet resultSet= preparedStatement.executeQuery();
    		 resultSet.next();
    		 double time,expectation;
    		 float cash;
    		 
    		 time= resultSet.getDouble("time");
    		 expectation = resultSet.getDouble("expectation");
    		 cash = resultSet.getFloat("cash");
    		 Progress progress =new Progress ( time, expectation, cash);
    		 progress.setId(resultSet.getInt("id"));
    		  return progress;
    	 } 
    		 
    	 catch (SQLException e) {
 			return null; 
    		 
    		  }
    	 }

 public boolean update(Progress progressToUpdate) {
	 Connection connection= ConnectionSingleton.getInstance();
	 
	 
	 //controlla se id è presente
	 
	 
	 if (progressToUpdate.getId()==0)
		 return false;

	 Progress progressRead = read (progressToUpdate.getId());
	 if(!progressRead.equals(progressToUpdate)) {
		 try {
			 if(progressToUpdate.getTime()==0 ) {
			progressToUpdate.setTime(progressRead.getTime());	 
			 }
			 if(progressToUpdate.getExpectation()==0 ) {
					progressToUpdate.setExpectation(progressRead.getExpectation());	 
					 }
			 if(progressToUpdate.getCash()==0) {
					progressToUpdate.setCash(progressRead.getCash());	 
					 }
		 
			 PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setDouble(1, progressToUpdate.getTime());
				preparedStatement.setDouble(2, progressToUpdate.getExpectation());
				preparedStatement.setFloat(3, progressToUpdate.getCash());
				preparedStatement.setInt(4, progressToUpdate.getId());
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



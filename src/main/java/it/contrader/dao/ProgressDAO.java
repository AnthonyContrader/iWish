package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Progress;

public class ProgressDAO implements DAO<Progress>{

	private final String QUERY_ALL= "SELECT * FROM user";
	private final String QUERY_CREATE="INSERT INTO progress(cash, expectation , time) VALUES (?,?,? )";
	private final String QUERY_READ="SELECT *FROM progress WHERE id=?";
	private final String QUERY_UPDATE ="UPDATE progress SET cash=?,expectation=?,time=?";
	private final String QUERY_DELETE= "DELETE FROM user WHERE id=?";
	
	public ProgressDAO() {
		
	}
	
	public List<Progress> getAll(){
		List<Progress> progressList= new ArrayList<>();
		Connection connection =ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Progress progress;
			while (resultSet.next()){
				int id = resultSet.getInt("id");
	    		float cash = resultSet.getFloat("cash");
	    		double time=resultSet.getDouble("time");
	    		double expectation =resultSet.getDouble("expectation");
				progress = new Progress(cash , expectation, time);
				progress.setId(id);
				progressList.add(progress);
					}
		}catch (SQLException e) {
			e.printStackTrace();
			}
		return progressList;
	}
	
	
    public boolean insert (Progress progressToInsert) {
    	Connection connection = ConnectionSingleton.getInstance();
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
    		preparedStatement.setFloat(1, progressToInsert.getCash());
    		preparedStatement.setDouble(2, progressToInsert.getExpectation());
    		preparedStatement.setDouble(3, progressToInsert.getTime());
    		preparedStatement.execute();
    		return true;
    		}
    	catch(SQLException e) {
    		return false;
    	}
    	
    }

   public Progress read(int progressId) {
	   Connection connection = ConnectionSingleton.getInstance();
	   try {
		   
		   PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
	       preparedStatement.setInt(1,progressId);
	       ResultSet resultSet = preparedStatement.executeQuery();
	       resultSet.next();
	       float cash;
	       double expectation, time;
	       cash= resultSet.getFloat("cash");
	       expectation = resultSet.getDouble("expectation");
	       time= resultSet.getDouble("time");
	       Progress progress = new Progress(cash,expectation, time);
	       progress.setId(resultSet.getInt("id"));
	       return progress;
	   }
   catch (SQLException e) {
	   return null;
	   
   }
   }
   
   public boolean update (Progress progressToUpdate) {
	   Connection connection = ConnectionSingleton.getInstance();
	   if (progressToUpdate.getId()==0)
		   return false;
	   
	   Progress progressRead =read(progressToUpdate.getId());
	   if(!progressRead.equals(progressToUpdate)) {
		   try {
			   if(progressToUpdate.getTime()<=0 )  {
					progressToUpdate.setTime(progressRead.getTime());	 
					 }
			   if(progressToUpdate.getExpectation()<=0|| Double.toString( progressToUpdate.getExpectation()).equals("") ) {
							progressToUpdate.setExpectation(progressRead.getExpectation());	 
							 }
			   if( Float.toString( progressToUpdate.getCash()).equals("")) {
							progressToUpdate.setCash(progressRead.getCash());	 
							 }
			   
			   PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setFloat(1, progressToUpdate.getCash());
				preparedStatement.setDouble(2, progressToUpdate.getExpectation());
				preparedStatement.setDouble(3, progressToUpdate.getTime());
				preparedStatement.setInt(4, progressToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;
		   }
		   catch (SQLException e ) {
			   return false;
		   }
		   
	   }   
	   
         return false;
   }

   public boolean delete (int id) {
	   Connection connection =ConnectionSingleton.getInstance();
	   try {
		   PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
		   preparedStatement.setInt(1,id);
		   int n = preparedStatement.executeUpdate();
		   if(n!=0)
			   return true;
		   
		   
	   }
 
   catch (SQLException e ) {
	  
   }
	   return false ;
   }




}

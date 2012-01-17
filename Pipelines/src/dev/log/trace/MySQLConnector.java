package dev.log.trace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class MySQLConnector {

	private static String DB_USERNAME = "root";
	private static String DB_PASSWORD = "root";
	private static String DB_URL = "jdbc:mysql://localhost/";
	
	private Connection connection = null;
	private String database = "";
	
	public MySQLConnector(String database) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			Statement s = connection.createStatement();
			s.execute(String.format("CREATE DATABASE IF NOT EXISTS %s;",database));
			s.execute(String.format("USE %s;",database));
//			System.out.println("DB connected");
		} catch (SQLException e){
			System.err.println("DB connection failed.");
		} catch (IllegalAccessException e) {
			System.err.println("Driver init failed.");
		} catch (InstantiationException e) {
			System.err.println("Driver init failed.");
		} catch (ClassNotFoundException e) {
			System.err.println("Driver class not found.");
		}
	}
	
	public void dropTable(String table) {
		try {
			Statement s = connection.createStatement();
			s.executeUpdate(String.format("DROP TABLE IF EXISTS %s",table));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createTable(String definition) {
		
		try {
			Statement s = connection.createStatement();
			s.executeUpdate(definition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(String query) {
		
		try {
			Statement s = connection.createStatement();
			s.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<HashMap<String,String>> select(String query) {

		ArrayList<HashMap<String,String>> result = new ArrayList<HashMap<String,String>>();
		try {
			QueryRunner queryRunner = new QueryRunner();
			List list = (List)queryRunner.query(connection, query, new MapListHandler());
			for(int i = 0; i < list.size(); i++){
				Map map = (Map) list.get(i);
				Set keyset = map.keySet();
				HashMap<String,String> hashmap = new HashMap<String,String>();
				for(int k = 0; k < keyset.size(); k++) {
					Object key = keyset.toArray()[k];
					hashmap.put((String)key, (String)map.get(key));
				}
				result.add(hashmap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public void close() {
		if (connection != null) {
			try {
				connection.close();
//				System.out.println("DB closed");
			} catch (SQLException e){
				System.err.println("Error while closing DB");
			}
		}
	}
}

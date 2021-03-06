package dev.log.trace.test;

import java.util.List;
import java.util.Map;

import dev.log.trace.MySQLConnector;


public class TestMySQLConnector{
	
	public static void main(String[] args) {

		MySQLConnector connector = new MySQLConnector("testdatabase");
		
		connector.createTable("CREATE TABLE IF NOT EXISTS testTable ("
               + "column1 INT UNSIGNED NOT NULL AUTO_INCREMENT,"
               + "PRIMARY KEY (column1),"
               + "column2 CHAR(40), column3 CHAR(40))");
		connector.update("INSERT INTO testTable (column2, column3) VALUES ('val2', 'val3');");
		
		List list = connector.select("SELECT column2 FROM testTable;");
		for(int i = 0; i < list.size(); i++) {
			Map item = (Map)list.get(i);
			System.out.println(item.get("column3"));
		}

		connector.dropTable("testTable");
		
		connector.close();
	}
	
}

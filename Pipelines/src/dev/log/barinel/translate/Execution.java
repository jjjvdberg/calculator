package dev.log.barinel.translate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dev.log.barinel.activity.Matrix;
import dev.log.trace.MySQLConnector;

public class Execution {

	private static final String DATABASE_NAME = "service_logging";
	private static final String TABLE_NAME = "trace_point";
	
	private static MySQLConnector connector = new MySQLConnector(DATABASE_NAME);;
	
	private static Matrix a = new Matrix();
	
	public static void addToMatrix(String process, int error) {
	
		List list = connector.select(String.format("SELECT * FROM %s WHERE process_id = '%s'",TABLE_NAME,process));
		ArrayList<String> components = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++){
			Map result = (Map)list.get(i);
			if(!components.contains((String) result.get("service_id"))) components.add((String) result.get("service_id"));
		}
		System.out.println("added "+ components);
		a.addExecution(components, error);
	}
	
	public static Matrix getMatrix() {
		return a;
	}
}

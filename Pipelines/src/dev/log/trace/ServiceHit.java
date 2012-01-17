package dev.log.trace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * A static class which logs information coming from the service. This information
 * defines an involvement of a service in an execution. This involvement might result
 * in a failure which is then also registered. 
 * 
 * @author Joel van den Berg
 *
 */
public class ServiceHit {
	
	/**
	 * The name of the database that will be used to store the data collected from the
	 * web services.
	 */
	private static final String DATABASE_NAME = "service_logging";
	
	/**
	 * The name of the table that will be used to save the information about services
	 * that were involved during an execution.
	 */
	private static final String TABLE_NAME = "service_hit";	
	
	/**
	 * The table name that contains a counter used in the generation of the execution id
	 */
	private static final String TABLE_COUNT_NAME = "service_hit_count";
	
	/**
	 * Logs a service hit to the database.
	 * CREATE TABLE service_hit (id int(10) auto_increment, service_id char(40), interface_id char(40), execution_id char(40), failure TINYINT, PRIMARY KEY (id));
	 * @param service_id Uniquely identifies the service. This is used to see what component was hit during the execution
	 * @param interface_id The operation that was called on the service for a more accurate analysis
	 * @param execution_id Uniquely identifies the execution to group the components that were involved in the execution.
	 * @param failure Boolean that indicates whether the interface of this service participating in the execution 
	 * in this service resulted in a failure.
	 */
	public static void writeToDatabase(String service_id, String interface_id, String execution_id, boolean failure) {
		MySQLConnector connector = new MySQLConnector(DATABASE_NAME);
		
		connector.update(String.format("INSERT INTO %s VALUES (0, '%s', '%s', '%s', '%s');",
				TABLE_NAME,
				service_id,
				interface_id,
				execution_id,
				failure));
		
		int counter = Integer.parseInt(connector.select(String.format("SELECT counter FROM %s WHERE id = 0;",TABLE_COUNT_NAME)).get(0).get("counter"));
		
		connector.update(String.format("UPDATE %s SET counter = %s WHERE counter = %s;",
				TABLE_NAME,
				counter + 1,
				counter));
		
		connector.close();
		
	}
	
	/**
	 * Get the counter currently in the database, this will be used for generating a unique execution id when the service is the first one
	 * to be involved in the execution.
	 * @return The value of the counter
	 */
	public static int getCounter() {
		MySQLConnector connector = new MySQLConnector(DATABASE_NAME);
		
		int counter = Integer.parseInt(connector.select(String.format("SELECT counter FROM %s;",TABLE_COUNT_NAME)).get(0).get("counter"));

		connector.close();
		
		return counter;
	}
	
}

/**
 * 
 */
package org.herb.sandbox.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//import org.apache.log4j.Logger;

import com.hxtt.sql.OpenAPI;

/**
 * @author herb
 * 
 */
public class DBFConnection {
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); // use slf4j
//	private final Logger logger = Logger.getLogger(DBFConnection.class);
	
	private Properties props;
	private Connection conn;

	public DBFConnection(Properties props) {
		this.props = props;
	}

	public void connect() {
		final String dbURL = "jdbc:dbf:/"
				+ props.getProperty("database.directory");

		try {
			conn = DriverManager.getConnection(dbURL);
			logger.info(null == conn ? "Connection not made" : "Success!");

			conn.setAutoCommit(false);
			conn.setReadOnly(true);
			
			// Register our Extended SQL Function
			OpenAPI.registerExtendedFunction("org.herb.sandbox.database.connection.MOGFunctions");
			
		} catch (SQLException sqle) {
			logger.error("SQL error", sqle);
		} catch (Exception ex) {
			logger.error("We have a problem", ex);
		}
	}

	public void runCountQuery(String sql) {

		Statement stmt;
		ResultSet rs;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			int numOfRec = 0;
			while (rs.next()) {
//				numOfRec = rs.getInt(1);
				logger.info(rs.getString(1) + " -- " + rs.getObject(2).getClass());
			}
//			logger.info("# of records: " + numOfRec);
		} catch (SQLException sqle) {
			logger.error("SQL failed", sqle);
		}
	}

}

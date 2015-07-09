/**
 * Based on documentation from HXTT - http://www.hxtt.com/dbf/openapi.html
 */
package org.herb.sandbox.database.connection;

import java.sql.SQLException;
import java.sql.Types;

import com.hxtt.sql.ExtendedFunctionInterface;

/**
 * @author herb
 * 
 */
public class MOGFunctions implements ExtendedFunctionInterface {

	/**
	 * Used to verify whether functionName is supported, and has a correct
	 * prarameter count.
	 * 
	 * @param functionName
	 *            the name of function
	 * @param parameters
	 *            the parameter list of function, which can be null
	 * @return value
	 * @throws SQLException
	 *             if has an incorrect parameter number
	 */
	public boolean isExtendedFunction(String functionName, Object[] parameters)
			throws SQLException {
		if (functionName.equalsIgnoreCase("phd")) {
			if (null != parameters && parameters.length == 4) {
				return true;
			} else {
				throw new SQLException(
						"Invalid parameter value in phd function");
			}
		}
		return false;
	}

	/**
	 * Used to evaluate function value.
	 * 
	 * @param functionName
	 *            the name of function
	 * @param values
	 *            the value list of function, which can be null
	 * @return value
	 * @throws SQLException
	 *             if failed to calculate the function
	 */
	public Object evaluate(String functionName, Object[] parameters)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * Used to get the SQL type of the value that is expected to be returned when evaluate() is called.
     * @param functionName
     * @return the SQL type or Types.NULL if functionName is supported
     */
	public int getType(String functionName) {
		if( functionName.equalsIgnoreCase("phd")) {
			return Types.VARCHAR;
		}
		return Types.NULL;
	}

	 /**
     * Used to get the SQL types of the parameter values that are expected to be returned when evaluate() is called.
     * return null if function hasn't any parameter, or you wish to use the default SQL types.
     * use Types.NULL for that specific parameter if you wish to get the default SQL type.
     * @param functionName
     * @return the SQL type list or null if functionName is supported
     */
	public int[] getParameterTypes(String functionName) {
		if( functionName.equalsIgnoreCase("phd")) {
			return new int[] {
					Types.VARCHAR
			};
		}
		return null;
	}

	/**
     * Used to estimate the maximum number of characters that should be contained in a String returned by evaluate(String functionName,Object[] values).
     * Zero is returned if this value object does not represent Types.VARCHAR, Types.BINARY, Types.LONGVARCHAR, or Types.LONGBINARY.
     * @param functionName
     * @return maximum size
     * @throws SQLException  if functionName is supported
     */
	public int estimateValueSize(String functionName) throws SQLException {
		if( functionName.equalsIgnoreCase("phd")) {
			return 250;
		}
		return 10;
	}

}

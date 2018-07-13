package dao.jdbc;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	private static DataSource dataSource;
	private static final String JNDI_LOOKUP = "java:/comp/env/jdbc/trains";
	static {
		try {
			Context context = new InitialContext();
			Object lookup = context.lookup(JNDI_LOOKUP);
			if (lookup != null) {
				dataSource = (DataSource) lookup;
			} else {
				throw new RuntimeException("datasource not found");
			}

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static DataSource getDataSource() {
		return dataSource;
	}
}

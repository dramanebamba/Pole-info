package pole_info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

	private static Connection c;
	private static String driver, url, login, password;
	private static String strTestTableCreate = "CREATE TABLE IF NOT EXISTS TEST_TABLE"
			+ "(ID INT PRIMARY KEY NOT NULL,"
			+ "NAME VARCHAR(255) NOT NULL,"
			+ "AGE INT NOT NULL)";
	private static PreparedStatement queryTestTableCreate;
	static{		
		try{
			
			System.out.println("Initialisation connexion");
			
			driver = "org.postgresql.Driver";
			Class.forName(driver);
			url = "jdbc:postgresql://127.0.0.1:5432/poleInfoBD";
			login = "postgres";
			password = "0000";

			System.out.println("On va connecter la base");
			c = DriverManager.getConnection(url,login,password);
			
			System.out.println(c.toString());
			
			queryTestTableCreate = c.prepareStatement(strTestTableCreate);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Opened database successfully");
		//c.close();
	}
	
	
	public boolean createTableTest(){
		boolean b = true;
		synchronized(queryTestTableCreate){
			try{
				b = queryTestTableCreate.execute();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return b;
	}
}

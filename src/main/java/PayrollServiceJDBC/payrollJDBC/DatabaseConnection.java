package PayrollServiceJDBC.payrollJDBC;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
public class DatabaseConnection {

	public static void main(String[] args) {
	    String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
	    String userName = "root";
	    String password = "";
	    Connection connection;
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	System.out.println("Driver loaded");
	    }catch(ClassNotFoundException e) {
	    	throw new IllegalStateException("Cannot find the driver in the classpath" , e);
	    }
	    listDrivers();
	    try {
	    	System.out.println("Connection to successful : "+ jdbcURL);
	    	connection = DriverManager.getConnection(jdbcURL, userName, password);
	    	System.out.println();
	    	
	    }catch(Exception e) {
	    	e.printStackTrace(); 
	    }

	}

	public static void listDrivers() {
		Enumeration<Driver> driverList = DriverManager.getDrivers();
		while(driverList.hasMoreElements()) {
			Driver driverClass = (Driver)driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName() );
		}
		
	}

}

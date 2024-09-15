package PayrollServiceJDBC.payrollJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollServiceDB {

	private Connection getConnection() throws SQLException{
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
	    String userName = "root";
	    String password = "";
	    Connection connection;
	    System.out.println("Connection to database : " + jdbcURL);
	    connection = DriverManager.getConnection(jdbcURL,userName,password);
	    System.out.println("Connection to successful : "+ jdbcURL);
		return connection;
	}
	
	public List<EmployeePayroll> readData(){
		String sql = "SELECT * FROM employee;";
		List<EmployeePayroll> employeeList = new ArrayList<>();
		try(Connection connection = this.getConnection()){
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				int employee_id = result.getInt("employee_id");
				String name = result.getString("name");
				double salary =  result.getDouble("salary");
				LocalDate start = result.getDate("start").toLocalDate();
				employeeList.add(new EmployeePayroll(employee_id , name , salary, start));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}
	
	public static void main(String[] args) {
		EmployeePayrollServiceDB obj = new EmployeePayrollServiceDB();
		List<EmployeePayroll> data = obj.readData();
		System.out.println(data + "\n");
	}
}

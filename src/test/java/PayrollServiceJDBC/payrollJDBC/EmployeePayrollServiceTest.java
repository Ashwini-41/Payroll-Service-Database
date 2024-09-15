package PayrollServiceJDBC.payrollJDBC;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class EmployeePayrollServiceTest {

	@Test
	public void givenEmployeePayrollDB_WhenRetrive_ShouldMatchRetriveCount() {
		EmployeePayrollServiceDB employeePayrollService = new EmployeePayrollServiceDB();
		List<EmployeePayroll> employeePayrollList = employeePayrollService.readData();
		assertEquals(4,employeePayrollList.size());
		
	}
	
	@Test
	public void givenNewSalary_WhenUpdated_ShouldSyncWithDB() throws EmployeePayrollException{
		EmployeePayrollServiceDB employeePayrollService = new EmployeePayrollServiceDB();
		employeePayrollService.updateEmployeeeSalary("Ashwini", 500000.00);
		double salaryDB = employeePayrollService.getEmployeeSalaryFromDB("Ashwini");
		assertEquals(500000.00,salaryDB);
		
	}
}

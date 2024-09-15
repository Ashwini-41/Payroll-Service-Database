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
	
}

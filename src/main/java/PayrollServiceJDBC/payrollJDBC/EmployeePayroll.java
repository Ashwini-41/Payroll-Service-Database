package PayrollServiceJDBC.payrollJDBC;

import java.time.LocalDate;

public class EmployeePayroll {
    
	public int employee_id;
	public String name;
	public double salary;
	public LocalDate start; 
	
	public EmployeePayroll(Integer employee_id, String name , Double salary) {
		this.employee_id = employee_id;
		this.name = name;
		this.salary = salary;
	}
	
	public EmployeePayroll(int employee_id, String name,double salary,LocalDate start) {
		this(employee_id, name, salary);
		this.start = start;
	}
	
	@Override
	public String toString() {
		return "EmployeePayrollData [employee_id = " + employee_id + " , name = " + name + ", salary=" + salary + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		EmployeePayroll emp = (EmployeePayroll) obj;
		return employee_id == emp.employee_id && Double.compare(emp.salary, salary) == 0 && name.equals(emp.name);
	}
}

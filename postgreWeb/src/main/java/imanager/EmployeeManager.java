package imanager;

import idao.EmployeeDao;

import java.util.List;

import entity.EmployeeEntity;

public interface EmployeeManager {
	   public void addEmployee(EmployeeEntity employee);
	    public List<EmployeeEntity> getAllEmployees();
	    public void deleteEmployee(Integer employeeId);
	    public void setEmployeeDAO(EmployeeDao employeeDAO);
	    public EmployeeDao getEmployeeDAO();
}

package manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idao.EmployeeDao;
import entity.EmployeeEntity;
import imanager.EmployeeManager;

@Service
public class EmployeeManagerImpl implements EmployeeManager {
 
   
        private EmployeeDao employeeDAO;
 
    @Override
    @Transactional
    public void addEmployee(EmployeeEntity employee) {
        employeeDAO.addEmployee(employee);
    }
 
    @Override
    @Transactional
    public List<EmployeeEntity> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
 
    @Override
    @Transactional
    public void deleteEmployee(Integer employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }

    @Autowired
    public void setEmployeeDAO(EmployeeDao employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    

    public EmployeeDao getEmployeeDAO() {
       return this.employeeDAO;
    }

}

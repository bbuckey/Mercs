package idao;

import java.util.List;

import org.hibernate.SessionFactory;

import entity.EmployeeEntity;

public interface EmployeeDao extends IEmployeeDao{
    public void addEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
    public void setSessionFactory(SessionFactory sessionFactory);
    public SessionFactory getSessionFactory();
}

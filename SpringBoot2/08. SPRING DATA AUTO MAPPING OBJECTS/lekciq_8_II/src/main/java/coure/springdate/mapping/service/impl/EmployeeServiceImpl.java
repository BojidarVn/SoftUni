package coure.springdate.mapping.service.impl;

import coure.springdate.mapping.dao.EmployeeRepository;
import coure.springdate.mapping.entity.Employee;
import coure.springdate.mapping.execption.NonexistingEntityException;
import coure.springdate.mapping.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employee> getAllManagers() {
        return employeeRepo.getManagers();
    }

    @Override
    public List<Employee> getAllEmployeesBornBefore(LocalDate toDate) {
        return employeeRepo.findAllByBirthdayBeforeOrderBySalaryDesc(toDate);
    }

    @Override
    public Employee getEmployeeById(Long id) {

//        return employeeRepo.findById(id).orElseGet(() -> null) ;     purvi na4in.
//        return employeeRepo.findById(id).get();                      vtori na4in   a po dolo e treti na4in

        return employeeRepo.findById(id).orElseThrow(
                () -> new NonexistingEntityException(
                        String.format("Employee with ID=%s does not exist.", id)
                )
        );
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        employee.setId(null);

        if (employee.getManager() != null) {
            employee.getManager().getSubordinates().add(employee);
        }
        return employeeRepo.save(employee);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
       Employee existing= getEmployeeById(employee.getId());
       Employee updated=employeeRepo.save(employee);

       if (existing.getManager() != null && !existing.getManager().equals(employee.getManager())) {
           existing.getManager().getSubordinates().remove(existing);
       }
       if (updated.getManager() !=null && updated.getManager().equals(existing.getManager())){
           updated.getManager().getSubordinates().add(updated);
       }

        return updated;
    }

    @Override
    @Transactional
    public Employee deleteEmployee(Long id) {
        Employee removed= getEmployeeById(id);

        if(removed.getManager() != null) {
            removed.getManager().getSubordinates().remove(removed);
        }

        employeeRepo.deleteById(id);
        return removed;
    }

    @Override
    public long getEmployeeCount() {
        return employeeRepo.count();
    }
}

package iuh.fit.edu.service;


import iuh.fit.edu.entity.Employee;
import iuh.fit.edu.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public List<Employee> search(String keyword) {
        return repo.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(keyword, keyword);
    }

    public Employee getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Employee e) {
        repo.save(e);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

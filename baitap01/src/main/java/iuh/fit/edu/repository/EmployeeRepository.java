package iuh.fit.edu.repository;



import iuh.fit.edu.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String fn, String ln);
}

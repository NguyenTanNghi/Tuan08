package iuh.fit.edu.controller;


import iuh.fit.edu.entity.Employee;
import iuh.fit.edu.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String list(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
        String keyword = searchForm.getKeyword();
        if (keyword != null && !keyword.isEmpty()) {
            model.addAttribute("employees", service.search(keyword));
        } else {
            model.addAttribute("employees", service.getAll());
        }
        return "list";
    }


    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") Employee employee,
                       BindingResult result,
                       Model model) {
        if (result.hasErrors()) {
            return "form";
        }
        service.save(employee);
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", service.getById(id));
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}

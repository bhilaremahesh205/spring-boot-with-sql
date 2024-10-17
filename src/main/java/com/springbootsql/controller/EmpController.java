package com.springbootsql.controller;

import com.springbootsql.dao.EmpDao;
import com.springbootsql.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class EmpController {

    @Autowired
    EmpDao empDao;
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/add")
    public String add(){
        return "registration";
    }

    @PostMapping("/addEmp")
    public String addEmp(Model model,@RequestParam String id,@RequestParam String name,@RequestParam String designation,@RequestParam String salary){
        Employee emp = new Employee(Integer.parseInt(id),name,designation,Double.parseDouble(salary));
        empDao.save(emp);
        model.addAttribute("msg","Employee added successfully...!!!");
        return "registration";
    }

    @GetMapping("/emp")
    public String showAll(Model model){
        List<Employee> list = empDao.findAll();
        model.addAttribute("list",list);
        return "report";
    }

    @GetMapping("/emp/delete/{id}")
    public String deleteEmp(Model model, @PathVariable long id){
        empDao.deleteById(id);
        List<Employee> list = empDao.findAll();
        model.addAttribute("list", list);
        return "report";
    }

    @GetMapping("/emp/update/{id}")
    public String update(Model model, @PathVariable long id){
        Employee emp = empDao.getById(id);
        model.addAttribute("emp",emp);
        return "registration";
    }

}
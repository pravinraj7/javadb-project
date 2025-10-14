package com.example.studentcrud.controller;
import com.example.studentcrud.entity.student;
import com.example.studentcrud.repository.studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/students")
public class studentController {
@Autowired
    private studentrepository studentRepository;
// CREATE
    @PostMapping
    public student createStudent(@RequestBody student student) {
        return studentRepository.save(student);
    }
// READ All
    @GetMapping
    public List<student> getAllStudents() {
        return studentRepository.findAll();
    }
// READ One
    @GetMapping("/{id}")
    public student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }
// UPDATE
    @PutMapping("/{id}")
    public student updateStudent(@PathVariable Long id, @RequestBody student updatedStudent) {
        student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            return studentRepository.save(student);
        }
        return null;
    }
// DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "Student deleted successfully!";
    }
}
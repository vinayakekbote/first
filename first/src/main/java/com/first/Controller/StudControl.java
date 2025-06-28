package com.first.Controller;

import com.first.Model.ErrorResponse;
import com.first.Services.StudService;
import com.first.Model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StudControl {

    @Autowired
    private StudService studService;

    @GetMapping("/show")
    public ResponseEntity<List<Student>> GetData() {
        List<Student> students = studService.ShowData();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {


            Student student = studService.getById(id);
            return ResponseEntity.ok(student);

    }

    @PostMapping("/")
    public ResponseEntity<String> postStudent(@Valid @RequestBody Student student) {
        studService.postStudent(student.getId(), student.getName());
        return ResponseEntity.ok("Data stored successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Student student) {
        studService.updates(student);
        return ResponseEntity.ok("Data updated successfully");
    }

    @DeleteMapping("/")
    public void delete(@RequestBody Student student) {
        studService.delete(student);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> getException(RuntimeException e){
        ErrorResponse errorResponse = new ErrorResponse("Id is not found : ", LocalDate.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}

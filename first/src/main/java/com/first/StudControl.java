package com.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudControl {

    @Autowired
    private StudService studService;

    @GetMapping("/show")
    public List<Student> GetData() {
        return studService.ShowData();
    }

    @PostMapping("/")
    public String postStudent(@RequestBody Student student) {
        studService.postStudent(student.getId(), student.getName());
        return "Data stored successfully";
    }

    @PutMapping("/update")
    public String update(@RequestBody Student student){
        studService.updates(student);
        return "update successfully";
    }

    @DeleteMapping("/")
    public void delete(@RequestBody Student student){
        studService.delete(student);
    }
}

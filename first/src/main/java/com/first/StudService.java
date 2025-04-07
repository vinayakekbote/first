package com.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudService {

    @Autowired
    private StudRepo studRepo;

    public void postStudent(int id, String name) {
        Student student = new Student(id, name);
        studRepo.save(student);
    }

    public List<Student> ShowData() {
        return studRepo.findAll();
    }

    public void updates(Student student) {
        if (studRepo.existsById(student.getId())) {
            studRepo.save(student);
        }else{
            System.out.println("id not exists");
        }
    }

    public void delete(Student student){
        studRepo.delete(student);
    }
}

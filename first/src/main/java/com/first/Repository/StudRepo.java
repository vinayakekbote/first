package com.first.Repository;

import com.first.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudRepo extends JpaRepository<Student, Integer> {
}

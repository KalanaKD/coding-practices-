package com.kd.JDBCproject.repo;

import com.kd.JDBCproject.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student , Integer>{
@Query("select s from Student s where s.name = ?1")
    List<Student> findByName(String name);

    List<Student> findByMarks(int marks);
}

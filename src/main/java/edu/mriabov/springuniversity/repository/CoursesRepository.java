package edu.mriabov.springuniversity.repository;

import edu.mriabov.springuniversity.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Courses,Integer> {

    List<Courses> findByOrderByNameDesc();

    List<Courses> findByOrderByName();
}

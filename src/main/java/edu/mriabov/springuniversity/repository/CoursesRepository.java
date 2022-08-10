package edu.mriabov.springuniversity.repository;

import edu.mriabov.springuniversity.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Course,Integer> {

}

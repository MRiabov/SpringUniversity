package edu.mriabov.springuniversity.repository;

import edu.mriabov.springuniversity.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses,Integer> {

}

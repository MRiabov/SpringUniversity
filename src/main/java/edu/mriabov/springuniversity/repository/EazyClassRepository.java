package edu.mriabov.springuniversity.repository;

import edu.mriabov.springuniversity.model.EazyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EazyClassRepository extends JpaRepository<EazyClass,Integer> {


}

package edu.mriabov.springuniversity.repository;

import org.springframework.stereotype.Repository;
import edu.mriabov.springuniversity.model.Holiday;
import org.springframework.data.repository.CrudRepository;
@Repository
public interface HolidayRepository extends CrudRepository<Holiday,String>{

}

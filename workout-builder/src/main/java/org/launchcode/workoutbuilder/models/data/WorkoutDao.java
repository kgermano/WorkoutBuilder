package org.launchcode.workoutbuilder.models.data;

import org.launchcode.workoutbuilder.models.Routine;
import org.launchcode.workoutbuilder.models.Workout;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.util.List;

@Repository
@Transactional
public interface WorkoutDao extends CrudRepository<Workout, Integer> {
   // List<Workout> findAllByName(String name);

   // List<Workout> findByCategoryId(Integer category_id);

}

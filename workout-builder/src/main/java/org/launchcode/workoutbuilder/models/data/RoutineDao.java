package org.launchcode.workoutbuilder.models.data;

import org.launchcode.workoutbuilder.models.Routine;
import org.launchcode.workoutbuilder.models.Workout;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface RoutineDao extends CrudRepository<Routine, Integer>{

    List<Routine> findByCategoryandWorkout(int categoryId, int workoutId);

    List<Routine> findAll();

    }
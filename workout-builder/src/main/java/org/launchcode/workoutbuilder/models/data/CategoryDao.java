package org.launchcode.workoutbuilder.models.data;

import org.launchcode.workoutbuilder.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface CategoryDao extends CrudRepository<Category, Integer>{
List<Category> findAll();
}

package org.launchcode.workoutbuilder.models.data;

import org.launchcode.workoutbuilder.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer>{

    User findByUserName(String userName);
}

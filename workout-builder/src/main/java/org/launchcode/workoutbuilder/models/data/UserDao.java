package org.launchcode.workoutbuilder.models.data;

import org.launchcode.workoutbuilder.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer>{

    User findByUserName(String UsernName);
}

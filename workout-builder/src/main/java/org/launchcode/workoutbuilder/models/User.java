package org.launchcode.workoutbuilder.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity {

  /* @Id
   @GeneratedValue
   private int id;*/

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[a-zA-Z][a-zA-Z]{4,20}", message = "Invalid username")
    private String userName;

    @NotNull
    private String pwHash;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Routine> routines = new ArrayList<>();

    private String hashPassword(String password) {
        return encoder.encode(password);
    }

    public User() {}

    public User(String userName, String password){

        this.userName = userName;
        this.pwHash = hashPassword(password);

    }


 /*public int getId() {
      return id;
  }

   public void setId(int id) {
        this.id = id;
    }*/


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
}

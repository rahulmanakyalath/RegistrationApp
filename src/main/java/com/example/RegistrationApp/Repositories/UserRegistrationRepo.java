package com.example.RegistrationApp.Repositories;


import com.example.RegistrationApp.Entity.UserDetailsTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRegistrationRepo extends JpaRepository<UserDetailsTbl, Long> {

    @Query(value = "SELECT COUNT(*) FROM usertbl WHERE usertbl.NAME = ?1",nativeQuery = true)
    int IsExsistingUser(String username);


    @Query(value = "SELECT COUNT(*) FROM usertbl WHERE usertbl.EMAILID = ?1 AND usertbl.PASSWORD = ?2",nativeQuery = true)
    int findAllByEmailAndPass(String emailid,String password);

    @Query(value = "SELECT * FROM usertbl WHERE usertbl.EMAILID = ?1",nativeQuery = true)
    UserDetailsTbl findByEmailId(String emailid);

}

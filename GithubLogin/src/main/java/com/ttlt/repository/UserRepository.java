package com.ttlt.repository;

import com.ttlt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: zhaowanxin  Date: 2017/8/14 Time: 18:26
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
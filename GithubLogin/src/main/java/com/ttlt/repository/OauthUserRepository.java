package com.ttlt.repository;

import com.ttlt.domain.OAuthUser;
import com.ttlt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: zhaowanxin  Date: 2017/8/14 Time: 18:46
 */
public interface OauthUserRepository extends JpaRepository<User, Integer> {
    OAuthUser findByOAuthTypeAndOAuthId(String oAuthType, String oAuthId);

    OAuthUser save(OAuthUser oAuthInfo);
}
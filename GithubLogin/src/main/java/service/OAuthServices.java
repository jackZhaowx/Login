package service;

import oauth.OAuthServiceDeractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: zhaowanxin  Date: 2017/8/14 Time: 18:39
 */
@Service
public class OAuthServices {
    @Autowired
    List<OAuthServiceDeractor> oAuthServiceDeractors;

    public OAuthServiceDeractor getOAuthService(String type) {
        Optional<OAuthServiceDeractor> oAuthService = oAuthServiceDeractors.stream().filter(o -> o.getoAuthType().equals(type))
                .findFirst();
        if (oAuthService.isPresent()) {
            return oAuthService.get();
        }
        return null;
    }

    public List<OAuthServiceDeractor> getAllOAuthServices() {
        return oAuthServiceDeractors;
    }

}
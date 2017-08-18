package service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import domain.OAuthUser;
import domain.User;
import oauth.OAuthServiceDeractor;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

/**
 * @author: zhaowanxin  Date: 2017/8/14 Time: 18:35
 */
public class GithubOAuthService extends OAuthServiceDeractor {
    private static final String PROTECTED_RESOURCE_URL = "https://api.github.com/user";

    public GithubOAuthService(OAuthService oAuthService) {
        super(oAuthService, "GITHUB");
    }

    @Override
    public OAuthUser getOAuthUser(Token accessToken) {
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
        this.signRequest(accessToken, request);
        Response response = request.send();
        OAuthUser oAuthUser = new OAuthUser();
        oAuthUser.setoAuthType(getoAuthType());
        Object result = JSON.parse(response.getBody());
        oAuthUser.setoAuthId(JSONPath.eval(result, "$.id").toString());
        oAuthUser.setUser(new User());
        oAuthUser.getUser().setUsername(JSONPath.eval(result, "$.login").toString());
        return oAuthUser;
    }

}
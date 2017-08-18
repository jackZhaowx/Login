package oauth;

import domain.OAuthUser;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

/**
 * @author: zhaowanxin  Date: 2017/8/14 Time: 18:33
 */
public abstract class OAuthServiceDeractor implements OAuthService {
    private final OAuthService oAuthService;
    private final String oAuthType;
    private final String authorizationUrl;

    public OAuthServiceDeractor(OAuthService oAuthService, String type) {
        super();
        this.oAuthService = oAuthService;
        this.oAuthType = type;
        this.authorizationUrl = oAuthService.getAuthorizationUrl(null);
    }


    public String getoAuthType() {
        return oAuthType;
    }

    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    public abstract OAuthUser getOAuthUser(Token accessToken);


    public Token getRequestToken() {
        return null;
    }


    public Token getAccessToken(Token token, Verifier verifier) {
        return null;
    }


    public void signRequest(Token token, OAuthRequest oAuthRequest) {

    }


    public String getVersion() {
        return null;
    }


    public String getAuthorizationUrl(Token token) {
        return null;
    }
}
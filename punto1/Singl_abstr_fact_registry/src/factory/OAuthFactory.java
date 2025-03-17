package factory;

import services.AuthService;
import services.OAuthAuthService;

public class OAuthFactory implements AuthFactory {
    @Override
    public AuthService createAuthService() {
        return new OAuthAuthService();
    }
}

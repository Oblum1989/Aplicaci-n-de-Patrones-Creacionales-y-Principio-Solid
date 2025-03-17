package factory;

import services.AuthService;
import services.LDAPAuthService;

public class LDAPFactory implements AuthFactory {
    @Override
    public AuthService createAuthService() {
        return new LDAPAuthService();
    }
}

package factory;

import services.AuthService;
import services.CustomAuthService;

public class CustomAuthFactory implements AuthFactory {

    @Override
    public AuthService createAuthService() {
        return new CustomAuthService();
    }
}

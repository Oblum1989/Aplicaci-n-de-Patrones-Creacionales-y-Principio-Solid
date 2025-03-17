package factory;

import services.AuthService;

public interface AuthFactory {
    AuthService createAuthService();
}

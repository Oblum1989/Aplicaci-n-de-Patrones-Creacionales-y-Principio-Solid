package factory;

import services.AuthService;
import services.BiometricAuthService;

public class BiometricFactory implements AuthFactory {

    @Override
    public AuthService createAuthService() {
        return new BiometricAuthService();
    }
}

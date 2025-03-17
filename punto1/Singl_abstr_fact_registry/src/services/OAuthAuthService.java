package services;

public class OAuthAuthService implements AuthService {

    @Override
    public boolean authenticate(String provider, String token) {
        System.out.println("Authenticating OAuth " + provider);
        return "valid-token".equals(token);
    }
}

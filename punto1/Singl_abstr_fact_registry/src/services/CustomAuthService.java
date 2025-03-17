package services;

public class CustomAuthService implements AuthService {
    @Override
    public boolean authenticate(String custom, String token) {
        System.out.println("Authenticating Custom " + custom);
        return "valid-custom".equals(token);
    }
}

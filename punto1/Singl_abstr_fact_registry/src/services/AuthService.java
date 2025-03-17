package services;

public interface AuthService {
    boolean authenticate(String username, String password);
}

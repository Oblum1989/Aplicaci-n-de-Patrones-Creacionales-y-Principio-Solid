package services;

public class LDAPAuthService implements  AuthService {
    @Override
    public boolean authenticate(String username, String password) {
        System.out.println("Authenticating in LDAP " + username);
        return "secure-password".equals(password);
    }
}

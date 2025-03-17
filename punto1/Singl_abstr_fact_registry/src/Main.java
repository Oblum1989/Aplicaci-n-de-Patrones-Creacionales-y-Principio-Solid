import factory.AuthFactory;
import factory.LDAPFactory;
import factory.OAuthFactory;
import registry.AuthFactoryRegistry;
import services.AuthService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AuthFactoryRegistry registry = AuthFactoryRegistry.getInstance();

        // 🔹 Register factory
        registry.registerFactory("OAuth", OAuthFactory.class);
        registry.registerFactory("LDAP", LDAPFactory.class);

        // 🔹 Get and use factory
        AuthFactory oauthFactory = registry.getFactory("OAuth");
        AuthService oauthService = oauthFactory.createAuthService();

        AuthFactory ldapFactory = registry.getFactory("LDAP");
        AuthService ldapService = ldapFactory.createAuthService();

        oauthService.authenticate("Google", "valid-token");
        ldapService.authenticate("user", "secure-password");
    }
}
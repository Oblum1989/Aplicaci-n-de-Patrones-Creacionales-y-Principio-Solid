package services;

public class BiometricAuthService implements AuthService {
    @Override
    public boolean authenticate(String fingerprintHash, String unused) {
        System.out.println("Authenticating with biometry ");
        return "fingerprint-valid".equals(fingerprintHash);
    }
}

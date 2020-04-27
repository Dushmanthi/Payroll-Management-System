package com.dushi.LoginServer.security;
import com.dushi.LoginServer.exception.payrollException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

@Service
public class JwtProvider {

//    private Key key;
//    @PostConstruct
//    public void init(){
//        key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//    }
//
//    public String generateToken(Authentication authentication) {
//        User principal = (User) authentication.getPrincipal();
//        return Jwts.builder()
//                .setSubject(principal.getUsername())
//                .signWith(key)
//                .compact();
//    }
//
//    public boolean validateToken(String jwt){
//        Jwts.parser().setSigningKey(key).parseClaimsJws(jwt);
//        return true;
//    }
//
//    public String getUsernameFromJwt(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey(key)
//                .parseClaimsJws(token)
//                .getBody();
//        return claims.getSubject();
//    }
    private KeyStore keyStore;

    @PostConstruct
    public void init() {
        try {
            keyStore = KeyStore.getInstance("JKS");
            InputStream resourceAsStream = getClass().getResourceAsStream("/payroll.jks");
            keyStore.load(resourceAsStream, "secret".toCharArray());
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
            throw new payrollException("Exception occured while loading keystore");
        }

    }

    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .signWith(getPrivateKey())
                .compact();
    }

    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey) keyStore.getKey("payroll", "secret".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new payrollException("Exception occured while retrieving public key from keystore");
        }
    }

    public boolean validateToken(String jwt){
        Jwts.parser().setSigningKey(getPublickey()).parseClaimsJws(jwt);
        System.out.println("validate");
        return true;
    }

    private PublicKey getPublickey() {
        try {
            return keyStore.getCertificate("payroll").getPublicKey();
        } catch (KeyStoreException e) {
            throw new payrollException("Exception occured while retrieving public key from keystore");
        }
    }


    public String getUsernameFromJwt(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(getPublickey())
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}

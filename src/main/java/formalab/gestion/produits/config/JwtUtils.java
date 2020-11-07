package formalab.gestion.produits.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JwtUtils {

    private final long SEVEN_DAYS_IN_SECONDS = 604800L;// 7days *24h * 60 min * 60sec =604800L
    private final String SECRET_KEY ="FormaLABsecretKey";

    public String generateToken(UserDetails userDetails){

//generate claims
        Map<String, Object> claims= new HashMap<>();
        claims.put("sub", userDetails.getUsername());//should be unique like id/email..
        claims.put("created", new Date());

        //generate expiration
        Date expiration= new Date(System.currentTimeMillis() + SEVEN_DAYS_IN_SECONDS * 1000);

        String token= Jwts.builder()
                .setClaims(claims)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .compact();//lasa9 haha

        System.out.println("Generated token : "+token);

        return token;
    }

    public String getUserNameFromToken(String token){
        try {
            Claims claims = getClaims(token);
            return claims.getSubject();
        } catch (Exception ex) {
            return null;
        }
    }

    private Claims getClaims(String token){
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception ex){
            claims = null;
        }

        return claims;
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);

        if(username.equals(userDetails.getUsername()) && !isTokenExpired(token))
            return true;

        return false;
    }

    private boolean isTokenExpired(String token) {
        Date expiration = getClaims(token).getExpiration();

        return expiration.before(new Date());
    }

        //Method1
//        Claims claims= new Claims() {
//            @Override
//            public String getIssuer() {
//            }
//
//            @Override
//            public Claims setIssuer(String s) {
//                return null;
//            }
//
//            @Override
//            public String getSubject() {
//                return null;
//            }
//
//            @Override
//            public Claims setSubject(String s) {
//                return null;
//            }
//
//            @Override
//            public String getAudience() {
//                return null;
//            }
//
//            @Override
//            public Claims setAudience(String s) {
//                return null;
//            }
//
//            @Override
//            public Date getExpiration() {
//                return null;
//            }
//
//            @Override
//            public Claims setExpiration(Date date) {
//                return null;
//            }
//
//            @Override
//            public Date getNotBefore() {
//                return null;
//            }
//
//            @Override
//            public Claims setNotBefore(Date date) {
//                return null;
//            }
//
//            @Override
//            public Date getIssuedAt() {
//                return null;
//            }
//
//            @Override
//            public Claims setIssuedAt(Date date) {
//                return null;
//            }
//
//            @Override
//            public String getId() {
//                return null;
//            }
//
//            @Override
//            public Claims setId(String s) {
//                return null;
//            }
//
//            @Override
//            public <T> T get(String s, Class<T> aClass) {
//                return null;
//            }
//
//            @Override
//            public int size() {
//                return 0;
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return false;
//            }
//
//            @Override
//            public boolean containsKey(Object key) {
//                return false;
//            }
//
//            @Override
//            public boolean containsValue(Object value) {
//                return false;
//            }
//
//            @Override
//            public Object get(Object key) {
//                return null;
//            }
//
//            @Override
//            public Object put(String key, Object value) {
//                return null;
//            }
//
//            @Override
//            public Object remove(Object key) {
//                return null;
//            }
//
//            @Override
//            public void putAll(Map<? extends String, ?> m) {
//
//            }
//
//            @Override
//            public void clear() {
//
//            }
//
//            @Override
//            public Set<String> keySet() {
//                return null;
//            }
//
//            @Override
//            public Collection<Object> values() {
//                return null;
//            }
//
//            @Override
//            public Set<Entry<String, Object>> entrySet() {
//                return null;
//            }
//        }
}

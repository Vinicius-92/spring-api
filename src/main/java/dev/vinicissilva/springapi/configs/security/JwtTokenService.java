package dev.vinicissilva.springapi.configs.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenService {
  @Value("${SECRET_KEY}")
  private String SECRET_KEY;

  @Value("${ISSUER}")
  private String ISSUER;

  public String generateToken(UserDetailsImpl user) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
      return JWT.create()
          .withIssuer(ISSUER)
          .withIssuedAt(creationDate())
          .withExpiresAt(expirationDate())
          .withSubject(user.getUsername())
          .sign(algorithm);
    } catch (JWTCreationException exception) {
      throw new JWTCreationException("Error creating JWT token.", exception);
    }
  }

  public String getSubjectFromToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
      return JWT.require(algorithm).withIssuer(ISSUER).build().verify(token).getSubject();
    } catch (JWTVerificationException exception) {
      throw new JWTVerificationException("Invalid or expired JWT token.");
    }
  }

  private Instant creationDate() {
    return ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toInstant();
  }

  private Instant expirationDate() {
    return ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).plusHours(4).toInstant();
  }
}

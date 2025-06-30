package com.universidad.comedor.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtTokenProvider {

 @Value("${app.jwt.secret}")
 private String secret;

 @Value("${app.jwt.expiration}")
 private long expiration; // Asegúrate de que esta esté en milisegundos o multiplícala por 1000

 private SecretKey getSecretKey() {
  return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
 }

 public String generateToken(String codigo) {
  Date now = new Date();
  Date expiryDate = new Date(now.getTime() + expiration);

  return Jwts.builder()
    .setSubject(codigo)
    .setIssuedAt(now)
    .setExpiration(expiryDate)
    .signWith(getSecretKey(), SignatureAlgorithm.HS256)
    .compact();
 }

 public String getCodigoFromToken(String token) {
  return Jwts.parserBuilder()
    .setSigningKey(getSecretKey())
    .build()
    .parseClaimsJws(token)
    .getBody()
    .getSubject();
 }

 public boolean validateToken(String token) {
  try {
   Jwts.parserBuilder()
     .setSigningKey(getSecretKey())
     .build()
     .parseClaimsJws(token);
   return true;
  } catch (JwtException | IllegalArgumentException e) {
   return false;
  }
 }
}
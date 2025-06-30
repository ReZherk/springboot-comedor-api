package com.universidad.comedor.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.*;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

 private final JwtTokenProvider jwtTokenProvider;

 public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
  this.jwtTokenProvider = jwtTokenProvider;
 }

 @Override
 protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
   throws ServletException, IOException {

  String header = request.getHeader("Authorization");
  if (header != null && header.startsWith("Bearer ")) {
   String token = header.substring(7);
   if (jwtTokenProvider.validateToken(token)) {
    String codigo = jwtTokenProvider.getCodigoFromToken(token);
    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(codigo, null, null);
    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    SecurityContextHolder.getContext().setAuthentication(auth);
   }
  }
  filterChain.doFilter(request, response);
 }
}

package com.speproject.majorproject.filter;

import com.speproject.majorproject.service.serviceImpl.UserServiceSecurityImpl;
import com.speproject.majorproject.utility.JWTUtility;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

    @Autowired
    private JWTUtility jwtUtility;
    @Autowired
    private UserServiceSecurityImpl userServiceSecurity;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorization= request.getHeader("Authorization");
        String token=null;
        String username=null;
        if(authorization!=null && authorization.startsWith("Bearer")){
            token = authorization.substring(7);
            try{
                username = jwtUtility.getUsernameFromToken(token);
            }
            catch (IllegalArgumentException e){
                logger.error("Unable to get JWT Token", e);
            }
            catch (ExpiredJwtException e){
                logger.error("JWT Token is expired", e);
            }
            catch (Exception e){
                logger.error(e.getMessage(), e);
            }
        }
        else{
            logger.warn("JWT does not start with 'Bearer'");
        }

        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails=userServiceSecurity.loadUserByUsername(username);

            if(jwtUtility.validateToken(token,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        =new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request,response);

    }
}

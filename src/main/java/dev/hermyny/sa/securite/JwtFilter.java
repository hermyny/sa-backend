package dev.hermyny.sa.securite;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import dev.hermyny.sa.service.UserService;

import java.io.IOException;


@Service
public class JwtFilter extends OncePerRequestFilter{
	
	private  JwtService jwtService;
    private UserService userService;

    public JwtFilter(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

	
	
	@Override
	 protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
	        String token = null;
	        String username = null;
	        boolean isTokenExpired = true;
	        
	        // Bearer eyJhbGciOiJIUzI1NiJ9.eyJub20iOiJBY2hpbGxlIE1CT1VHVUVORyIsImVtYWlsIjoiYWNoaWxsZS5tYm91Z3VlbmdAY2hpbGxvLnRlY2gifQ.zDuRKmkonHdUez-CLWKIk5Jdq9vFSUgxtgdU1H2216U
	        final String authorization = request.getHeader("Authorization");
	        if(authorization != null && authorization.startsWith("Bearer ")){
	            token = authorization.substring(7);
	            isTokenExpired = jwtService.isTokenExpired(token);
	            username = jwtService.extractUsername(token);
	        }

	        if(!isTokenExpired && username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	            UserDetails userDetails = userService.loadUserByUsername(username);
	            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	        }

	        filterChain.doFilter(request, response);
	    }

	
	}



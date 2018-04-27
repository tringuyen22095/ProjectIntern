package com.intern.config;

import static com.intern.utl.SecurityConstants.EXPIRATION_TIME;
import static com.intern.utl.SecurityConstants.SECRET;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.intern.dto.PayloadDto;
import com.intern.model.UserAccount;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	// region -- Fields --

	private static final long serialVersionUID = -4160292099516778353L;

	// end

	// region -- Methods --

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	public String doGenerateToken(UserAccount userAccount, List<SimpleGrantedAuthority> authorities) {
		Claims claims = Jwts.claims().setSubject(userAccount.getUserName());
		claims.put("scopes", authorities);
		claims.put("user", getPayload(userAccount));

		return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME * 1000))
				.signWith(SignatureAlgorithm.HS256, SECRET).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	private PayloadDto getPayload(UserAccount userAccount) {
		PayloadDto rsp = new PayloadDto();

		rsp.setEmail(userAccount.getEmail());
		rsp.setUserName(userAccount.getUserName());
		rsp.setTelephone(userAccount.getTelephone());
		rsp.setFullName(userAccount.getFullName());

		return rsp;
	}

	// end

}
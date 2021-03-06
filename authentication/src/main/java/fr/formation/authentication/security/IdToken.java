package fr.formation.authentication.security;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class IdToken {

    private final String accessToken;

    private final String tokenType = "Bearer";

    private final long expiresIn;

    IdToken(String accessToken, long expiresIn) {
	this.accessToken = accessToken;
	this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
	return accessToken;
    }

    public String getTokenType() {
	return tokenType;
    }

    public long getExpiresIn() {
	return expiresIn;
    }

    @Override
    public String toString() {
	return "IdToken [accessToken=PROTECTED, tokenType=" + tokenType
		+ ", expiresIn=" + expiresIn + "]";
    }

}

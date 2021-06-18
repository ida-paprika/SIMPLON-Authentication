package fr.formation.authentication.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class BadCredentialsException extends RuntimeException {
//'Credentials' refers to the "username + password" pair

    public BadCredentialsException(String message) {
	super(message);
    }
}

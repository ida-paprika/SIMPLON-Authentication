package fr.formation.authentication.domain.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import fr.formation.authentication.validation.UniqueUsername;

public class AccountCreate {

    @NotBlank
    @NotEmpty
    @Size(max = 255)
    @Email
    @UniqueUsername
    private String username;

    @NotBlank
    @NotEmpty
    @Size(min = 8, max = 12)
    private String password;

    public AccountCreate() {
	//
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public String toString() {
	return "AccountCreate -------\n[ username = " + username
		+ " ]\n[ password = " + password + "]";
    }

}

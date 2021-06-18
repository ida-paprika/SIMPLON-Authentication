package fr.formation.authentication.domain.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AccountLogin {

    @NotBlank
    @NotEmpty
    @Email
    private String username;

    @NotBlank
    @NotEmpty
    @Size(min = 8, max = 12)
    private String password;

    public AccountLogin() {
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
	return "AccountLogin -------\n[ username = " + username
		+ " ]\n[ password = " + password + "]";
    }

}

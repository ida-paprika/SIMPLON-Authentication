package fr.formation.authentication.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.authentication.domain.dtos.AccountCreate;
import fr.formation.authentication.domain.dtos.AccountLogin;
import fr.formation.authentication.domain.entities.Account;
import fr.formation.authentication.domain.entities.Role;
import fr.formation.authentication.repositories.AccountRepository;
import fr.formation.authentication.repositories.RoleRepository;
import fr.formation.authentication.security.BadCredentialsException;
import fr.formation.authentication.security.IdToken;
import fr.formation.authentication.security.TokenProvider;

@Service
public class AccountServiceImpl implements AccountService {

    private final PasswordEncoder encoder;

    private final TokenProvider provider;

    private final AccountRepository accounts;

    private final RoleRepository roles;

    public AccountServiceImpl(PasswordEncoder encoder, TokenProvider provider,
	    AccountRepository accounts, RoleRepository roles) {
	this.encoder = encoder;
	this.provider = provider;
	this.accounts = accounts;
	this.roles = roles;
    }

    @Override
    public void create(AccountCreate inputs) {
	Account entity = new Account();
	entity.setUsername(inputs.getUsername());

	String raw = inputs.getPassword();
	String encoded = encoder.encode(raw);

	entity.setPassword(encoded);
	entity.setEnabled(true);
	Role defaultRole = roles.findByByDefaultTrue();
	entity.setRole(defaultRole);

	accounts.save(entity);

    }

    @Override
    public IdToken login(AccountLogin inputs) {
	String username = inputs.getUsername();
	Account entity = accounts.findByUsernameAndEnabledTrue(username)
		.orElseThrow(() -> new BadCredentialsException(
			"/!\\ Username not found : " + username));
	// Lambda expression: () -> new BadCredentialsException("")
	String encoded = entity.getPassword();
	String raw = inputs.getPassword();
	if (!encoder.matches(raw, encoded)) {
	    throw new BadCredentialsException(
		    "/!\\ Bad password for username : " + username);
	}
	List<String> authorities = List.of(entity.getRole().getCode());
	return provider.idToken(username, authorities);

    }

}

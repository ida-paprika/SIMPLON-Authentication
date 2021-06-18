package fr.formation.authentication.services;

import fr.formation.authentication.domain.dtos.AccountCreate;
import fr.formation.authentication.domain.dtos.AccountLogin;
import fr.formation.authentication.security.IdToken;

public interface AccountService {

    void create(AccountCreate inputs);

    IdToken login(AccountLogin inputs);

}

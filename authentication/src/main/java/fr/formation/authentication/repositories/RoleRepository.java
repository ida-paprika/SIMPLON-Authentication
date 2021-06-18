package fr.formation.authentication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.authentication.domain.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByByDefaultTrue();

}

package fr.formation.authentication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class testController {

    @GetMapping("/anonymous-only")
    public String anonymousOnly() {
	return "I'm an anonymous user";
    }

    @GetMapping("/basic-only")
    public String basicOnly() {
	return "I'm a BASIC user";
    }

    @GetMapping("/admin-only")
    public String adminOnly() {
	return "I'm an ADMIN user";
    }

    @GetMapping("/admin-basic")
    public String adminOrBasicOnly() {
	return "I'm an ADMIN or a BASIC user";
    }

    @GetMapping("/not-anon")
    public String notAnon() {
	return "I'm NOT an anonymous user";
    }

    @GetMapping("/manager-only")
    public String managerOnly() {
	return "I'm an MANAGER user";
    }

    @GetMapping("/admin-manager")
    public String adminOrManagerOnly() {
	return "I'm an ADMIN or a MANAGER user";
    }

}

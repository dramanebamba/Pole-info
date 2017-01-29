package main.java.io.github.dramanebamba.pole_info.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VerificationLogin 
{
	// Class permettant de vérifier la présence des identifiants en BDD
	public boolean test(String login, String pw)
	{
		return (login.equals("admin") && pw.equals("admin"))?true:false;
	}
	
}
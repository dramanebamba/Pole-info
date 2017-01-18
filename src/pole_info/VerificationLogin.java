package pole_info;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VerificationLogin 
{
	// Class permettant de vérifier la présence des identifiants en BDD
	public String test(String login, String pw)
	{
		return (login.equals("Theo") && pw.equals("YEAH"))?"yes":"non";
	}
}
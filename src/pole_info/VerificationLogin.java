package pole_info;

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
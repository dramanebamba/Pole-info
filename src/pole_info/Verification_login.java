package pole_info;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Verification_login 
{
	public String test(String login, String pw)
	{
		return (login.equals("Théo") && pw.equals("oui"))?"yes":"non";
	}
}
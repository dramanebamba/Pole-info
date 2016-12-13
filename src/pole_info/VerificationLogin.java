package pole_info;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VerificationLogin 
{
	public String test(String login, String pw)
	{
		return (login.equals("Theo") && pw.equals("YEAH"))?"yes":"non";
	}
}
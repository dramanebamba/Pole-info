package main.java.io.github.dramanebamba.pole_info.model;

public class Role 
{
	private char code;
	private String intitule;
	
	public Role(char code, String inti)
	{
		setCode(code);
		setIntitule(inti);
	}
	
	public Role(Role r)
	{
		code = r.getCode();
		intitule = r.getIntitule();
	}
	
	public char getCode() 
	{
		return code;
	}
	
	private void setCode(char code) 
	{
		this.code = code;
	}
	
	public String getIntitule() 
	{
		return intitule;
	}
	
	private void setIntitule(String intitule) 
	{
		this.intitule = intitule;
	}
}

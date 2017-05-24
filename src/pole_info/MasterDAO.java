package pole_info;

import javax.enterprise.context.RequestScoped;

import main.java.io.github.dramanebamba.pole_info.model.Master;

@RequestScoped
public class MasterDAO 
{
	private static final String QUERY_GET = "SELECT u FROM Master u";
	Master master;
}

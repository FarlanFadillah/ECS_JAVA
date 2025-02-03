package Action;

public class Action 
{
	private String m_type = "NONE", m_name = "NONE";
	public Action(String type, String name)
	{
		this.m_type = type;
		this.m_name = name;
	}
	
	public String name()
	{
		return m_name;
	}
	
	public String type()
	{
		return m_type;
	}

}

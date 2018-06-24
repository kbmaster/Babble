import java.util.*;

class AST
{
	private String value;
	private List<AST> children;

	public AST(String v)
	{
		this.value=v;
	}

	public void add(AST child)
	{
		this.children.add(child);
	}
	
	public String produce()
	{
		//for(AST node : this.children)
		return "1";
			
	}
}

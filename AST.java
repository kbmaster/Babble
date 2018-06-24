import java.util.*;

class AST
{
	private String value;
	private List<AST> children;

	public AST(String v)
	{
		this.value=v;
		this.children=new ArrayList<AST>();
	}

	public void add(AST child)
	{
		this.children.add(child);
	}
	
	public String produce()
	{
		if(this.children.size()==0) return this.value; //leaf
              
		String str="";
		for(AST node : this.children)
		str+= node.produce();					

		return str;
	}
}

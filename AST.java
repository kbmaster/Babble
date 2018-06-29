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
	
	
	public void print()
	{
		//int node=0;
		//String tree= this.toGraphvitz(node);
		//String commands[] = {"dot", tree};
		//Process process = new ProcessBuilder(commands).start();
	}


	public String toGraphvitz(int node) 
	{
		int parent=node;
		node ++;
		String ret="";
		ret+=node+"1[label=\""+this.value+"\"]\n"; 
		ret+=parent+"->"+node+"\n";
		
		if(this.children.size()==0)	return ret //leaf
				
		for(AST node : this.children)
		ret+=node.toGraphvitz(node);
						
		return ret;
	}
	
	
}

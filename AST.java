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
	
	
	public void print() throws Exception
	{
		String tree="digraph BST {\n";
		int [] node={1};
		tree+= this.toGraphvitz(0,node);
		tree+="}";
		
		System.out.println(tree);

		String [] cmd =
		{
			"/bin/sh",
			"-c",
			"echo \""+tree+"\" | dot -Tx11"
		};
		
		Process process = Runtime.getRuntime().exec(cmd);
	}


	public String toGraphvitz(int parent,int[] node) 
	{
		String ret="";
		ret+=node[0]+"[label=\""+this.value+"\"]\n"; 
		if(parent!=0)ret+=parent+"->"+node[0]+"\n";
		
		if(this.children.size()==0) return ret;
		
		int tmparent=node[0];

		for(AST n : this.children)
		{
			node[0]++;
			ret+=n.toGraphvitz(tmparent,node);
		}

		return ret;
	}
	
	
}


/*
S:'a'T;
T:'b'R;
R:'1';

S:'0'S'0';
S:'1'S'1';
S:'x';

S:'a'S;
S:'b';
}

*/

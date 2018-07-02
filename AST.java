import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


class AST
{
	protected String value;
	protected List<AST> children;

	public AST(String v)
	{
		this.value=v.replace("'","");
		this.children=new ArrayList<AST>();
	}

	public void add(AST child)
	{
		this.children.add(child);
	}

	public Boolean isLeaf()
	{
		return this.children.size()==0;
	}

	public int getAltura()
	{
		int h=0;

		for(AST node:this.children)
		h=Math.max(h,1+node.getAltura());
		
		return h;		
	}

	public String produce()
	{
		if(this.isLeaf()) return this.value; //leaf
              
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
		
		Path path= Paths.get("/tmp/tree.gvz");
                Files.write(path,tree.getBytes());
				
		//System.out.println(tree);

		String [] cmd =
		{
			"/bin/sh",
			"-c",
			"dot  /tmp/tree.gvz -Tx11"
		};
		
		//echo bla | dot -Tx11
		
		Process process = Runtime.getRuntime().exec(cmd);
		//this.readProcOutput(process);
	}


	public String toGraphvitz(int parent,int[] node) 
	{
		String ret="";
		ret+=node[0]+"[label=\"";
		ret+=(this.value.equals("\""))? "\\"+this.value : this.value; 
		ret+="\"]\n";
 
		if(parent!=0)ret+=parent+"->"+node[0]+"\n";
		
		if(this.isLeaf()) return ret;
		
		int tmparent=node[0];

		for(AST n : this.children)
		{
			node[0]++;
			ret+=n.toGraphvitz(tmparent,node);
		}

		return ret;
	}
	
}



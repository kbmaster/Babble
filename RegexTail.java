
import java.util.*;

class RegexTail implements  Tail
{
	private String regex;
	private Double probability;
	
	public RegexTail(String r)
	{
		this.regex=r;
		this.probability=1.0;
	}
		
	public RegexTail(String r,Double p)
        {
                this.regex=r;
                this.probability=p;
        }

	//esto retorna una lista de simbolos a partir de una expresion regular
	//la lista de simbolos deben ser todos terminales en orden tal que garantice 
	//que la cadena pertenece al lenguaje que describe la regex	
	public List <BabbleSymbol> produce()
	{
		List <BabbleSymbol> tail = new ArrayList<BabbleSymbol>();

		//convertir la regex en un arbol expTree
		

		
		//evaluar el arbol  expTree.produce()
		String r="abababba";  
		
		//convertir el string resultante en una lista de terminales
		char [] cr=r.toCharArray();
		for(char c : cr)
		tail.add(new Terminal(c+""));
								
		return tail;
	}
}







class expTree
{
	private String value;
	private List <expTree> children;

	
	public expTree(String v)
	{
		this.value=v;
		this.children= new ArrayList<expTree>();	

	}

	public void add(expTree child)
	{
		this.children.add(child);
	}
	
	
	public String produce()
	{
		if(this.isLeaf()) return this.value;
		else
		{
			expTree l =this.children.get(0);

			switch(this.value)
			{
				case("."):
					expTree	r =this.children.get(1);
					return concat(l.produce(),r.produce());

				case("?"):
					return zeroOne(l.produce());

				case("*"):
					return zeroMore(l.produce());

				case("+"):
					return oneMore(l.produce());
			}

		}	
	
		return "";

	}	
	
	public Boolean isLeaf()
	{
		return this.children.size()==0; 
	}

	
	private String concat(String a, String  b)
	{
		return a+b;
	}
	

	private String zeroMore(String exp)
	{
                //entre 0 y 10
		int r =(int)(Math.random() * 11);
		
		String ret="";
		while(r!=0)
		ret+=exp;

		return ret;
	}

	private String oneMore(String exp)
	{
		//entre 1 y 10
                int r =(int)(Math.random() * 10) + 1;

                String ret="";
                while(r!=0)
                ret+=exp;

                return ret;
		
	}

	private String zeroOne(String exp)
	{
		 //entre 0 y 1
                int r =(int)(Math.random() * 2);

                String ret="";
                while(r!=0)
                ret+=exp;

                return ret;
	}	

}


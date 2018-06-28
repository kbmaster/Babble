
import java.util.*;

class BabbleGrammar
{
	private Map<String,List<Tail>> productions;
	private String start;	
		
	public  BabbleGrammar()
	{
		this.productions= new HashMap<String,List<Tail>>();
	}

	public void add(String head,List <Tail> prods)
	{
		if(this.productions==null) System.out.println("kgamo");
		if(this.productions.size()==0)this.start=head;
		
		if(!this.productions.containsKey(head))
			this.productions.put(head,new ArrayList<Tail>());
		
		List l = this.productions.get(head);
	
		for(Tail p : prods)
		l.add(p);
	}

	public String getStart()
	{
		return this.start;
	}

	public String unparse()
	{
		Set <String> keyset= this.productions.keySet();
		//keyset.remove(this.start);
		List<Object> keys= new ArrayList<Object>(Arrays.asList(keyset.toArray()));

		String gramma="";

		//remove head
		keys.remove(this.start);
		keys.add(0,this.start);

		while(!keys.isEmpty())
		{
			String head=(String)keys.remove(0);
			List <Tail> prods = this.productions.get(head);

			for(Tail t : prods)
			{
				gramma+=head+":";
				List <BabbleSymbol> simbols=t.produce();

				for(BabbleSymbol s : simbols)
				{
					if(s.getClass().getName().equals("Terminal"))				
					gramma+="'"+s.getValue()+"'";
					else
					gramma+=s.getValue();
				}

				gramma+=";\n";

			}

		}


		return gramma;
	}

	private  Tail getProdStartWith(String head)
	{
		List <Tail> prods = this.productions.get(head);		
		
		//aca hay que normalizar las probabilidades de ocurrencia
		//por el momento devuelvo una al azar de las que existen 		
		
		int min = 0;
		int max = prods.size()-1;
		int range = (max - min) + 1;     
		int r =(int)(Math.random() * range) + min;

		return prods.get(r); 
	}


	public AST produce()
	{
		return this.produceSymbol(this.start);		
	}


	private AST produceSymbol(String symbol)
	{
		Tail prod = this.getProdStartWith(symbol);
		List <BabbleSymbol> simbols = prod.produce();
		AST node= new AST(symbol);

		for(BabbleSymbol s:simbols)
		{
			if(s.getClass().getName().equals("Terminal"))
			node.add(s.produce());
			else
			node.add(this.produceSymbol(s.getValue()));
		}

		return node;
	}




}

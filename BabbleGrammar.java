
import java.util.*;
import java.util.Map.*;

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

		String grammar="";

		//remove head
		keys.remove(this.start);
		keys.add(0,this.start);

		while(!keys.isEmpty())
		{
			String head=(String)keys.remove(0);
			List <Tail> prods = this.productions.get(head);
			grammar+=head+":";

			for(Tail t : prods)
			{
				List <BabbleSymbol> simbols=t.produce();

				for(BabbleSymbol s : simbols)
				{
					if(s.isTerminal())				
					grammar+="'"+s.getValue()+"'";
					else
					grammar+=s.getValue();
				}
				
				Double prob= t.getProbability();
				if(prob!=null) grammar+=" %prob "+prob;
				grammar+="|";
			}

			grammar=grammar.substring(0,grammar.length()-1)+";\n";

		}


		return grammar;
	}

	private  Tail getProdStartWith(String head)
	{
		List <Tail> prods = this.productions.get(head);		
		
		//aca hay que normalizar las probabilidades de ocurrencia
		//por el momento devuelvo una al azar de las que existen 		
		
		int min =0;
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
			if(s.isTerminal())
			node.add(s.produce());
			else
			node.add(this.produceSymbol(s.getValue()));
		}

		return node;
	}
	//Por si se prefiere aca
	public void normalizeGrammar() throws Exception
	{  
	  Map<String,List<Tail>> grammarMap=this.productions;
	  for(Entry<String, List<Tail>> entry:grammarMap.entrySet()) {
            //Cantidad de producciones
	    int catidadTail=entry.getValue().size();
	    List<Tail> lista=(List<Tail>)entry.getValue();
	    double sumaTotalProb=0.0;
	    for(int i=0;i<catidadTail;i++)
	    {
		SymbolTail symbolT=(SymbolTail)lista.get(i);
		sumaTotalProb +=symbolT.getProbability();
	    }
	    for(int i=0;i<catidadTail;i++)
	    {
		SymbolTail symbolT=(SymbolTail)lista.get(i);
		symbolT.normalizeProb(sumaTotalProb);
	    }

	 }
		
	}




}

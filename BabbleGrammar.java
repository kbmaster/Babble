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

	public List<Tail> getProdStartWith(String head)
	{
		return this.productions.get(head);
	}

	public void test()
	{
		System.out.println("BabbleGrammar->"+this.productions.size());
	}

}

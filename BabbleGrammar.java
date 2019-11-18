
import java.util.*;
import java.util.Map.*;

class BabbleGrammar
{
	private Map<String,List<Tail>> productions;
	private String start;	

	//El valor maximo y minimo de la altura no es prio del arbol sino
	//de las restricciones que la gramatica le impone

	private Integer hmin;
	private Integer hmax;

		
	public  BabbleGrammar()
	{
		this.productions= new HashMap<String,List<Tail>>();
		this.hmin=0;
		this.hmax=1000;//bastante grande
	}

	
	public void setMinHeightTrees(int h)
        { 
                this.hmin=h;
        }
	
	public void setMaxHeightTrees(int h)
	{
		this.hmax=h;
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
				List <BabbleSymbol> simbols=t.unparse();

				for(BabbleSymbol s : simbols)
				{
					if(s.isTerminal())				
					grammar+="'"+s.getValue()+"'";
					else
					grammar+=s.getValue();
				}
				
				Double prob= t.getProbability();

				if(prob!=1.0 && head!="_") grammar+=" %prob "+prob;
				grammar+="|";
			}

			grammar=grammar.substring(0,grammar.length()-1)+";\n";

		}


		return grammar;
	}

  public Map<String,List<Tail>> getproductions()
        {
                return this.productions;
        }
        //jr
        public void redefineProb(BabbleGrammar babble)
        {
                Map<String,List<Tail>> redefproductions=babble.getproductions();
                String cabeza=babble.getStart();
                Set <String> keyset= redefproductions.keySet();
                List<Object> keys= new ArrayList<Object>(Arrays.asList(keyset.toArray()));
                keys.remove(cabeza);
                keys.add(0,cabeza);

                while(!keys.isEmpty())
                {
                        String head=(String)keys.remove(0);//la cabeza de redef
                        List <Tail> prodsRedef=babble.getproductions().get(head);
                        List <Tail> prods = this.productions.get(head);//busco iguales en mi grammar
                        for(Tail t : prods)
                        {
                                String original="";
                                List <BabbleSymbol> simbols=t.unparse();
                                for(BabbleSymbol o : simbols)
                                {
                                        original+=o.getValue();

                                }
                                for(Tail r : prodsRedef)
                                {
                                        String redef="";
                                        List <BabbleSymbol> simbolsredef=r.unparse();
                                        for(BabbleSymbol s : simbolsredef)
                                        {
                                                redef+=s.getValue();

                                        }
                                        if (redef.compareTo(original)==0)
                                        {
                                                //System.out.println("aii"+redef);
                                                t.setProb(r.getProbability());
                                        }
                                }
                        }
                }


        }



	
	public void normalize()
	{
		for(Entry<String, List<Tail>> entry:this.productions.entrySet())
		{
			//Cantidad de producciones
			int catidadTail=entry.getValue().size();
			List<Tail> lista=(List<Tail>)entry.getValue();
			
			double sumaTotalProb=0.0;

			for(int i=0;i<catidadTail;i++)
	    		{
				Tail symbolT=lista.get(i);
				sumaTotalProb +=symbolT.getProbability();
	    		}

	    		for(int i=0;i<catidadTail;i++)
	    		{
				Tail symbolT=lista.get(i);
				symbolT.normalizeProb(sumaTotalProb);
	    		}

		}

	}



	private  Tail getProdStartWith(String head, int height)
	{
		List <Tail> prods = this.productions.get(head);
		 
		Tail selection=null;

		if(height<=this.hmin) //obtener noterminales
		selection=this.getNoTerminalTail(prods);
			 
		if(height>this.hmin && height <=this.hmax)//solo probabilidad
		selection=this.getProbableTail(prods);

		if(height>this.hmax)//obtener terminales
		selection=this.getTerminalTail(prods);

		return selection;

		/*int min =0;
		int max = prods.size()-1;
		int range = (max - min) + 1;     
		int r =(int)(Math.random() * range) + min;

		return prods.get(r);*/
	}

	
	private List<BabbleSymbol> ignore( List<BabbleSymbol> prods)
	{
		List <Tail> it = this.productions.get("_");
		if(it==null)return prods;

		Tail ignores = it.get(0);
		List<BabbleSymbol> ignore_syms= ignores.produce();
			
		List <BabbleSymbol> rm=new ArrayList();

		
		for(BabbleSymbol sym : prods)
		{
			if(sym.isTerminal())
			{
				for(BabbleSymbol ignore :ignore_syms)
				{
					if(ignore.getValue().equals(sym.getValue()))
					rm.add(sym);
				}

			}
		}


		for(BabbleSymbol sym : rm)
		prods.remove(sym);


		return prods;
	}



	public AST produce()
	{
		return this.produceSymbol(this.start,0);		
	}


	private AST produceSymbol(String symbol,int height)
	{
		AST node= new AST(symbol);
		Tail prod = this.getProdStartWith(symbol,height);
		List <BabbleSymbol> simbols = this.ignore(prod.produce());

		for(BabbleSymbol s:simbols)
		{
			if(s.isTerminal())
			node.add(s.produce());
			else
			node.add(this.produceSymbol(s.getValue(),++height));
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



	private Tail getNoTerminalTail(List<Tail> prods)
        {
                List<Tail> ntl=new ArrayList<Tail>();

                for(Tail t:prods)
                if(t.hasNoTerminal()) ntl.add(t);

                if(ntl.size()>0) return getProbableTail(ntl);

                //si no hay ninguna me aseguro de retornar algo
                return this.getProbableTail(prods);
        }

        private Tail getTerminalTail(List<Tail> prods)
        {
		List<Tail> tl=new ArrayList<Tail>();

                for(Tail t:prods)
                if(t.hasTerminal())tl.add(t);
		
                if(tl.size()>0)return getProbableTail(tl);

                //si no hay ninguna me aseguro de retornar algo
                return this.getProbableTail(prods);
        }



        private Tail getProbableTail(List<Tail> prods)
        {
                Double rnd=Math.random();
                for(Tail t:prods)
                {
                        if(rnd<=t.getProbability())return t;
                        else rnd-=t.getProbability();
                }

                return prods.get(prods.size()-1);

        }



}

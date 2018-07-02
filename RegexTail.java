
import java.util.*;

class RegexTail extends  Tail
{
	private RTree regex;

	public RegexTail(RTree r)
	{
		this.regex=r;
		this.probability=1.0;
	}

	public RegexTail(RTree r, Double p)
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

		//convertir el string resultante en una lista de terminales
		char [] cr=this.regex.produce().toCharArray();
		for(char c : cr)
		tail.add(new Terminal(c+""));
								
		return tail;
	}

	public List <BabbleSymbol> unparse()
	{
		char [] noterm = {'?','*','+','|','(',')'};
		String r=this.regex.unparse();
		char[] sims= r.toCharArray();

		List <BabbleSymbol> ret=new ArrayList<BabbleSymbol>();
		
		ret.add(new NoTerminal("("));

		for(char c :sims)
		{
			if(new String(noterm).indexOf(c) != -1)
			ret.add(new NoTerminal(""+c));
			else
			ret.add(new Terminal(""+c));
		}

		ret.add(new NoTerminal(")"));			

		return ret;
	}

	//las colas regex tienen solo terminales
	public  Boolean hasNoTerminal()
	{
		return false;
	}
	
	public  Boolean hasTerminal()
	{
		return true;
	}

}








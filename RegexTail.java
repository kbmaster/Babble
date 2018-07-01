
import java.util.*;

class RegexTail extends  Tail
{
	private RTree regex;

	public RegexTail(RTree r)
	{
		this.regex=r;
		this.probability=null;
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

}








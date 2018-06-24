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
		return null;
	}
}

import java.util.*;

class RegexTail extends Tail
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

	public List <BabbleSymbol> produce()
	{
		return null;
	}
}

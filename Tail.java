import java.util.*;

abstract class  Tail
{
	protected Double probability;
	abstract public  List<BabbleSymbol> produce();
	abstract public  List<BabbleSymbol> unparse();	
	abstract public  Boolean hasNoTerminal();
	abstract public  Boolean hasTerminal();

	protected Double  getProbability()
	{
		return this.probability;
	}

	protected void normalizeProb(Double maxProb)
	{
		double normalizeValue=(this.probability*100)/maxProb;
		this.probability= (double) Math.round((normalizeValue/100)*10)/10;	
	}
}


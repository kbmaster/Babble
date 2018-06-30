import java.util.*;

abstract  class Tail
{
        protected List <BabbleSymbol> symbols;
        protected Double probability;	

	abstract List<BabbleSymbol> produce();

	protected Double  getProbability()
	{
		return this.probability;
	}
}


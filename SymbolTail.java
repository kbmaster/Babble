import java.util.*;

class SymbolTail extends Tail
{ 
        private List <BabbleSymbol> symbols;

	public SymbolTail(List <BabbleSymbol> s)
        { 
                this.symbols=s;
		this.probability=null;
        }

	public SymbolTail(List <BabbleSymbol> s, Double p)
        {
                this.symbols=s;
		this.probability=p;
        }

	public Double getProbability()
	{
		return this.probability;
	}

        public List <BabbleSymbol> produce()
        { 
		return this.symbols;
        }
}



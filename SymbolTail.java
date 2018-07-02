import java.util.*;

class SymbolTail extends Tail
{ 
        private List <BabbleSymbol> symbols;

	public SymbolTail(List <BabbleSymbol> s)
        { 
                this.symbols=s;
		this.probability=1.0;
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

	public List <BabbleSymbol> unparse()
        {
                return this.symbols;
        }

        public  Boolean hasNoTerminal()
        { 
                for(BabbleSymbol s: this.symbols)
		if(!s.isTerminal())return true;
		
		return false;
        }

        public  Boolean hasTerminal()
        { 
	   for(BabbleSymbol s: this.symbols)
           if(!s.isTerminal())return false;

            return true;
        }

}



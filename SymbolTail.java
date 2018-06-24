import java.util.*;

class SymbolTail extends Tail
{ 
        private List <BabbleSymbol> symbols;
	private Double probability;

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

        public List <BabbleSymbol> produce()
        { 
		return this.symbols;
        }
}



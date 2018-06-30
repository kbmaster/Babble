import java.util.*;

class SymbolTail extends Tail
{ 
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
	public void normalizeProb(double maxProb)
        {
                double normalizeValue=(this.probability*100)/maxProb;
                this.probability=normalizeValue/100;
        }
}



import java.util.*;

abstract class  Tail
{
	protected Double probability;
	abstract public  List<BabbleSymbol> produce();
	protected Double  getProbability()
	{
		return this.probability;
	}
}


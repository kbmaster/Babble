class Terminal extends BabbleSymbol
{
	String value;
	
	public Terminal(String v)
	{
		this.value=v;
	} 

	public AST produce()
	{
		return new AST(this.value);
	}
}

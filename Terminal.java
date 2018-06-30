class Terminal implements  BabbleSymbol
{
	String value;
	
	public Terminal(String v)
	{
		this.value=v.replace("'","");
	}
	
	public String getValue()
	{
		return this.value;
	}

	public Boolean isTerminal()
	{
		return true;
	} 

	public AST produce()
	{
		return new AST(this.value);
	}
}

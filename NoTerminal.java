class NoTerminal extends BabbleSymbol
{ 
        String value;
        public NoTerminal(String v)
        { 
		this.value=v;
        }

	public String getValue()
	{
		return this.value;
	}

        public AST produce()
        { 
                return new AST(this.value);
        }
}


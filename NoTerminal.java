class NoTerminal implements BabbleSymbol
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

	public Boolean isTerminal()
        { 
                return false;
        }

        public AST produce()
        { 
                return new AST(this.value);
        }
}


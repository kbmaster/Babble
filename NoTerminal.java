class NoTerminal extends BabbleSymbol
{ 
        String value;
        public NoTerminal(String v)
        { 
		this.value=v;
        }

        public AST produce()
        { 
                return new AST("2");
        }
}


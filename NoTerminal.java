class NoTerminal extends BabbleSymbol
{ 
        String value;
        public NoTerminal(String v)
        { 
                //System.out.println("#->"+v);
		this.value=v;
        }

        public AST produce()
        { 
                return new AST("2");
        }
}


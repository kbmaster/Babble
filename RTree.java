class RTree extends AST
{
	public RTree(String v)
	{
		super(v);
	}


	 public String produce()
        {
                if(this.isLeaf()) return this.value;
                else
                {
                        RTree l =(RTree)this.children.get(0);
                        RTree r;


                        switch(this.value)
                        {
                                case("."):
					r=(RTree)this.children.get(1);
                                        return concat(l,r);

                                case("?"):
                                        return zeroOne(l);

                                case("*"):
                                        return zeroMore(l);

                                case("+"):
                                        return oneMore(l);

                                case("|"):
					 r=(RTree)this.children.get(1);
                                        return or(l,r);
				
				case("()"):
					return l.produce();
				
                        }

                }

                return "";

        }

	public String unparse()
	{
		if(this.isLeaf()) return this.value; 
		
		Boolean printed=false;
		String ret="";
		if(this.value.equals("()"))ret+="(";


		for( AST n : this.children)
		{
			RTree node= (RTree) n;
			ret+=node.unparse();
			if(!printed)
			{
				if(!this.value.equals("()") && !this.value.equals("."))
				ret+=this.value; 
				printed=true;
			}
		}
		
		if(this.value.equals("()"))ret+=")";
		
		return ret;
	}

	private String concat(RTree a, RTree  b)
        {
                return a.produce()+b.produce();
        }


        private String or(RTree a, RTree b)
        {
                int r =(int)(Math.random() * 2);
		
		return (r==0)?a.produce():b.produce();
        }

        private String zeroMore(RTree exp)
        {
		//entre 0 y 10
                int r =(int)(Math.random() * 11);

                String p= exp.produce();
                String ret="";
                while(r!=0)
		{
                	ret+=p;
			r--;
		}

                return ret;
        }

        private String oneMore(RTree exp)
        {
                //entre 1 y 10
                int r =(int)(Math.random() * 10) + 1;

                String p= exp.produce();
                String ret="";
                while(r!=0)
		{
                	ret+=p;
			r--;
		}

                return ret;

        }

	 private String zeroOne(RTree exp)
        {
                 //entre 0 y 1
                int r =(int)(Math.random() * 2);
                return (r==0)? "":exp.produce();
        }




}

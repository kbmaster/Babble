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
                        RTree r =(RTree)this.children.get(1);

                        switch(this.value)
                        {
                                case("."):
                                        return concat(l.produce(),r.produce());

                                case("?"):
                                        return zeroOne(l.produce());

                                case("*"):
                                        return zeroMore(l.produce());

                                case("+"):
                                        return oneMore(l.produce());

                                case("|"):
                                        return or(l.produce(),r.produce());
                        }

                }

                return "";

        }


	 private String concat(String a, String  b)
        {
                return a+b;
        }


        private String or(String l, String r)
        {
                return "";
        }

        private String zeroMore(String exp)
        {
                //entre 0 y 10
                int r =(int)(Math.random() * 11);

                String ret="";
                while(r!=0)
                ret+=exp;

                return ret;
        }

        private String oneMore(String exp)
        {
                //entre 1 y 10
                int r =(int)(Math.random() * 10) + 1;

                String ret="";
                while(r!=0)
                ret+=exp;

                return ret;

        }

	 private String zeroOne(String exp)
        {
                 //entre 0 y 1
                int r =(int)(Math.random() * 2);

                String ret="";
                while(r!=0)
                ret+=exp;

                return ret;
        }



}

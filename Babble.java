import java.io.*;

public class Babble 
{

   public static BabbleGrammar parseGrammar(String input) throws Exception
  {
	 parser __parser = new parser(new Lexer(new BufferedReader(new InputStreamReader(System.in))));
  	 __parser.parse();
	 return __parser.getGrammar();	 
   }
 

  public static BabbleGrammar parseGrammarFile(String file) throws Exception
  {
	parser __parser = new parser(new Lexer(new FileReader(file)));
	__parser.parse();
	return __parser.getGrammar();
  }

  public static String unparseGrammar(BabbleGrammar babble)
  {
	return babble.unparse();		
  }	

  public static void generateValidStrings(int cadenas, BabbleGrammar babble)
  {
	while(cadenas!=0)
	{
		AST A=babble.produce();
		System.out.println(A.produce());
		cadenas --;
	}
  }

  public static void main(String argv[]) 
  {    
     try {
	
	 BabbleGrammar B;      

	if(argv.length!= 0)//load input from file
	{
		B= Babble.parseGrammarFile(argv[0]);
	}
	else //load input from interactive command line
	{
		B = Babble.parseGrammar("");
	}

	System.out.println(Babble.unparseGrammar(B));
	//Babble.generateValidStrings(10,B);

		

    } catch (Exception e) 
    {
          e.printStackTrace();
    }
  }
}



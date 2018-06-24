import java.io.*;

public class Babble {

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


  public static  void main(String argv[]) {    
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

	B.test();

    } catch (Exception e) {
          e.printStackTrace();
    }
  }
}



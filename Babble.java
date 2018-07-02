import java.io.*;
import java.util.*;

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


  public static List<String>  generateValidStrings(int cadenas, BabbleGrammar babble)
  {
	List<String> strs=new ArrayList<String>();
	while(cadenas!=0)
	{
		AST A=babble.produce();
		strs.add(A.produce());
		cadenas --;
	}

	return strs;
  }

  public static List<AST> generateValidTrees(int cadenas, BabbleGrammar babble)
  {
	List<AST> asts=new ArrayList();
        while(cadenas!=0)
        {
                AST A=babble.produce();
		asts.add(A);
                cadenas --;
        }

	return asts;
  }

	
  public static void normalizeGrammar(BabbleGrammar babble)
  {
	babble.normalize();
  }
	


  public static void printHelp()
  {
	System.out.println("Usage: Babble [options][file]");
	System.out.println("Options:");
	System.out.println("-u,unparse             		unparse the grammar");
	System.out.println("-s,strings  n  [hmin,hmax,probs] 	generate n valid strings");
	System.out.println("-t,trees    n  [hmin,hmax,probs]    generate n valid trees");
  }



  public static void main(String argv[]) 
  {    
     try {
	
	 BabbleGrammar B;      

	String filename=(argv.length!=0)? argv[argv.length-1]:"";
	File f = new File(filename);	

	if(f.exists() && !f.isDirectory())//load input from file
	{
		B= Babble.parseGrammarFile(filename);
	}
	else //load input from interactive command line
	{
		B = Babble.parseGrammar("");
	}

	
	Babble.normalizeGrammar(B);	

	
	switch(argv[0])
	{
		case("unparse"):
		case("-u"): 
			System.out.println(Babble.unparseGrammar(B));	
		break;

		case("strings"):
		case("-s"):
			List<String> l = Babble.generateValidStrings(Integer.parseInt(argv[1]),B);
			for(String s:l)System.out.println(s);
		break;

		case("trees"):
		case("-t"):
			List<AST> la = Babble.generateValidTrees(Integer.parseInt(argv[1]),B);
                        for(AST a:la) a.print();
		break;

		default: Babble.printHelp();

	}


    } catch (Exception e) 
    {
          e.printStackTrace();
    }
  }
}



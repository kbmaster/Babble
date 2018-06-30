import java.io.*;
import java.util.*;
import java.util.Map.*;

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
  public static BabbleGrammar normalizeGrammar(BabbleGrammar grammar) throws Exception
  {  
	 // System.out.println("entre");


	  Map<String,List<Tail>> grammarMap=grammar.getMap();

	  for(Entry<String, List<Tail>> entry:grammarMap.entrySet()) {
		    //Cantidad de producciones
	    int catidadTail=entry.getValue().size();
	    List<Tail> lista=(List<Tail>)entry.getValue();
	    double sumaTotalProb=0.0;
	    for(int i=0;i<catidadTail;i++)
	    {
		SymbolTail symbolT=(SymbolTail)lista.get(i);
		sumaTotalProb +=symbolT.getProbability();
	    }
	    for(int i=0;i<catidadTail;i++)
	    {
		SymbolTail symbolT=(SymbolTail)lista.get(i);
		symbolT.normalizeProb(sumaTotalProb);
	    }

	   // for(int i=0;i<catidadTail;i++)
	    //{
	   // 	SymbolTail symbolT=(SymbolTail)lista.get(i);
	  //  	System.out.println("normaNueva:"+symbolT.getProbability());
	   // }

      }
      return grammar;

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

	//List<String> l= Babble.generateValidStrings(10,B);
	//System.out.println(l);	

	List<AST> l= Babble.generateValidTrees(10,B);
	for(AST t:l)t.print();
	


    } catch (Exception e) 
    {
          e.printStackTrace();
    }
  }
}



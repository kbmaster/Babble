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

	
  public static void normalizeGrammar(BabbleGrammar babble)
  {
	babble.normalize();
  }
	
  
   public static void redefProbGrammar(BabbleGrammar original,BabbleGrammar redef)
  {
        original.redefineProb(redef);//new
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
	 int hmin=0;
	 int hmax=1000;	      

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


	BabbleGrammar Bredef=null;//Argumento 3 del obligatorio.Pongo aca asi no se normaliza dos veces
        if(argv.length==6)//jr
        {
                String filenameBredef=argv[4]+"";
                File fredef = new File(filenameBredef);
                if(fredef.exists() && !fredef.isDirectory())//load input from file
                {
                        System.out.println("------Entrada BabbleGrammar para redefinir Probs-------");
                        Bredef= Babble.parseGrammarFile(filenameBredef);
                        System.out.println("------Salida BabbleGrammar para redefinir Probs-------");
                }
                if(Bredef!=null)//jr
                {
                        Babble.redefProbGrammar(B,Bredef);
                }
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
			
			if(argv.length >= 3)hmin=Integer.parseInt(argv[2]);
			if(argv.length >=4)hmax=Integer.parseInt(argv[3]);
			
			B.setMinHeightTrees(hmin);
			B.setMaxHeightTrees(hmax);
			
			List<String> l = Babble.generateValidStrings(Integer.parseInt(argv[1]),B);
			for(String s:l)System.out.println(s);
		break;

		case("trees"):
		case("-t"):
			
			if(argv.length >= 3)hmin=Integer.parseInt(argv[2]);
			if(argv.length >=4)hmax=Integer.parseInt(argv[3]);

                        B.setMinHeightTrees(hmin);
                        B.setMaxHeightTrees(hmax);

			List<AST> la = Babble.generateValidTrees(Integer.parseInt(argv[1]),B);
                        for(AST a:la){ a.print();}
		break;

		default: Babble.printHelp();

	}


    } catch (Exception e) 
    {
          e.printStackTrace();
    }
  }
}



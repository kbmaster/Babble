
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

import java_cup.runtime.*;
import java.util.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\026\000\002\002\006\000\002\002\004\000\002\002" +
    "\007\000\002\003\003\000\002\004\003\000\002\004\005" +
    "\000\002\005\003\000\002\005\005\000\002\005\003\000" +
    "\002\005\005\000\002\006\003\000\002\006\004\000\002" +
    "\007\003\000\002\007\003\000\002\010\005\000\002\011" +
    "\005\000\002\011\004\000\002\011\004\000\002\011\004" +
    "\000\002\011\005\000\002\011\004\000\002\011\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\046\000\004\011\004\001\002\000\004\005\ufffe\001" +
    "\002\000\006\002\044\011\004\001\002\000\004\005\007" +
    "\001\002\000\010\004\010\011\011\013\017\001\002\000" +
    "\014\004\ufff5\006\ufff5\007\ufff5\010\ufff5\011\ufff5\001\002" +
    "\000\014\004\ufff4\006\ufff4\007\ufff4\010\ufff4\011\ufff4\001" +
    "\002\000\014\004\010\006\041\007\ufff9\010\ufff9\011\011" +
    "\001\002\000\010\006\037\007\ufffb\010\ufffb\001\002\000" +
    "\006\007\ufffd\010\ufffd\001\002\000\006\007\034\010\035" +
    "\001\002\000\014\004\ufff7\006\ufff7\007\ufff7\010\ufff7\011" +
    "\ufff7\001\002\000\006\004\020\013\022\001\002\000\020" +
    "\004\uffec\010\uffec\013\uffec\014\uffec\015\uffec\016\uffec\017" +
    "\uffec\001\002\000\020\004\020\010\030\013\022\014\033" +
    "\015\025\016\027\017\031\001\002\000\006\004\020\013" +
    "\022\001\002\000\020\004\020\010\030\013\022\014\024" +
    "\015\025\016\027\017\031\001\002\000\020\004\uffee\010" +
    "\uffee\013\uffee\014\uffee\015\uffee\016\uffee\017\uffee\001\002" +
    "\000\020\004\uffef\010\uffef\013\uffef\014\uffef\015\uffef\016" +
    "\uffef\017\uffef\001\002\000\020\004\uffed\010\uffed\013\uffed" +
    "\014\uffed\015\025\016\027\017\031\001\002\000\020\004" +
    "\ufff1\010\ufff1\013\ufff1\014\ufff1\015\ufff1\016\ufff1\017\ufff1" +
    "\001\002\000\006\004\020\013\022\001\002\000\020\004" +
    "\ufff0\010\ufff0\013\ufff0\014\ufff0\015\ufff0\016\ufff0\017\ufff0" +
    "\001\002\000\020\004\ufff2\010\ufff2\013\ufff2\014\ufff2\015" +
    "\025\016\027\017\031\001\002\000\010\006\ufff3\007\ufff3" +
    "\010\ufff3\001\002\000\006\002\001\011\001\001\002\000" +
    "\010\004\010\011\011\013\017\001\002\000\006\007\ufffc" +
    "\010\ufffc\001\002\000\004\021\040\001\002\000\006\007" +
    "\ufffa\010\ufffa\001\002\000\004\021\043\001\002\000\014" +
    "\004\ufff6\006\ufff6\007\ufff6\010\ufff6\011\ufff6\001\002\000" +
    "\006\007\ufff8\010\ufff8\001\002\000\004\002\000\001\002" +
    "\000\004\005\046\001\002\000\010\004\010\011\011\013" +
    "\017\001\002\000\006\007\050\010\035\001\002\000\006" +
    "\002\uffff\011\uffff\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\046\000\006\002\004\003\005\001\001\000\002\001" +
    "\001\000\004\003\044\001\001\000\002\001\001\000\014" +
    "\004\014\005\013\006\011\007\015\010\012\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\007\041\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\011\020\001\001\000\002\001\001" +
    "\000\004\011\025\001\001\000\004\011\022\001\001\000" +
    "\004\011\025\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\011\025\001\001\000\002\001\001\000\004\011" +
    "\031\001\001\000\002\001\001\000\004\011\025\001\001" +
    "\000\002\001\001\000\002\001\001\000\012\005\035\006" +
    "\011\007\015\010\012\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\014\004\046\005\013\006\011\007\015\010\012\001" +
    "\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    
    	public void report_error(String message, Object info) 
	{
   
                StringBuilder m = new StringBuilder("Error");
    
	        if (info instanceof java_cup.runtime.Symbol) 
		{
                        java_cup.runtime.Symbol s = ((java_cup.runtime.Symbol) info);
   
                        if (s.left >= 0) {                
                                m.append(" in line "+(s.left+1));   
                
		        if (s.right >= 0)                    
                                m.append(", column "+(s.right+1));
            	}
        }
   
        m.append(" : "+message);
        System.err.println(m);
    }
   
     public void report_fatal_error(String message, Object info) {
        report_error(message, info);
        System.exit(1);
    }

   //////////////////////////////////////////////////////////	

	private BabbleGrammar __grammar=null;
	public BabbleGrammar getGrammar()
	{
		return this.__grammar;
	}




/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // GRAMMAR ::= HEAD ARROW TAILS EOL 
            {
              BabbleGrammar RESULT =null;
		int hleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int hright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String h = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		List t = (List)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT= new BabbleGrammar();  RESULT.add(h,t); __grammar=RESULT;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("GRAMMAR",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= GRAMMAR EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		BabbleGrammar start_val = (BabbleGrammar)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // GRAMMAR ::= GRAMMAR HEAD ARROW TAILS EOL 
            {
              BabbleGrammar RESULT =null;
		int gleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int gright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		BabbleGrammar g = (BabbleGrammar)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int hleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int hright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String h = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		List t = (List)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 g.add(h,t); RESULT=g;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("GRAMMAR",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // HEAD ::= NOTERMINAL 
            {
              String RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT= new String(n);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("HEAD",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // TAILS ::= TAIL 
            {
              List RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Tail t = (Tail)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT=new ArrayList(); RESULT.add(t);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("TAILS",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // TAILS ::= TAILS PIPE TAIL 
            {
              List RESULT =null;
		int tsleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int tsright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		List ts = (List)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Tail t = (Tail)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		ts.add(t); RESULT=ts;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("TAILS",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // TAIL ::= REGEX 
            {
              Tail RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		RTree r = (RTree)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT=new RegexTail(r);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("TAIL",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // TAIL ::= REGEX PROB PROBVAL 
            {
              Tail RESULT =null;
		int rleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		RTree r = (RTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Double p = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT= new RegexTail(r,p);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("TAIL",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // TAIL ::= SIMBOLS 
            {
              Tail RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		List s = (List)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT= new SymbolTail(s);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("TAIL",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // TAIL ::= SIMBOLS PROB PROBVAL 
            {
              Tail RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		List s = (List)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Double p = (Double)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT= new SymbolTail(s,p);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("TAIL",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // SIMBOLS ::= SIMBOL 
            {
              List RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		BabbleSymbol s = (BabbleSymbol)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT=new ArrayList(); RESULT.add(s);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("SIMBOLS",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // SIMBOLS ::= SIMBOLS SIMBOL 
            {
              List RESULT =null;
		int ssleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int ssright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		List ss = (List)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		BabbleSymbol s = (BabbleSymbol)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		ss.add(s); RESULT=ss;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("SIMBOLS",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // SIMBOL ::= TERMINAL 
            {
              BabbleSymbol RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String t = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT=new Terminal(t);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("SIMBOL",5, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // SIMBOL ::= NOTERMINAL 
            {
              BabbleSymbol RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String n = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT=new NoTerminal(n);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("SIMBOL",5, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // REGEX ::= LPARENT EXP RPARENT 
            {
              RTree RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		RTree e = (RTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT=e;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("REGEX",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // EXP ::= EXP PIPE EXP 
            {
              RTree RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		RTree e1 = (RTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		RTree e2 = (RTree)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT=new RTree("|"); RESULT.add(e1); RESULT.add(e2);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // EXP ::= EXP ZERO_MORE 
            {
              RTree RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		RTree e = (RTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT=new RTree("*"); RESULT.add(e);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // EXP ::= EXP ONE_MORE 
            {
              RTree RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		RTree e = (RTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT=new RTree("+"); RESULT.add(e);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // EXP ::= EXP ZERO_ONE 
            {
              RTree RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		RTree e = (RTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT=new RTree("?"); RESULT.add(e);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // EXP ::= LPARENT EXP RPARENT 
            {
              RTree RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		RTree e = (RTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT=new RTree("()"); RESULT.add(e);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // EXP ::= EXP EXP 
            {
              RTree RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		RTree e1 = (RTree)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		RTree e2 = (RTree)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT=new RTree("."); RESULT.add(e1); RESULT.add(e2);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // EXP ::= TERMINAL 
            {
              RTree RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String t = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT= new RTree(t);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXP",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}

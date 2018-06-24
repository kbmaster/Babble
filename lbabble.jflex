import java_cup.runtime.*;
      
%%
   
%class Lexer
%line
%column
%cup
   

%{   
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}


/////////////////////////////////////////////////////////////////////////////   


LineTerminator 	= \r|\n|\r\n
Regex		= \([a-z0-9\?\*\+|]*\)[\+\*\?]?
WhiteSpace     	= {LineTerminator} | [ \t\f]  
NoTerminal	= [A-Z]\w*
Terminal	=  \'([^\'\\]|\\[\'\\\/bfnrt]|\\u[a-fA-F0-9]{4})*\'
Arrow		= :
Prob		= %prob
ProbVal		= 1|0|0\.\d+
Eol		= ;
Ignore		= _
Pipe		= \|

   
%%
   
<YYINITIAL> {
   
    
	{Terminal}   	{ System.out.print(yytext()); return symbol(sym.TERMINAL,new String(yytext())); }
	{NoTerminal} 	{ System.out.print(yytext()); return symbol(sym.NOTERMINAL,new String(yytext())); }
	{Regex}		{ System.out.print(yytext()); return symbol(sym.REGEX,new String(yytext()));}
	{Arrow}		{ System.out.print(" : "); return symbol(sym.ARROW);}	
	{ProbVal}	{ System.out.print(yytext()); return symbol(sym.PROBVAL,new Double(yytext()));}
	{Prob}		{System.out.print(" %prob "); return symbol(sym.PROB);}
   	{Eol}		{ System.out.println(" ;"); return symbol(sym.EOL);}
	{Ignore}	{ System.out.print("_"); return symbol(sym.IGNORE);}
	{Pipe}		{System.out.print(" | "); return symbol(sym.PIPE);}
        {WhiteSpace}    { /* nop */ }   
}

[^]                    { throw new Error("Illegal character <"+yytext()+">"); }

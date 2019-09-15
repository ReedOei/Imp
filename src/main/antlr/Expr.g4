grammar Expr;

prog: (stmt NEWLINE+)* EOF ;
stmt: 'let' ID '=' expr  # Assign
    | 'print' expr       # Print
    | 'proc' ID '(' args ')' '{' NEWLINE* body NEWLINE* expr NEWLINE* '}' # Procedure
    | 'if' expr '{' NEWLINE* body NEWLINE* '}' 'else' '{' NEWLINE* body NEWLINE* '}' # If
    ;
body: (stmt NEWLINE+)* ;
expr: expr ('*'|'/') expr     # BinaryOp
    | expr ('+'|'-') expr     # BinaryOp
    | INT                     # Constant
    | '(' expr ')'            # Paren
    | ID '(' (expr ',')* (expr)? ')'         # Call
    | ID                      # Var
    | expr '==' expr          # Equal
    | expr '<' expr           # Less
    | expr '>' expr           # Greater
    | '!' expr                # Not
    ;
args: (ID ',')* (ID)?;

NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;
ID      : [A-Za-z_][A-Za-z_0-9]* ;

WS      : (' ' | '\t')+ -> channel(HIDDEN); // Ignore whitespace


# compiler

### 参考文法

block -> { stmts }
stmts -> stmt stmts | { stmts }
stmt -> ;|if| while| break |do | assign
if -> if ( bool ) stmts
while -> while ( bool ) stmts
do --> do stmts while ( bool )
break -> break ;
assign -> id = expr

bool-> or | or ''|'' or 

or -> and |and & and

and -> rel

rel -> expr < expr |expr <= expr|expr >=expr| expr > expr 

  expr->term +term | term -term

term-> unary * unary | unary / unary

unary -> ! factor | - factor

factor ->( bool ) |[factor,facror...]|id|false | true|num|real

expr为表达式 stmt为语句

//todo
switch
ll(1)
lr(0)
function
break
continue
类型转换
大小分配,地址对齐
栈向较低的地址方向增长，堆向地址较高的地方增长
自动垃圾回收
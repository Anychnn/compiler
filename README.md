# compiler
### 程序员三大浪漫之一:编译器
参考虎书
讲自定义的程序代码翻译为机器码
```
{
	float i;float j;
	float a;float b;
	float max;
	int test;
	i=2.0; j=3.0; a=4.0;b=5.5;
    if(i+j<a+b){
        max=-j;
    }
    else max =i;
};
```

```
L1:		i = 2.0
L3:		j = 3.0
L4:		a = 4.0
L5:		b = 5.5
L6:		temp1 = i + j
		temp2 = a + b
		iffalse temp1 < temp2 goto L7
L8:		max = -j
		goto L2
L7:		max = i
L2:
```
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

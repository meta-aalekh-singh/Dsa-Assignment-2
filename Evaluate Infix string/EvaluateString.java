import java.util.*;
public class EvaluateString {
	public static int evaluate(String expression)
    {
		Stack<Integer> expressionValues = new Stack<Integer>();
		Stack<Character> operators = new Stack<Character>();
		StringTokenizer stringTokens = new StringTokenizer(expression , " ");
		
		while(stringTokens.hasMoreTokens()){
			String token = stringTokens.nextToken();
			if(isNumeric(token)){
				expressionValues.push(Integer.parseInt(token));
//				System.out.println(token);	
			}
			else if(isOpenBracket(token)){
				operators.push(token.charAt(0));
			}
			else if(isCloseBracket(token)){
				while (operators.peek() != '('){
					expressionValues.push(applyOperator(operators.pop(),expressionValues.pop(),expressionValues.pop()));
				}
				operators.pop();
			}
			else if(isOperator(token)){
				 while (!operators.empty() && hasPrecedence(token.charAt(0),operators.peek())){
					 expressionValues.push(applyOperator(operators.pop(),expressionValues.pop(),expressionValues.pop()));
				 }
				operators.push(token.charAt(0));
			}
			
		}
		while (!operators.empty()){
			expressionValues.push(applyOperator(operators.pop(),expressionValues.pop(),expressionValues.pop()));
		}
		return expressionValues.pop();
    }
	public static boolean hasPrecedence(char operator1, char operator2)
    {
         if (operator2 == '(' || operator2 == ')'){
             return false;
         }
         if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')){
             return false;
         }
         else{
             return  true;
         }
}
	public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;

    }
	public static boolean isOperator(String str) {
        for (char c : str.toCharArray()) {
            if (c=='+'|| c == '-' || c == '*' || c == '/') {
                return true;
            }
        }

        return false;

    }
	public static boolean isOpenBracket(String str) {
        for (char c : str.toCharArray()) {
            if (c == '(') {
                return true;
            }
        }

        return false;

    }
	public static boolean isCloseBracket(String str) {
        for (char c : str.toCharArray()) {
            if (c == ')') {
                return true;
            }
        }

        return false;

    }
	public static int applyOperator(char op, 
            int b, int a)
    {
        switch (op)
        { 
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': if (b == 0)
                      throw new UnsupportedOperationException("Cannot divide by zero");
                      return a / b;
         }
         return 0;
     }


	public static void main(String[] args)
    {
        System.out.println("\n\nExpression 1 : 10 + 2 * 6 = "+ EvaluateString.evaluate("10 + 2 * 6"));
        System.out.println("\n\nExpression 2 : 100 * 2 + 12 = "+ EvaluateString.evaluate("100 * 2 + 12"));
        System.out.println("\n\nExpression 3 : 100 * ( 2 + 12 ) = "+ EvaluateString.evaluate("100 * ( 2 + 12 )"));
        System.out.println("\n\nExpression 4 : 100 * ( 2 + 12 ) / 14 = "+ EvaluateString.evaluate("100 * ( 2 + 12 ) / 14"));
    }
}

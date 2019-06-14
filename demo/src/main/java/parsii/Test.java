package parsii;

import parsii.eval.Expression;
import parsii.eval.Parser;
import parsii.eval.Scope;
import parsii.eval.Variable;
import parsii.tokenizer.ParseException;

/**
 * Created by 10064028 on 2018/1/22.
 */
public class Test {

    public static void main(String[] args) throws ParseException {

        String exp = "2 + (7 - 5) * 3.141592654 * a + sin(0)";

        Scope scope = Scope.create();
        Variable a = scope.getVariable("a");
        Variable abc = scope.getVariable("abc");
        Expression parse = Parser.parse(exp, scope);
        a.setValue(2);
        abc.setValue(2);
        System.out.println(parse.evaluate());
        Expression parse1 = Parser.parse("2*3/4+5-6+2^2");
        System.out.println(parse1.evaluate());
    }
}

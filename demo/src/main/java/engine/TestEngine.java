package engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by 10064028 on 2018/1/24.
 */
public class TestEngine {

    private static Double getIndicatorScore(String expressions, Map<String, Object> params) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        for (Map.Entry<String, Object> entry : params.entrySet()){
            engine.put(entry.getKey(), entry.getValue());
        }
        Object eval = engine.eval(expressions);
        return Double.valueOf(eval.toString());
    }

    public static void main(String[] args) throws ScriptException {
//        String expressions = "targetValue > lowerLimitValue ? value <= lowerLimitValue ? 0 : (Math.min((value - lowerLimitValue) / (targetValue - lowerLimitValue) * weightValue, maxValue)) : value >= lowerLimitValue ? 0 : (Math.min((lowerLimitValue - value) / (lowerLimitValue - targetValue) * weightValue, maxValue))";

//        Map<String, Object> params = new HashMap<>();
//
//        params.put("maxValue", 5.0);
//        params.put("targetValue", 0.9995);
//        params.put("lowerLimitValue", 0.995);
//        params.put("value", 0.88);
//        params.put("weightValue", 5.0);
//
//        Double score = getIndicatorScore(expressions, params);
//        //System.out.println(score);
//
        String str = "count <= 0 ? 0 : -sumScore * count * rate";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        engine.put("count", 3.1);
        engine.put("sumScore", 4.2);
        String valueStr = "0.5";
        if (valueStr.contains("%")){
            valueStr = String.valueOf(Double.valueOf(valueStr.substring(0, valueStr.indexOf("%")))/100d);
        }
//        Double valueDou;
//        if (valueStr.contains("%")){
//            valueDou = Double.valueOf(valueStr.substring(0, valueStr.indexOf("%"))) / 100d;
//        }else {
//            valueDou = Double.valueOf(valueStr);
//        }
        engine.put("rate", valueStr);
        System.out.println(engine.eval(str));
        System.out.println(Double.valueOf("50"));

//        String nan = "count <= 0 ? 0 : -sumScore * count * rate";
//        ScriptEngineManager managerNan = new ScriptEngineManager();
//        ScriptEngine engineNan = managerNan.getEngineByName("js");
//        engineNan.put("count", 3);
//        engineNan.put("sumScore", 4);
//        engineNan.put("rate", "--");
//        Object eval = engineNan.eval(nan);
//        System.out.println(eval);
//        System.out.println(eval instanceof String);
//        System.out.println(Objects.equals(eval.toString(), "NaN"));
//        System.out.println(Objects.equals(Double.valueOf(eval.toString()), Double.valueOf("NaN")));


    }
}

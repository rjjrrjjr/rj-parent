import java.text.DecimalFormat;
import java.util.Date;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by 10064028 on 2018/1/19.
 */
public class TestEngine {

    private Double getOtherScore(Double targetValue, Double targetLowerLimit, Double indicatorWeight, Double maxValue, Double realValue) throws ScriptException {
        Date start = new Date();
        String score = "realValue <= targetLowerLimit ? 0 : Math.min((realValue - targetLowerLimit) / (targetValue - targetLowerLimit) * indicatorWeight, maxValue)";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        engine.put("targetValue", targetValue);
        engine.put("targetLowerLimit", targetLowerLimit);
        engine.put("indicatorWeight", indicatorWeight);
        engine.put("maxValue", maxValue);
        engine.put("realValue", realValue);
        engine.put("aa", 123);
        engine.put("dd", 123);
        engine.put("ss", 123);
        engine.put("fdsfd", 123);
        Double result = (Double) engine.eval(score);
        System.out.println("用时： " + (new Date().getTime() - start.getTime()));
        return result;
    }
    private Double getScore(Double targetValue, Double targetLowerLimit, Double indicatorWeight, Double maxValue, Double realValue) throws ScriptException {
        Date start = new Date();
        Double result = Double.valueOf(0);
        if (realValue <= targetLowerLimit){
            result = Double.valueOf(0);
        }else {
            result = Math.min((realValue - targetLowerLimit) / (targetValue - targetLowerLimit) * indicatorWeight, maxValue);
        }
        System.out.println("用时： " + (new Date().getTime() - start.getTime()));
        return result;
    }

    private Double getScorePoint(Double score){
        Double scorePoint;
        if (score >= 115){
            scorePoint = 1.2;
        }else if (score >= 105){
            scorePoint = 1.1;
        }else if (score >= 100){
            scorePoint = 1.0;
        }else {
            scorePoint = score/100;
        }
        return Double.valueOf(new DecimalFormat("#.00").format(scorePoint));
    }


    public static void main(String[] args) throws ScriptException {
        TestEngine testEngine = new TestEngine();
        Double score = testEngine.getOtherScore(17.0, 15.0, 5.0, 7.0, 21.0);
        System.out.println(score);
        System.out.println("============================");
        /*Double score1 = testEngine.getScore(17.0, 15.0, 5.0, 7.0, 21.0);
        System.out.println(score1);*/


        System.out.println("---------------------------------");
        //System.out.println(testEngine.getScorePoint(78.94564));

    }
}

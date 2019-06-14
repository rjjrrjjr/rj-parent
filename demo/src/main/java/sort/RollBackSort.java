package sort;

import java.util.ArrayList;
import java.util.List;

/**递归回溯，八皇后问题（横竖斜都冲突）
 * @Description:
 * @author: ruanjin
 * @Date: 2019-02-28 15:58
 */
public class RollBackSort {

    private static List<Integer> areaX = new ArrayList<>();
    private static List<Integer> areaY = new ArrayList<>();

    private static int sum = 0;

    /**为了不出现冲突,最后的结果肯定是每行一个皇后,故可遍历行,到最后一行找到一个合法的皇后时,即成功
    * ruanjin
    **/
    private static int[][] sort(int lenth){
        for (int i = 0; i < lenth; i++){
            for (int j = 0; j < lenth; j++){
                if (check(i, j)){
                    areaX.add(i);
                    areaY.add(j);
                    if (i == lenth - 1){
                        //
                        int[][] result = new int[lenth][lenth];
                        for (int i1 = 0; i1 < areaX.size(); i1++) {
                            result[areaX.get(i1)][areaY.get(i1)] = 1;
                        }
                        return result;
                    }
                }
            }
        }
        return null;
    }

    private static Boolean sortCurrentRow(int currentRow){
        if (currentRow == sum){
            int[][] result = new int[sum][sum];
            for (int i1 = 0; i1 < areaX.size(); i1++) {
                result[areaX.get(i1)][areaY.get(i1)] = 1;
            }
            for (int[] ints : result) {
                for (int anInt : ints) {
                    System.out.print(anInt + "\t");
                }
                System.out.println();
            }
            System.out.println("====================================================");
            return false;
        }
        for (int i = 0; i < sum; i++) {
            if (check(currentRow, i)){
                areaX.add(currentRow);
                areaY.add(i);
                if (sortCurrentRow(currentRow + 1)){
                    return true;
                }
                areaX.remove(areaX.size() - 1);
                areaY.remove(areaY.size() - 1);
            }
        }
        return false;
    }

    private static Boolean check(int currentX, int currentY){
        if (!areaX.contains(currentX) && !areaY.contains(currentY)){
            if (areaY.size() == 0){
                return true;
            }
            for (int i = 0; i < areaX.size(); i++) {
                int sumX = areaX.get(i) - currentX;
                int sumY = areaY.get(i) - currentY;
                if (sumX == sumY || sumX + sumY == 0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        sum = 8;
        sortCurrentRow(0);
        int[][] result = new int[sum][sum];
        for (int i1 = 0; i1 < areaX.size(); i1++) {
            result[areaX.get(i1)][areaY.get(i1)] = 1;
        }

        if (result != null){
            for (int[] ints : result) {
                for (int anInt : ints) {
                    System.out.print(anInt + "\t");
                }
                System.out.println();
            }
        }
        System.out.println("==============");
    }
}
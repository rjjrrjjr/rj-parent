package sort;

import java.util.Collections;
import java.util.LinkedList;

/**桶排序，类似计数排序，不过桶排序是针对double，计数排序是针对int
 * @Description:
 * @author: ruanjin
 * @Date: 2019-02-28 14:33
 */
public class BucketSort {

    private static double[] sort(double[] sourceData){
        if (sourceData != null && sourceData.length > 0){
            //1、遍历取最大最小
            //2、建桶，遍历将数据入桶
            //4、输出(桶内排序)
            double max = sourceData[0];
            double min = sourceData[0];
            for (double sourceDatum : sourceData) {
                if (max < sourceDatum){
                    max = sourceDatum;
                }
                if (min > sourceDatum){
                    min = sourceDatum;
                }
            }
            //区间跨度 = （最大值-最小值）/ （桶的数量 - 1）
            double mid = (max - min)/(sourceData.length - 1);

            LinkedList<Double>[] bucketArray = new LinkedList[sourceData.length];

            for (double sourceDatum : sourceData) {
                int i = (int) ((sourceDatum - min) / mid);
                if (bucketArray[i] == null){
                    bucketArray[i] = new LinkedList();
                }
                bucketArray[i].add(sourceDatum);
            }

            double[] result = new double[sourceData.length];
            int index = 0;
            for (int i = 0; i < bucketArray.length; i++) {
                if (bucketArray[i] != null){
                    Collections.sort(bucketArray[i]);
                    for (Double aDouble : bucketArray[i]) {
                        result[index++]  = aDouble;
                    }
                }
            }

            return result;
        }
        return null;
    }

    public static void main(String[] args) {
        double[] result = sort(new double[]{1.2, 2.3, 3.4, 3.2, 2.2, 2.1, 1.3});
        for (double v : result) {
            System.out.print(v + ",");
        }
    }
}

package sort;

/**计数排序：将一定范围内的整数对应到一个数组的各个下标，以此排序
 * @Description:
 * @author: ruanjin
 * @Date: 2019-02-28 13:58
 */
public class CountSort {

    private static int[] sort(int[] sourceData){
        //1、找最大最小数
        //2、通过最大差获取结果数组
        //3、遍历源数据数组，一一对应到结果数组
        //4、遍历结果数组封装数据
        if (sourceData != null && sourceData.length > 0){
            int max = sourceData[0];
            int min = sourceData[0];
            for (Integer sourceDatum : sourceData) {
                if (max < sourceDatum){
                    max = sourceDatum;
                }
                if (min > sourceDatum){
                    min = sourceDatum;
                }
            }
            int[] countArray = new int[max - min + 1];
            for (Integer sourceDatum : sourceData) {
                countArray[sourceDatum - min] ++;
            }

            int[] result = new int[sourceData.length];
            int index = 0;
            for (int i = 0; i < countArray.length; i++) {
                while (countArray[i]-- != 0){
                    result[index ++] = min + i;
                }
            }
            return result;
        }
        return null;
    }

    public static void main(String[] args) {
        for (int i : sort(new int[]{99, 93, 95, 92, 95, 93, 94, 96, 98})) {
            System.out.print(i + ", ");
        }
    }
}

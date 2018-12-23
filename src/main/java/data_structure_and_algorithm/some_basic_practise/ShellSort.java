package data_structure_and_algorithm.some_basic_practise;

/**
 * Project:Exercise
 * Package:main.java.data_structure_and_algorithm
 * Author:Alan Ruan
 * Date:2018-11-20 10:40
 * Description://TODO
 */
public class ShellSort {

    public static void main(String[] args) {
        int a[] = {3,1,5,7,2,4,9,6,10,8};
        ShellSort  obj=new ShellSort();
        System.out.println("初始值：");
        obj.print(a);
        obj.shellSort(a);
        System.out.println("\n希尔排序后：");
        obj.print(a);

    }
    private void shellSort(int[] a) {
        int dk = a.length/2;
        while( dk >= 1  ){
            ShellInsertSort(a, dk);
            dk = dk/2;
        }
    }
    private void ShellInsertSort(int[] a, int dk) {//类似插入排序，只是插入排序增量是1，这里增量是dk,把1换成dk就可以了
        for(int i=dk;i<a.length;i++){
            if(a[i]<a[i-dk]){
                int j;
                //x为待插入元素
                int x=a[i];
                a[i]=a[i-dk];
                for(j=i-dk;  j>=0 && x<a[j];j=j-dk){
                    //通过循环，逐个后移一位找到要插入的位置。
                    a[j+dk]=a[j];
                }
                //插入
                a[j+dk]=x;
            }

        }

    }
    public void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}

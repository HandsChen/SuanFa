package 背包九讲;

import java.util.Scanner;

//有N件物品和一个容量为V的背包。第i件物品的体积是vi,价值是wi。
//求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大
public class ZeroAndOnePackage {
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int N=in.nextInt();
//        int V=in.nextInt();
//
//        //物品的体积以及其价值
//        int value[]=new int[N+1];
//        int weight[]=new int[V+1];
//
//        //输入体积以及价值
//        for(int i=1;i<=N;i++){
//            value[i]=in.nextInt();
//            weight[i]=in.nextInt();
//        }
//
//        //定义一个初始的状态举证
//        int state[][]=new int[N+1][V+1];
//
//        //初始化初始值
//        state[0][0]=0;
//
//        //开始遍历
//        for(int i=1;i<=N;i++)
//            for(int j=0;j<=V;j++){
//                //判断第i件物品是否可以放进去
//
//                //如果可以放进去
//                if(j>=weight[i]){
//                    //虽然可以放进去
//                    //但是也分为将第i个物品放进去了还有没放进去两种情况
//                    //因此要取最大值
//                    state[i][j]=Math.max(state[i-1][j],state[i-1][j-weight[i]]+value[i]);
//                }else {
//                    //如果放不进去
//                    state[i][j]=state[i-1][j];
//                }
//            }
//
//        //将状态数组中的最大值取出即为放入N个物品装入容积为V的背包的最大价值
//        System.out.println(state[N][V]);
//    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int V=in.nextInt();
        //物品的体积以及其价值
        int value[]=new int[N+1];
        int weight[]=new int[V+1];

        //输入体积以及价值
        for(int i=1;i<=N;i++){
            value[i]=in.nextInt();
            weight[i]=in.nextInt();
        }

        //定义状态矩阵，表示当前容量下前n个物品的最大价值
        int state[]=new int[V+1];
        for(int i=1;i<=N;i++)
            for(int j=V;j>=weight[i];j--){
                state[j]=Math.max(state[j],state[j-weight[i]]+value[i]);
            }

        System.out.println(state[V]);
    }
}

/*
4 5
1 2
2 4
3 4
4 5
 */
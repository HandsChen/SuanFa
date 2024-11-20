package 背包九讲;
//讲的是完全背包问题

import java.util.Scanner;

//有N件物品和一个容量为V的背包。第i件物品的体积是vi,价值是wi。***每件物品都可以使用无限次
//求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大
public class CompletPackage {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int V=in.nextInt();
        int state[]=new int[V+1];
        state[0]=1;
        for(int i=1;i<=V;i++){
            state[i]=Integer.MIN_VALUE;
        }

        int weight[]=new int[]{0,1,5,10,25};

        for(int i=1;i<=4;i++){
            for(int j=weight[i];j<=V;j++){
                state[j]=Math.max(state[j],state[j-weight[i]]);
            }
        }
        System.out.println(state[V]);

    }
}

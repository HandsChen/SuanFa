package Top100;

public class num_461 {
    public static void main(String[] args) {

        System.out.println(hammingDistance(1,4));
    }
    public static int hammingDistance(int x, int y) {

        //将这两个数转化为二进制数
        int ans=x^y;
        String str=Integer.toBinaryString(ans);
        //数里面有几个1
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1')
                count++;
        }
        return count;
    }
}

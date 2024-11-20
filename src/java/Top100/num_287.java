package Top100;

public class num_287 {
    public static void main(String[] args) {

    }
    public int findDuplicate(int[] nums) {

        int len=nums.length;

        int bin[]=new int[len];

        for(int i=0;i<len;i++){
            bin[nums[i]]++;
        }

        for(int i=0;i<len;i++){
            if(bin[i]>=2)
                return i;
        }
        return 0;

    }
}

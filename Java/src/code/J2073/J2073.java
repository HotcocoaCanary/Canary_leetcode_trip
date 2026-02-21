package code.J2073;

public class J2073 {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        for (int i = 0;true;i++){
            int index = i%tickets.length;
            if (tickets[index]>0){
                if (index == k && tickets[k] == 1){
                    return ++ans;
                }
                ans++;
                tickets[index]--;
            }
        }
    }
}

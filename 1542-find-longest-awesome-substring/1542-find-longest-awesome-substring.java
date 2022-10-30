class Solution {
    public int longestAwesome(String s) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int cur=0;  //状态
        int ans=1;  //记录答案
        map.put(cur,-1); 
        for(int c=0;c<s.length();c++){
            int ch=s.charAt(c)-'0';
            //计数
            cur=cur^(1<<ch);
            //一个数字出现奇数次，其余出现偶数次
            for(int i=0;i<10;i++){
                int next=cur^(1<<i);
                if(map.containsKey(next)){
                    ans=Math.max(ans,c-map.get(next));
                }
            }
            //所有都出现了偶数次
            if(!map.containsKey(cur)){
                map.put(cur,c);
            }else{
                ans=Math.max(ans,c-map.get(cur));
            }
        }
        return ans;
    }
}

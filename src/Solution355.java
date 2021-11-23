import java.util.*;

/**
 * 355. 设计推特
 *
 * @author chen yu
 * @create 2021-10-25 08:55
 */
public class Solution355 {
    //用户和其推文
    HashMap<Integer,TwitText> twitTextMap;

    //用户 和该用户关注的人
    HashMap<Integer,Set<Integer>> followingMap;

    //优先队列  时间大的在前
    PriorityQueue<TwitText> queue;

    int timeStamp=0;

    public Solution355() {
        twitTextMap=new   HashMap<Integer,TwitText>();
        followingMap=new   HashMap<Integer,Set<Integer>>();
        queue= new PriorityQueue<TwitText>((a,b)->b.timeStamp-a.timeStamp);
    }

    public void postTweet(int userId, int tweetId) {
        timeStamp++;
        if(twitTextMap.containsKey(userId)){
            TwitText oldTwitText= twitTextMap.get(userId);
            TwitText newTwitTex = new TwitText(tweetId,timeStamp);
            newTwitTex.next=oldTwitText;
            twitTextMap.put(userId,newTwitTex);
        }else{
            twitTextMap.put(userId,new TwitText(tweetId,timeStamp));
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        queue.clear();
        List<Integer> ans =new ArrayList<Integer>();

        //1.先获取自己发的推文 并加入优先队列
        TwitText  userTwittTextHead= twitTextMap.get(userId);
        if(userTwittTextHead!=null){
            queue.offer(userTwittTextHead);
        }

        //获取用户关注的其他用户发的推文
        Set<Integer> followeeSet=followingMap.get(userId);
        if(followeeSet!=null&&followeeSet.size()>0){
            for(Integer e:followeeSet){
                TwitText twitText=twitTextMap.get(e);
                if(twitText!=null){
                    queue.offer(twitText);
                }
            }
        }

        int count=10;
        while(!queue.isEmpty()&& count>0){
            TwitText twittText= queue.poll();
            ans.add(twittText.Id);
            if(twittText.next!=null){
                queue.offer(twittText.next);
            }
            count--;
        }

        return ans;
    }


    //followeeId 被关注者id
    public void follow(int followerId, int followeeId) {

        if( followerId== followeeId){
            return;
        }

        Set<Integer> set = followingMap.get(followerId);

        if(set==null){
            HashSet<Integer> initSet = new HashSet<Integer>();
            initSet.add(followeeId);
            followingMap.put(followerId,initSet);

        }else{
            set.add(followeeId);
        }


    }

    public void unfollow(int followerId, int followeeId) {

        if(followeeId==followerId){
            return;
        }
        Set<Integer>  set = followingMap.get(followerId);
        if(set==null){
            return;
        }
        set.remove(followeeId);

    }


    private class TwitText{
        //发推文的时间
        int timeStamp;
        //推文ID
        int Id;
        //推文之间的关联
        TwitText   next;

        TwitText(int Id,int timeStamp){
            this.Id=Id;
            this.timeStamp=timeStamp;
        }


    }


}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
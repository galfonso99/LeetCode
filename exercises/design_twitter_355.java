import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
// More efficient Solution using just a Dynamic Array instead of PriorityQueue
class Twitter {
    private final Map<Integer,Set<Integer>> user;
    private final List<Pair<Integer,Integer>> tweets;

    public Twitter() {
        user = new HashMap<>();
        tweets = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!user.containsKey(userId)){
            user.put(userId,new HashSet<>());
        }
        tweets.add(new Pair<Integer,Integer>(userId,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        int index = tweets.size()-1;
        while(res.size()<10 && index >=0){
            Pair<Integer,Integer> p = tweets.get(index--);
            if(userId==p.getLeft() || user.get(userId).contains(p.getLeft())){
                res.add(p.getRight());
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(user.containsKey(followerId)){
            user.get(followerId).add(followeeId);
        }else{
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            user.put(followerId,set);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(user.containsKey(followerId)){
            user.get(followerId).remove(followeeId);
        }
    }

    private class Pair<Left,Right> {
        private Left l;
        private Right r;
        
        public Pair(Left l,Right r){
            this.l=l;
            this.r = r;
        }

        public Left getLeft(){
            return l;
        }

        public Right getRight(){
            return r;
        }
    }
}
// Original Solution using PriorityQueue
//class Twitter {
//	PriorityQueue<Integer[]> maxHeap;
//	LinkedList<Integer>[] followList;
//	Integer timestamp;
//
//    public Twitter() {
//		Comparator<Integer[]> comparator = (a, b) -> {
//            for (int i = 0; i < a.length; i++) {
//                int comparison = b[i].compareTo(a[i]);
//                if (comparison != 0) {
//                    return comparison;
//                }
//            }
//            return 0;
//        };
//		this.maxHeap = new PriorityQueue<>(comparator);
//		this.followList = (LinkedList<Integer>[]) new LinkedList<?>[500];
//		this.timestamp = 0;
//    }
//
//    public void postTweet(int userId, int tweetId) {
//        Integer[] post = new Integer[] { timestamp++, userId, tweetId };
//        maxHeap.offer(post);
//    }
//
//    public List<Integer> getNewsFeed(int userId) {
//        List<Integer> feed = new ArrayList<>();
//        PriorityQueue<Integer[]> traversalHeap = new PriorityQueue<>(maxHeap);
//
//        int count = 0;
//        while (!traversalHeap.isEmpty() && count < 10) {
//            Integer[] post = traversalHeap.poll();
//            if (post[1] == userId || 
//                (followList[userId] != null && followList[userId].contains(post[1]))) {
//                feed.add(post[2]);
//                count++;
//            }
//        }
//        return feed;
//    }
//
//    public void follow(int followerId, int followeeId) {
//		if (followList[followerId] == null) followList[followerId] = new LinkedList<Integer>();
//		followList[followerId].add(followeeId);
//    }
//
//    public void unfollow(int followerId, int followeeId) {
//        if (followList[followerId] == null) followList[followerId] = new LinkedList<Integer>();
//		followList[followerId].remove((Object) followeeId);
//    }
//}


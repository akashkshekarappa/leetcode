class Twitter {
    class Tweet{
        int id;
        int createdAt;
        
        public Tweet(int tweetId, int timestamp){
            this.id = tweetId;
            this.createdAt = timestamp;
        }
    }
    
    HashMap<Integer, Set<Integer>> following;
    HashMap<Integer, List<Tweet>> tweets;
    int feedsize;
    int timestamp;
​
    /** Initialize your data structure here. */
    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        feedsize = 10;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        //first check userId is there in users(following table)
        follow(userId, userId);
        //creating a userId entry in tweets table if userId is not there
        if(!tweets.containsKey(userId))
            tweets.put(userId, new ArrayList<>());
        
        //Add that object to list of tweets of that user
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((tweet1, tweet2) -> tweet1.createdAt-tweet2.createdAt);  // min head
        //take all the users i am following
        Set<Integer> fIds = following.get(userId);
            if(fIds != null){
                //take tweets of all fIds
                for(Integer fId : fIds){
                    List<Tweet> fTweets = tweets.get(fId);
                    if(fTweets != null){
                        for(Tweet fTweet : fTweets){
                            pq.add(fTweet);
                            
                            if(pq.size() > feedsize)
                                pq.poll();
                        }
                    }
                }
            }

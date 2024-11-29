# Optimal Solution using a List and not a MaxHeap
from typing import List
from typing import Tuple
from typing import Dict
class Twitter:
    tweets: List[Tuple[int, int]]
    follows: Dict[int, Dict[int, None]]
    def __init__(self):
        self.tweets = []
        self.follows = {}
        return

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweets.append((userId, tweetId))
        return
        

    def getNewsFeed(self, userId: int) -> List[int]:
        res = []
        i = 0
        n = len(self.tweets)
        while len(res) < 10 and i < n:
            curr_id = self.tweets[n-1-i][0]
            if curr_id == userId or (userId in self.follows and curr_id in self.follows[userId]):
                res.append(self.tweets[n-1-i][1])
            i += 1
        return res 
        

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId not in self.follows:
            self.follows[followerId] = {}
        self.follows[followerId][followeeId] = None
        return

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId in self.follows and followeeId in self.follows[followerId]:
            self.follows[followerId].pop(followeeId)
        return


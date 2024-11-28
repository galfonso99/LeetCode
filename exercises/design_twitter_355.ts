class Twitter {
	tweets: [number, number][]
	follows: Map<number, Set<number>> 
    constructor() {
        this.tweets = []
		this.follows = new Map()
    }

    postTweet(userId: number, tweetId: number): void {
        this.tweets.push([userId, tweetId])
    }

    getNewsFeed(userId: number): number[] {
        const res: number[] = []
		const n = this.tweets.length
		for (let i = 0; i < n; i++) {
			let curr_id = this.tweets[n-1-i][0]
			if (curr_id === userId || ( this.follows.has(userId) 
					&& this.follows.get(userId)!.has(curr_id)) ) {
				res.push(this.tweets[n-1-i][1])
			}
			if (res.length == 10) break
		}
		return res
    }

    follow(followerId: number, followeeId: number): void {
		if (!this.follows.has(followerId)) {
			this.follows.set(followerId, new Set<number>())
		}
		this.follows.get(followerId)!.add(followeeId)
    }

    unfollow(followerId: number, followeeId: number): void {
       	if (this.follows.has(followerId) && this.follows.get(followerId)?.has(followeeId) {
			this.follows.get(followerId)?.delete(followeeId)
		}
    }
}


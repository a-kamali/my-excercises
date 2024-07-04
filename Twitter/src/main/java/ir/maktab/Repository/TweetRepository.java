package ir.maktab.Repository;

import ir.maktab.domain.Tweet;

public interface TweetRepository extends BaseDomainRepository {
    Tweet findTweetById(String id) throws Exception;
}

package com.seneca.senecaforum.repository;

import com.seneca.senecaforum.domain.Post;
import com.seneca.senecaforum.domain.Topic;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByTopicOrderByCommentsCreatedOnDesc(Topic topic, Pageable pageable);

    

//    @Query("FROM Post p WHERE p.topic.topicId = :topicId and p.tags like %:tags%")
//    List<Post> filterPosts(int topicId, String tags);

    @Query("FROM Post p where p.topic.topicId=:topicId and p.tags like %:tags% and p.createdOn between :startDate and :endDate")
    List<Post> filterPosts(int topicId, String tags, Date startDate, Date endDate);

}

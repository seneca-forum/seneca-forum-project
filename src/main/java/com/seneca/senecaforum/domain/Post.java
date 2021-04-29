package com.seneca.senecaforum.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;

    @Column(name = "title")
    private String title;

    @Column(name = "createdOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "noOfReplies")
    private int noOfReplies;

    @OneToOne
    @JoinColumn(name = "author_id")
    private User user;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private List<Comment> comments;

}

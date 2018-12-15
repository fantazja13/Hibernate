package pl.coderslab.domain;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "post",
            orphanRemoval = true
    )
    private  PostDetails postDetails;

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
        postDetails.setPost(this);
    }
}

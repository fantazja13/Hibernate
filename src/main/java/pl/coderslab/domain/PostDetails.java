package pl.coderslab.domain;

import javax.persistence.*;

@Entity
@Table(name="posts_details")
public class PostDetails {

    @Id
    private Long id;

    private String details;

    @OneToOne
    @MapsId
    private Post post;

    public PostDetails() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}

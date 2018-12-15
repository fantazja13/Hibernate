package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.domain.Post;
import pl.coderslab.domain.PostDetails;
import pl.coderslab.repository.PostDao;

import javax.transaction.Transactional;

@Controller
@Transactional
public class PostController {

    @Autowired
    private PostDao postDao;

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    @ResponseBody
    public String test() {

        Post post = new Post();
        post.setName("Nazwa postu");

        PostDetails postDetails = new PostDetails();
        postDetails.setDetails("szczegoly postu");

        post.setPostDetails(postDetails);

        postDao.savePost(post);

        return "wynik w konsoli";
    }
}
package unrn.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unrn.mongo.api.PostServicio;
import unrn.mongo.modelo.dto.AuthorPostDTO;
import unrn.mongo.modelo.dto.PostDTO;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private PostServicio postService;

    @GetMapping("byauthor")
    List<AuthorPostDTO> getAuthorsAndNumberOfPost() {
        return this.postService.findAuthors();
    }

    @GetMapping("search/{text}")
    List<PostDTO> getPostsByText(@PathVariable String text) {
        return this.postService.findPostByText(text);
    }
}
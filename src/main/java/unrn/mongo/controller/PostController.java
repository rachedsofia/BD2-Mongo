package unrn.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unrn.mongo.api.PostServicio;
import unrn.mongo.modelo.dto.AuthorPostDTO;
import unrn.mongo.modelo.dto.PostDTO;
import unrn.mongo.modelo.dto.OtherPostDTO;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostServicio postService;

    @GetMapping("/latest")
    List<OtherPostDTO> findLatestPosts(){
        return postService.findLatestPosts();
    }

    @GetMapping("/{id}")
    List<PostDTO> findPostById(@PathVariable String id){

        return Collections.singletonList(this.postService.findPostById(id));
    }

    @GetMapping("/author/{nombreautor}")
    List<PostDTO> findPostByAuthorName(@PathVariable String nombreautor){
        return this.postService.findPostByAuthorName(nombreautor);
    }

}

package unrn.mongo.api;

import unrn.mongo.modelo.dto.AuthorPostDTO;
import unrn.mongo.modelo.dto.PostDTO;
import unrn.mongo.modelo.dto.OtherPostDTO;

import java.util.List;

public interface PostServicio {

    PostDTO findPostById(String id);
    List<OtherPostDTO> findLatestPosts();
    List<PostDTO> findPostByAuthorName(String name);
    List<PostDTO> findPostByText(String text);
    List<AuthorPostDTO> findAuthors();
    void createPost(PostDTO newPost);
}

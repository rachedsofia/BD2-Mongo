package unrn.mongo.servicio;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unrn.mongo.api.PostServicio;
import unrn.mongo.modelo.dto.AuthorPostDTO;
import unrn.mongo.modelo.dto.PostDTO;
import unrn.mongo.modelo.dto.OtherPostDTO;
import unrn.mongo.repositorio.PostRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServicioImp implements PostServicio {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDTO findPostById(String id) {

        return PostDTO.fromDocument(postRepository.findPostById(id));
    }

    @Override
    public List<OtherPostDTO> findLatestPosts() {

        List<Document> postsList = this.postRepository.findLatestPosts();

        return postsList.stream()
                .map(OtherPostDTO::fromDocument)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> findPostByAuthorName(String name) {

        List<Document> postList = this.postRepository.findPostsByAuthorName(name);

        return postList.stream()
                .map(PostDTO::fromDocument)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> findPostByText(String text) {

        List<Document> postList = this.postRepository.findPostByText(text);

        return postList.stream()
                .map(PostDTO::fromDocument)
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorPostDTO> findAuthors() {
        return this.postRepository.findAuthors().stream()
                .map(AuthorPostDTO::fromDocument)
                .collect(Collectors.toList());
    }

    @Override
    public void createPost(PostDTO newPost) {
        this.postRepository.createPost(newPost.getTitle(),
                newPost.getText(),
                newPost.getTags(),
                newPost.getResume(),
                newPost.getRelatedlinks(),
                newPost.getAuthor(),
                new Date()
        );
    }
}
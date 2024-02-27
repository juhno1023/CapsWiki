package com.example.capswiki.Domain.Post.Service;

import com.example.capswiki.DAO.Post.Post;
import com.example.capswiki.DTO.Post.RequestDTO.PostRequestDTO;
import com.example.capswiki.DTO.Post.ResponseDTO.PostResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PostServiceImplTest {

    @Autowired
    PostService postService;

    @Test
    void createPost() {
        //given
        PostRequestDTO postRequestDTO = new PostRequestDTO("홍길동", "홍길동", "내용입니다");

        //when
        postService.createPost(postRequestDTO);
        PostResponseDTO postResponseDTO = postService.getPost("홍길동");

        //then
        assertThat(postResponseDTO.getTitle()).isEqualTo("홍길동");
    }

    @Test
    void updatePost() {
        //given
        PostRequestDTO postRequestDTO = new PostRequestDTO("홍길동1", "홍길동", "내용입니다");
        postService.createPost(postRequestDTO);

        //when
        postRequestDTO = new PostRequestDTO("홍길동1", "홍길동", "수정된 내용입니다");
        Post post = postService.updatePost(postRequestDTO, "홍길동1");

        //then
        assertThat(post.getIsDeleted()).isEqualTo(1);
        assertThat(post.getContent()).isEqualTo("내용입니다");
    }
}
package com.example.capswiki.Domain.Post.Service;

import com.example.capswiki.DTO.Post.PostDTO;
import com.example.capswiki.DTO.Post.RequestDTO.PostRequestDTO;
import com.example.capswiki.Domain.Post.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static java.sql.Types.NULL;

@Service
public class PostServiceImpl implements PostService {
    @Autowired // 레포지토리와 연결
    private PostRepository postRepository;


    @Transactional //게시글 작성하는 API 구현
    public void createPost(PostRequestDTO postRequestDTO) { // 매개변수인 postRequestDTO로 작성할 정보를 전달 받음!

        //전달 받은 postRequestDTO로 부터 필요한 정보들을 get 메서드를 통해 추출!
        String writerName = postRequestDTO.getWriterName();
        String title = postRequestDTO.getTitle();
        String content = postRequestDTO.getContent();
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        // 시간은 현재 시간을 사용

        int is_deleted = 0;
        // is_deleted는 추후에 수정 기능을 구현하면서 추가 개발을 해나가면 됨. 일단은 0으로 세팅

        PostDTO postDTO = new PostDTO(
                NULL,
                title,
                content,
                writerName,
                createdDate,
                is_deleted
        );
        // 추출한 정보들을 바탕으로 PostDTO를 생성! 해당 DTO로 DB에 저장.

        postRepository.save(postDTO.toEntity());
        //레포지토리에 JPA save를 통해서 위 추출한 정보들을 DB에 저장! 이때 엔티티로 .toEntity()를 통해 변환해서 저장하여야함.
    }
}

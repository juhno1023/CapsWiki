package com.example.capswiki.Domain.Post.Repository;

import com.example.capswiki.DAO.Post.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findPostByTitle(String title); //제목으로 검색
    Post save(Post post); // 글 저장
    Post deleteByTitle(String title);

}
package com.example.capswiki.Domain.Post.Service;

import com.example.capswiki.DTO.Post.RequestDTO.PostRequestDTO;
import com.example.capswiki.DTO.Post.ResponseDTO.PostResponseDTO;

public interface PostService {

    //구현할 api들을 여기서 선언을 해두고, Service impl 파일에서 해당 기능들을 구현하는 방식
    public void createPost(PostRequestDTO postRequestDTO);
    //public PostResponseDTO getRecruitPost(int recruitPostId);
}

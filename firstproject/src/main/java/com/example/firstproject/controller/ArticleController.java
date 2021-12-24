package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static java.lang.System.out;

@Controller
@Slf4j //logging을 위한annotation
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){

        //1.  Dto를 변환->Entity
        Article article=form.toEntity();
        //logging으로 대체
        //System.out.println(article.toString());
        log.info(article.toString());

        //2.  Repository에게 Entity를 DB에 저장
        Article saved=articleRepository.save(article);
        //System.out.println(saved.toString());
    log.info(saved.toString());
        return "";
    }
}

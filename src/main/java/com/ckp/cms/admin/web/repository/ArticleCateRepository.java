package com.ckp.cms.admin.web.repository;

import com.ckp.cms.admin.web.model.ArticleCate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ecic Chen on 2015/12/18.
 */
public interface ArticleCateRepository extends JpaRepository<ArticleCate,Integer> {

    public List<ArticleCate> findByStatus(int status);
    public List<ArticleCate> findByArticleNameLikeOrArticleDescLike(String articleName,String articleDesc);
}

package com.ckp.cms.admin.web.repository;

import com.ckp.cms.admin.web.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ecic Chen on 2015/12/18.
 */
public interface ArticleRepository extends JpaRepository<Article,Integer> {

}

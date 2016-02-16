package com.ckp.cms.admin.web.repository;

import com.ckp.cms.admin.web.model.ArticleCate;
import com.ckp.cms.admin.web.model.ContentType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ecic Chen on 2016/2/2.
 */
public interface ContentTypeRepository extends JpaRepository<ContentType,Integer> {

}

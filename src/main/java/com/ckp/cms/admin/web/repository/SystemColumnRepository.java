package com.ckp.cms.admin.web.repository;

import com.ckp.cms.admin.web.model.ArticleCate;
import com.ckp.cms.admin.web.model.SystemColumn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Ecic Chen on 2015/12/18.
 */
public interface SystemColumnRepository extends JpaRepository<SystemColumn,Integer> {

    public List<SystemColumn> findByStatusOrderByParentIdAscIndexAsc(int status);

    @Query(" select count(c.id) from SystemColumn c where c.parentId =?1 ")
    public int getIndex(int parentId);

    public List<SystemColumn> findByTitleLikeOrAliasLikeOrderByIdAscIndexAsc(String title,String alias);
}

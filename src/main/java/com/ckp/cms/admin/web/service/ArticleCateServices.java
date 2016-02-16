package com.ckp.cms.admin.web.service;

import com.ckp.cms.admin.web.Constans;
import com.ckp.cms.admin.web.model.ArticleCate;
import com.ckp.cms.admin.web.repository.ArticleCateRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ecic Chen on 2016/1/21.
 */
@Service
public class ArticleCateServices {


    @Autowired
    ArticleCateRepository dao;

    public List<ArticleCate> listAllArticleCates(){
        return dao.findByStatus(Constans.STATUS_VALID);
    }

    public void AddArticleCate(ArticleCate articleCate){
        dao.save(articleCate);
    }

    public ArticleCate findArticleCateById(int id){
        return dao.findOne(id);
    }

    public void delectArticleCate(int articleCateId){
        dao.delete(articleCateId);
    }
    public void delectArticleCateAll(int[] articleCateIds){
        for (int id : articleCateIds){
            dao.delete(id);
        }
    }

    public List<ArticleCate> searchArticleCateByNameOrDesc(String searchKey){
        if(StringUtils.isBlank(searchKey) || StringUtils.equalsIgnoreCase("null",searchKey)){
            return this.listAllArticleCates();
        }
        String regularKey = "%"+searchKey+"%";
        return dao.findByArticleNameLikeOrArticleDescLike(regularKey,regularKey);
    }
}

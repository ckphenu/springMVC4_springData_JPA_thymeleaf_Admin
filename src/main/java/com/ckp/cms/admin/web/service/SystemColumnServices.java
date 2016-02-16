package com.ckp.cms.admin.web.service;

import com.ckp.cms.admin.web.Constans;
import com.ckp.cms.admin.web.model.ArticleCate;
import com.ckp.cms.admin.web.model.ContentType;
import com.ckp.cms.admin.web.model.SystemColumn;
import com.ckp.cms.admin.web.repository.ContentTypeRepository;
import com.ckp.cms.admin.web.repository.SystemColumnRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.swing.StringUIClientPropertyKey;

import java.util.List;

/**
 * Created by Ecic Chen on 2016/1/25.
 */
@Service
public class SystemColumnServices {

    @Autowired
    SystemColumnRepository systemConlumnDao;

    @Autowired
    ContentTypeRepository contentTypeDao;

    public List<SystemColumn> listAllColumns(){
        return systemConlumnDao.findByStatusOrderByParentIdAscIndexAsc(Constans.STATUS_VALID);
    }

    public List<ContentType> listAllContentType(){
        return contentTypeDao.findAll();
    }

    public void addSystemColumn(SystemColumn systemColumn){
        systemConlumnDao.save(systemColumn);
    }

    public int getLevelByParentId(int parentId){

        //如果父菜单是顶级菜单，当前菜单就是一级菜单
        if(parentId == 0){
            return 1;
        }
        int parentLevel = systemConlumnDao.findOne(parentId).getLevel();
        return parentLevel+1;
    }

    public int getIndexByParentId(int parentId){
        long count = systemConlumnDao.getIndex(parentId);
        return Long.valueOf(count + 1).intValue();
    }


    public SystemColumn findSystemColumnById(int id){
        return systemConlumnDao.findOne(id);
    }

    public void delectSystemColumn(int systemColumnId){
        systemConlumnDao.delete(systemColumnId);
    }
    public void delectSystemColumnAll(int[] systemColumnIds){
        for (int id : systemColumnIds){
            systemConlumnDao.delete(id);
        }
    }

    public List<SystemColumn> searchSystemColumnByTitleOrAlias(String searchKey){
        if(StringUtils.isBlank(searchKey) || StringUtils.equalsIgnoreCase("null",searchKey)){
            return systemConlumnDao.findByStatusOrderByParentIdAscIndexAsc(Constans.STATUS_VALID);
        }
        String regularKey = "%"+searchKey+"%";
        return systemConlumnDao.findByTitleLikeOrAliasLikeOrderByIdAscIndexAsc(regularKey, regularKey);
    }
}

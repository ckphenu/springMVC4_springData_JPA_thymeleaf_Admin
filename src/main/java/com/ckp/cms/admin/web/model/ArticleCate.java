package com.ckp.cms.admin.web.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ecic Chen on 2016/1/21.
 */
@Entity
@Table(name="T_ARTICLE_CATE")
@DynamicInsert(true)
@DynamicUpdate(true)
public class ArticleCate implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    @Temporal( TemporalType.TIMESTAMP)
    @Column(name="CREATE_TIME")
    private Date createTime;

    @Temporal( TemporalType.TIMESTAMP)
    @Column(name="UPDATE_TIME")
    private Date updateTime;

    @Column(name="status")
    private int status;

    @Column(name="ARTICLE_NAME")
    private String articleName;

    @Column(name="ARTICLE_DESC")
    private String articleDesc;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleDesc() {
        return articleDesc;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc;
    }
}

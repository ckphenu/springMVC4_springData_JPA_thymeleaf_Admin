package com.ckp.cms.admin.web.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ecic Chen on 2016/1/25.
 */
@Entity
@Table(name="t_sys_column")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SystemColumn {

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

    @Column(name="title")
    private String title;

    @Column(name="alias")
    private String alias;

    @Column(name="catalogue")
    private String catalogue;

    @Column(name="parent_id")
    private int parentId;

    @Column(name="content_type")
    private int contentType;

    @Column(name="is_need_to_html")
    private int isNeedToHtml;

    @Column(name="display_index")
    private int index;

    @Column(name="level")
    private int level;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(String catalogue) {
        this.catalogue = catalogue;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public int getIsNeedToHtml() {
        return isNeedToHtml;
    }

    public void setIsNeedToHtml(int isNeedToHtml) {
        this.isNeedToHtml = isNeedToHtml;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

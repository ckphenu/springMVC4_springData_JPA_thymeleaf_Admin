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
@Table(name="T_ARTICLE")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    /**
     * 创建时间
     */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name="CREATE_TIME")
    private Date createTime;

    /**
     *  更新时间
     */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name="UPDATE_TIME")
    private Date updateTime;

    /**
     *  允许评论的结束日期
     */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name="ALLOW_COMMENT_START_TIME")
    private Date allowCommentStartTime;

    /**
     *  允许评论的开始时间
     */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name="ALLOW_COMMENT_END_TIME")
    private Date allowCommentEndTime;


    /**
     *  审批时间
     */
    @Temporal( TemporalType.TIMESTAMP)
    @Column(name="APP_TIME")
    private Date appTime;

    /**
     * 状态
     */
    @Column(name="status")
    private int status;


    /**
     * 标题
     */
    @Column(name="head")
    private String head;

    /**
     * 副标题
     */
    @Column(name="subhead")
    private String subhead;

    /**
     * 分类栏目
     */
    @Column(name="system_column_cate")
    private int systemColumnCate;

    /**
     * 文章类型
     */
    @Column(name="article_cate")
    private int articleCate;

    /**
     * 排序值
     */
    @Column(name="display_index")
    private int displayIndex;

    /**
     * 关键字
     */
    @Column(name="keywords")
    private String keywords;

    /**
     * 文章摘要
     */
    @Column(name="digest")
    private String digest;

    /**
     *  文章来源
     */
    @Column(name="source")
    private String source;

    /**
     *  作者
     */
    @Column(name="author")
    private int author;

    /**
     * 是否允许评论
     */
    @Column(name="is_allow_comment")
    private int isAllowComment;

    /**
     *  是否使用单独模板
     */
    @Column(name="is_sole_template")
    private int isSoleTemplate;

    /**
     * 简略图
     */
    @Column(name="thumbnail")
    private String thumbnail;

    /**
     * 内容
     */
    @Column(name="contont")
    private String contont;

    /**
     *  审批人
     */
    @Column(name="app_user")
    private int appUser;


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

    public Date getAllowCommentStartTime() {
        return allowCommentStartTime;
    }

    public void setAllowCommentStartTime(Date allowCommentStartTime) {
        this.allowCommentStartTime = allowCommentStartTime;
    }

    public Date getAllowCommentEndTime() {
        return allowCommentEndTime;
    }

    public void setAllowCommentEndTime(Date allowCommentEndTime) {
        this.allowCommentEndTime = allowCommentEndTime;
    }

    public Date getAppTime() {
        return appTime;
    }

    public void setAppTime(Date appTime) {
        this.appTime = appTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getSubhead() {
        return subhead;
    }

    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    public int getSystemColumnCate() {
        return systemColumnCate;
    }

    public void setSystemColumnCate(int systemColumnCate) {
        this.systemColumnCate = systemColumnCate;
    }

    public int getArticleCate() {
        return articleCate;
    }

    public void setArticleCate(int articleCate) {
        this.articleCate = articleCate;
    }

    public int getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getIsAllowComment() {
        return isAllowComment;
    }

    public void setIsAllowComment(int isAllowComment) {
        this.isAllowComment = isAllowComment;
    }

    public int getIsSoleTemplate() {
        return isSoleTemplate;
    }

    public void setIsSoleTemplate(int isSoleTemplate) {
        this.isSoleTemplate = isSoleTemplate;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getContont() {
        return contont;
    }

    public void setContont(String contont) {
        this.contont = contont;
    }

    public int getAppUser() {
        return appUser;
    }

    public void setAppUser(int appUser) {
        this.appUser = appUser;
    }
}

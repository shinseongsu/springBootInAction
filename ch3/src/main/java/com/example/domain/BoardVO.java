package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@ToString(exclude = "member")
@Entity
public class BoardVO {

    @Id
    @GeneratedValue
    private Long seq;
    private String title;
    private String writer;
    private String content;

    @Temporal(value = TemporalType.DATE)
    private Date createDate;
    private Long cnt;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private MemberVO member;

   /* public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter(String title) {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }*/

}

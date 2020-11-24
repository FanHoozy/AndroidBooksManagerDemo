package com.example.booksmanagerdemo11.domain;


import java.io.Serializable;

/**
 * 用于接收查询的借阅表
 *
 * @author MI
 */
public class Borrows implements Serializable {
    /**
     * @borrowsBookId
     * 书的id
     */
    private String borrowsBookId;
    /**
     * @borrowsStuId
     * 学生id
     */
    private String borrowsStuId;
    /**
     * @borrowsBookName
     * 书名
     */
    private String borrowsBookName;
    /**
     * @borrowsTime
     * 借出的时间
     */
    private String borrowsTime;
    /**
     * @returnTime
     * 还书的时间
     */
    private String returnTime;
    /**
     * @damage
     * 破坏程度
     */
    private String damage;

    public String getBorrowsBookId() {
        return borrowsBookId;
    }

    public void setBorrowsBookId(String borrowsBookId) {
        this.borrowsBookId = borrowsBookId;
    }

    public String getBorrowsStuId() {
        return borrowsStuId;
    }

    public void setBorrowsStuId(String borrowsStuId) {
        this.borrowsStuId = borrowsStuId;
    }

    public String getBorrowsTime() {
        return borrowsTime;
    }

    public void setBorrowsTime(String borrowsTime) {
        this.borrowsTime = borrowsTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getBorrowsBookName() {
        return borrowsBookName;
    }

    public void setBorrowsBookName(String borrowsBookName) {
        this.borrowsBookName = borrowsBookName;
    }
}

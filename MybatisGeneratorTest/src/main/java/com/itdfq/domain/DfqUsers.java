package com.itdfq.domain;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table dfq_users
 */
public class DfqUsers {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dfq_users.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   账号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dfq_users.username
     *
     * @mbg.generated
     */
    private String username;

    /**
     * Database Column Remarks:
     *   密码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dfq_users.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     * Database Column Remarks:
     *   姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dfq_users.re_name
     *
     * @mbg.generated
     */
    private String reName;

    /**
     * Database Column Remarks:
     *   手机号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dfq_users.mobile
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     * Database Column Remarks:
     *   角色
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dfq_users.role
     *
     * @mbg.generated
     */
    private Integer role;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dfq_users.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   更新时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dfq_users.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   删除标识 0没有删除 等于id删除
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dfq_users.delete_id
     *
     * @mbg.generated
     */
    private Integer deleteId;

    /**
     * Database Column Remarks:
     *   是否是第一次登录：0-是 1-否
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dfq_users.is_first
     *
     * @mbg.generated
     */
    private Byte isFirst;

    /**
     * Database Column Remarks:
     *   上次登录时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dfq_users.last_login_time
     *
     * @mbg.generated
     */
    private Date lastLoginTime;

    /**
     * Database Column Remarks:
     *   登录iP
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dfq_users.ip_address
     *
     * @mbg.generated
     */
    private String ipAddress;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dfq_users.id
     *
     * @return the value of dfq_users.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dfq_users.id
     *
     * @param id the value for dfq_users.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dfq_users.username
     *
     * @return the value of dfq_users.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dfq_users.username
     *
     * @param username the value for dfq_users.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dfq_users.password
     *
     * @return the value of dfq_users.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dfq_users.password
     *
     * @param password the value for dfq_users.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dfq_users.re_name
     *
     * @return the value of dfq_users.re_name
     *
     * @mbg.generated
     */
    public String getReName() {
        return reName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dfq_users.re_name
     *
     * @param reName the value for dfq_users.re_name
     *
     * @mbg.generated
     */
    public void setReName(String reName) {
        this.reName = reName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dfq_users.mobile
     *
     * @return the value of dfq_users.mobile
     *
     * @mbg.generated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dfq_users.mobile
     *
     * @param mobile the value for dfq_users.mobile
     *
     * @mbg.generated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dfq_users.role
     *
     * @return the value of dfq_users.role
     *
     * @mbg.generated
     */
    public Integer getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dfq_users.role
     *
     * @param role the value for dfq_users.role
     *
     * @mbg.generated
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dfq_users.create_time
     *
     * @return the value of dfq_users.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dfq_users.create_time
     *
     * @param createTime the value for dfq_users.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dfq_users.update_time
     *
     * @return the value of dfq_users.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dfq_users.update_time
     *
     * @param updateTime the value for dfq_users.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dfq_users.delete_id
     *
     * @return the value of dfq_users.delete_id
     *
     * @mbg.generated
     */
    public Integer getDeleteId() {
        return deleteId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dfq_users.delete_id
     *
     * @param deleteId the value for dfq_users.delete_id
     *
     * @mbg.generated
     */
    public void setDeleteId(Integer deleteId) {
        this.deleteId = deleteId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dfq_users.is_first
     *
     * @return the value of dfq_users.is_first
     *
     * @mbg.generated
     */
    public Byte getIsFirst() {
        return isFirst;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dfq_users.is_first
     *
     * @param isFirst the value for dfq_users.is_first
     *
     * @mbg.generated
     */
    public void setIsFirst(Byte isFirst) {
        this.isFirst = isFirst;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dfq_users.last_login_time
     *
     * @return the value of dfq_users.last_login_time
     *
     * @mbg.generated
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dfq_users.last_login_time
     *
     * @param lastLoginTime the value for dfq_users.last_login_time
     *
     * @mbg.generated
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dfq_users.ip_address
     *
     * @return the value of dfq_users.ip_address
     *
     * @mbg.generated
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dfq_users.ip_address
     *
     * @param ipAddress the value for dfq_users.ip_address
     *
     * @mbg.generated
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dfq_users
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", reName=").append(reName);
        sb.append(", mobile=").append(mobile);
        sb.append(", role=").append(role);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteId=").append(deleteId);
        sb.append(", isFirst=").append(isFirst);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", ipAddress=").append(ipAddress);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dfq_users
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DfqUsers other = (DfqUsers) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getReName() == null ? other.getReName() == null : this.getReName().equals(other.getReName()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteId() == null ? other.getDeleteId() == null : this.getDeleteId().equals(other.getDeleteId()))
            && (this.getIsFirst() == null ? other.getIsFirst() == null : this.getIsFirst().equals(other.getIsFirst()))
            && (this.getLastLoginTime() == null ? other.getLastLoginTime() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))
            && (this.getIpAddress() == null ? other.getIpAddress() == null : this.getIpAddress().equals(other.getIpAddress()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dfq_users
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getReName() == null) ? 0 : getReName().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteId() == null) ? 0 : getDeleteId().hashCode());
        result = prime * result + ((getIsFirst() == null) ? 0 : getIsFirst().hashCode());
        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());
        result = prime * result + ((getIpAddress() == null) ? 0 : getIpAddress().hashCode());
        return result;
    }
}
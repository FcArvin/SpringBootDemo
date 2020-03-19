package com.example.demo.po;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "tb_sbuser")
public class TbSbuser {
  
	@Id
    @Column(name = "ID")
	private String id = UUID.randomUUID().toString().replace("-", "");

    /**
     * 用户姓名
     */
    @Column(name = "UserName")
    private String username;

    /**
     * 用户年龄
     */
    @Column(name = "UserAge")
    private Integer userage;

    /**
     * 用户生日
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
    @Column(name = "UserBirthday")
    private Date userbirthday;

    /**
     * 用户地址
     */
    @Column(name = "UserAddress")
    private String useraddress;

    /**
     * 用户电话
     */
    @Column(name = "UserTelephone")
    private String usertelephone;

    /**
     * 用户邮箱
     */
    @Column(name = "UserEmail")
    private String useremail;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;

    /**
     * 创建人
     */
    @Column(name = "CreateBy")
    private String createby;

    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
    @Column(name = "CreateDate")
    private Date createdate;

    /**
     * 更新人
     */
    @Column(name = "UpdateBy")
    private String updateby;

    /**
     * 更新时间
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
    @Column(name = "UpdateDate")
    private Date updatedate;

    /**
     * 获取用户姓名
     *
     * @return ID - 用户姓名
     */
    public String getId() {
        return id;
    }

    /**
     * 设置用户姓名
     *
     * @param id 用户姓名
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return UserName
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取用户年龄
     *
     * @return UserAge - 用户年龄
     */
    public Integer getUserage() {
        return userage;
    }

    /**
     * 设置用户年龄
     *
     * @param userage 用户年龄
     */
    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    /**
     * 获取用户生日
     *
     * @return UserBirthday - 用户生日
     */
    public Date getUserbirthday() {
        return userbirthday;
    }

    /**
     * 设置用户生日
     *
     * @param userbirthday 用户生日
     */
    public void setUserbirthday(Date userbirthday) {
        this.userbirthday = userbirthday;
    }

    /**
     * 获取用户地址
     *
     * @return UserAddress - 用户地址
     */
    public String getUseraddress() {
        return useraddress;
    }

    /**
     * 设置用户地址
     *
     * @param useraddress 用户地址
     */
    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    /**
     * 获取用户电话
     *
     * @return UserTelephone - 用户电话
     */
    public String getUsertelephone() {
        return usertelephone;
    }

    /**
     * 设置用户电话
     *
     * @param usertelephone 用户电话
     */
    public void setUsertelephone(String usertelephone) {
        this.usertelephone = usertelephone;
    }

    /**
     * 获取用户邮箱
     *
     * @return UserEmail - 用户邮箱
     */
    public String getUseremail() {
        return useremail;
    }

    /**
     * 设置用户邮箱
     *
     * @param useremail 用户邮箱
     */
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取创建人
     *
     * @return CreateBy - 创建人
     */
    public String getCreateby() {
        return createby;
    }

    /**
     * 设置创建人
     *
     * @param createby 创建人
     */
    public void setCreateby(String createby) {
        this.createby = createby;
    }

    /**
     * 获取创建时间
     *
     * @return CreateDate - 创建时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置创建时间
     *
     * @param createdate 创建时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取更新人
     *
     * @return UpdateBy - 更新人
     */
    public String getUpdateby() {
        return updateby;
    }

    /**
     * 设置更新人
     *
     * @param updateby 更新人
     */
    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    /**
     * 获取更新时间
     *
     * @return UpdateDate - 更新时间
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置更新时间
     *
     * @param updatedate 更新时间
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }
    
	public TbSbuser() {
		super();
	}

	public TbSbuser(String id, String username, Integer userage, Date userbirthday, String useraddress,
			String usertelephone, String useremail, String remark, String createby, Date createdate, String updateby,
			Date updatedate) {
		super();
		this.id = id;
		this.username = username;
		this.userage = userage;
		this.userbirthday = userbirthday;
		this.useraddress = useraddress;
		this.usertelephone = usertelephone;
		this.useremail = useremail;
		this.remark = remark;
		this.createby = createby;
		this.createdate = createdate;
		this.updateby = updateby;
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "TbSbuser [id=" + id + ", username=" + username + ", userage=" + userage + ", userbirthday="
				+ userbirthday + ", useraddress=" + useraddress + ", usertelephone=" + usertelephone + ", useremail="
				+ useremail + ", remark=" + remark + ", createby=" + createby + ", createdate=" + createdate
				+ ", updateby=" + updateby + ", updatedate=" + updatedate + "]";
	}
    
}
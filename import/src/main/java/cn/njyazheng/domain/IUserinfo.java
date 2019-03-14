package cn.njyazheng.domain;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2019-03-14
*/
@Table(name="test.I_USERINFO")
public class IUserinfo   {
	
	/*
	用户的业务帐号
	*/
    @AssignID
	private String loginaccount ;
	/*
	0:身份证 1:驾驶证 2:军官证 3:其他
	*/
	private Integer certtype ;
	/*
	0：中文；1：英文
	*/
	private Integer languagepref ;
	private String address ;
	private String certificate ;
	private String createoperator ;
	private String email ;
	private String modifyoperator ;
	private String phonenum ;
	private String username ;
	/*
	用户开户时间
	*/
	private Date createtime ;
	/*
	用户最近修改时间
	*/
	private Date modifytime ;
	
	public IUserinfo() {
	}
	
	/**
	* 用户的业务帐号
	*@return 
	*/
	public String getLoginaccount(){
		return  loginaccount;
	}
	/**
	* 用户的业务帐号
	*@param  loginaccount
	*/
	public void setLoginaccount(String loginaccount ){
		this.loginaccount = loginaccount;
	}
	
	/**
	* 0:身份证 1:驾驶证 2:军官证 3:其他
	*@return 
	*/
	public Integer getCerttype(){
		return  certtype;
	}
	/**
	* 0:身份证 1:驾驶证 2:军官证 3:其他
	*@param  certtype
	*/
	public void setCerttype(Integer certtype ){
		this.certtype = certtype;
	}
	
	/**
	* 0：中文；1：英文
	*@return 
	*/
	public Integer getLanguagepref(){
		return  languagepref;
	}
	/**
	* 0：中文；1：英文
	*@param  languagepref
	*/
	public void setLanguagepref(Integer languagepref ){
		this.languagepref = languagepref;
	}
	
	public String getAddress(){
		return  address;
	}
	public void setAddress(String address ){
		this.address = address;
	}
	
	public String getCertificate(){
		return  certificate;
	}
	public void setCertificate(String certificate ){
		this.certificate = certificate;
	}
	
	public String getCreateoperator(){
		return  createoperator;
	}
	public void setCreateoperator(String createoperator ){
		this.createoperator = createoperator;
	}
	
	public String getEmail(){
		return  email;
	}
	public void setEmail(String email ){
		this.email = email;
	}
	
	public String getModifyoperator(){
		return  modifyoperator;
	}
	public void setModifyoperator(String modifyoperator ){
		this.modifyoperator = modifyoperator;
	}
	
	public String getPhonenum(){
		return  phonenum;
	}
	public void setPhonenum(String phonenum ){
		this.phonenum = phonenum;
	}
	
	public String getUsername(){
		return  username;
	}
	public void setUsername(String username ){
		this.username = username;
	}
	
	/**
	* 用户开户时间
	*@return 
	*/
	public Date getCreatetime(){
		return  createtime;
	}
	/**
	* 用户开户时间
	*@param  createtime
	*/
	public void setCreatetime(Date createtime ){
		this.createtime = createtime;
	}
	
	/**
	* 用户最近修改时间
	*@return 
	*/
	public Date getModifytime(){
		return  modifytime;
	}
	/**
	* 用户最近修改时间
	*@param  modifytime
	*/
	public void setModifytime(Date modifytime ){
		this.modifytime = modifytime;
	}
	

}

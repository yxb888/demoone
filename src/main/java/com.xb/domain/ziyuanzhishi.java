package com.xb.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ziyuanzhishi {
    private String tId;             //主键id 
                                  
    private String tTitle;          //知识标题
                                   
    private String tTypeName;       //类型名称
                                 
    private String tKeyword;        //关键字
                                   
    private String tIssur;          //发布人
    
    @DateTimeFormat(pattern="yyyy-MM-dd")                           
    private Date tReleasetime; 	//发布时间
    								

    private String tFujianNumber;   //附件数
    
    private String tZhishiFujian; //知识附件
    
    private String tZhishiConent;//知识内容
    
    private String tReleasetimeStr;//时间转换
   
    private ziyuanzhishitype  ziyuanzhishitype; //从表两表关联

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String gettTitle() {
		return tTitle;
	}

	public void settTitle(String tTitle) {
		this.tTitle = tTitle;
	}

	public String gettTypeName() {
		return tTypeName;
	}

	public void settTypeName(String tTypeName) {
		this.tTypeName = tTypeName;
	}

	public String gettKeyword() {
		return tKeyword;
	}

	public void settKeyword(String tKeyword) {
		this.tKeyword = tKeyword;
	}

	public String gettIssur() {
		return tIssur;
	}

	public void settIssur(String tIssur) {
		this.tIssur = tIssur;
	}

	public Date gettReleasetime() {
		return tReleasetime;
	}

	public void settReleasetime(Date tReleasetime) {
		this.tReleasetime = tReleasetime;
	}

	public String gettFujianNumber() {
		return tFujianNumber;
	}

	public void settFujianNumber(String tFujianNumber) {
		this.tFujianNumber = tFujianNumber;
	}

	public String gettReleasetimeStr() {
		SimpleDateFormat S = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return S.format(tReleasetime);
	}

	public void settReleasetimeStr(String tReleasetimeStr) {
		this.tReleasetimeStr = tReleasetimeStr;
	}

	public ziyuanzhishitype getZiyuanzhishitype() {
		return ziyuanzhishitype;
	}

	public void setZiyuanzhishitype(ziyuanzhishitype ziyuanzhishitype) {
		this.ziyuanzhishitype = ziyuanzhishitype;
	}

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "ziyuanzhishi [tId=" + tId + ", tTitle=" + tTitle + ", tTypeName=" + tTypeName + ", tKeyword=" + tKeyword
				+ ", tIssur=" + tIssur + ", tReleasetime=" + tReleasetime + ", tFujianNumber=" + tFujianNumber
				+ ", tReleasetimeStr=" + tReleasetimeStr + ", ziyuanzhishitype=" + ziyuanzhishitype + "]";
	}
    


	



	

	
	
}
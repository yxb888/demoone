package com.xb.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pact {
	private String username;
	
    private String pactid;

    private String pactname;

    private String pactusername;

    private Integer pactzt;

    private Integer timetype;

    private Integer pacttype;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date starttime;
    
   
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endtime;
    

	private String pactmatter;

    private String pactaccessory;
    
    private String starttimeStr;
    private String endtimeStr;

    private String pactUserNameStr;
    private String pactNameStr;		
    

	public String getStarttimeStr() {
		return starttimeStr;
	}

	public void setStarttimeStr(String starttimeStr) {
		this.starttimeStr = starttimeStr;
	}

	public String getEndtimeStr() {
		SimpleDateFormat A = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return A.format(this.getEndtime());
	}

	public void setEndtimeStr(String endtimeStr) {
		this.endtimeStr = endtimeStr;
	}

	public String getPactid() {
        return pactid;
    }

    public void setPactid(String pactid) {
        this.pactid = pactid == null ? null : pactid.trim();
    }

    public String getPactname() {
        return pactname;
    }

    public void setPactname(String pactname) {
        this.pactname = pactname == null ? null : pactname.trim();
    }

    public String getPactusername() {
        return pactusername;
    }

    public void setPactusername(String pactusername) {
        this.pactusername = pactusername == null ? null : pactusername.trim();
    }

    public Integer getPactzt() {
        return pactzt;
    }

    public void setPactzt(Integer pactzt) {
        this.pactzt = pactzt;
    }

    public Integer getTimetype() {
        return timetype;
    }

    public void setTimetype(Integer timetype) {
        this.timetype = timetype;
    }

    public Integer getPacttype() {
        return pacttype;
    }

    public void setPacttype(Integer pacttype) {
        this.pacttype = pacttype;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getPactmatter() {
        return pactmatter;
    }

    public void setPactmatter(String pactmatter) {
        this.pactmatter = pactmatter == null ? null : pactmatter.trim();
    }

    public String getPactaccessory() {
        return pactaccessory;
    }

    public void setPactaccessory(String pactaccessory) {
        this.pactaccessory = pactaccessory == null ? null : pactaccessory.trim();
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPactUserNameStr() {
		return pactUserNameStr;
	}

	public void setPactUserNameStr(String pactUserNameStr) {
		this.pactUserNameStr = pactUserNameStr;
	}

	public String getPactNameStr() {
		return pactNameStr;
	}

	public void setPactNameStr(String pactNameStr) {
		this.pactNameStr = pactNameStr;
	}

	@Override
	public String toString() {
		return "Pact [username=" + username + ", pactid=" + pactid + ", pactname=" + pactname + ", pactusername="
				+ pactusername + ", pactzt=" + pactzt + ", timetype=" + timetype + ", pacttype=" + pacttype
				+ ", starttime=" + starttime + ", endtime=" + endtime + ", pactmatter=" + pactmatter
				+ ", pactaccessory=" + pactaccessory + ", starttimeStr=" + starttimeStr + ", endtimeStr=" + endtimeStr
				+ "]";
	}
  
}
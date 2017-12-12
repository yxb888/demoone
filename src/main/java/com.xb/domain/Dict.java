package com.xb.domain;

import java.io.Serializable;

public class Dict implements Serializable {
    private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	private String dictId;

    private String dictCode;

    private Integer dictIfchange;
    private String dictTreeid;
    private DictTree dicttree;


    

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Dict(String dictId, String dictCode, Integer dictIfchange, String dictTreeid, DictTree dicttree) {
		super();
		this.dictId = dictId;
		this.dictCode = dictCode;
		this.dictIfchange = dictIfchange;
		this.dictTreeid = dictTreeid;
		this.dicttree = dicttree;
	}

	public DictTree getDicttree() {
		return dicttree;
	}

	public void setDicttree(DictTree dicttree) {
		this.dicttree = dicttree;
	}

	public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId == null ? null : dictId.trim();
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode == null ? null : dictCode.trim();
    }

    public Integer getDictIfchange() {
        return dictIfchange;
    }

    public void setDictIfchange(Integer dictIfchange) {
        this.dictIfchange = dictIfchange;
    }



	public Dict() {
		super();
	}

	public String getDictTreeid() {
		return dictTreeid;
	}

	public void setDictTreeid(String dictTreeid) {
		this.dictTreeid = dictTreeid;
	}



	@Override
	public String toString() {
		return "Dict [dictId=" + dictId + ", dictCode=" + dictCode + ", dictIfchange=" + dictIfchange + ", dictTreeid="
				+ dictTreeid + ", dicttree=" + dicttree + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dictCode == null) ? 0 : dictCode.hashCode());
		result = prime * result + ((dictId == null) ? 0 : dictId.hashCode());
		result = prime * result + ((dictIfchange == null) ? 0 : dictIfchange.hashCode());
		result = prime * result + ((dictTreeid == null) ? 0 : dictTreeid.hashCode());
		result = prime * result + ((dicttree == null) ? 0 : dicttree.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dict other = (Dict) obj;
		if (dictCode == null) {
			if (other.dictCode != null)
				return false;
		} else if (!dictCode.equals(other.dictCode))
			return false;
		if (dictId == null) {
			if (other.dictId != null)
				return false;
		} else if (!dictId.equals(other.dictId))
			return false;
		if (dictIfchange == null) {
			if (other.dictIfchange != null)
				return false;
		} else if (!dictIfchange.equals(other.dictIfchange))
			return false;
		if (dictTreeid == null) {
			if (other.dictTreeid != null)
				return false;
		} else if (!dictTreeid.equals(other.dictTreeid))
			return false;
		if (dicttree == null) {
			if (other.dicttree != null)
				return false;
		} else if (!dicttree.equals(other.dicttree))
			return false;
		return true;
	}
    		
}
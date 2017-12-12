package com.xb.domain;

public class ziyuanzhishitype {
    private String tTypeId;

    private String tType;

    private String tExplain;

    private String tCount;

    public String gettTypeId() {
        return tTypeId;
    }

    public void settTypeId(String tTypeId) {
        this.tTypeId = tTypeId == null ? null : tTypeId.trim();
    }

    public String gettType() {
        return tType;
    }

    public void settType(String tType) {
        this.tType = tType == null ? null : tType.trim();
    }

    public String gettExplain() {
        return tExplain;
    }

    public void settExplain(String tExplain) {
        this.tExplain = tExplain == null ? null : tExplain.trim();
    }

    public String gettCount() {
        return tCount;
    }

    public void settCount(String tCount) {
        this.tCount = tCount == null ? null : tCount.trim();
    }

	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "ziyuanzhishitype [tTypeId=" + tTypeId + ", tType=" + tType + ", tExplain=" + tExplain + ", tCount="
				+ tCount + "]";
	}
    
}
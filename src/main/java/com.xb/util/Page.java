package com.xb.util;


import java.util.List;

public class Page {

	private List list; // ���صļ���
	private int totalpage; // ����zongҳ��
	private int totalcount; // �����ܼ�¼��
	private int pagesize = 4; // ����ÿҳ��¼��
	private int start;
	private int cpage = 1;// ���մ��ݽ����ķ�ҳ��λ

	public Page(int totalcount, int pagesize, int cpage) {
		super();
		this.totalpage = totalcount / pagesize;

		if (totalcount % pagesize != 0) {

			this.totalpage = totalpage + 1;

		}
		this.totalcount = totalcount;
		this.pagesize = pagesize;

		if (cpage <= 0) {

			cpage = 1;

		}

		if (cpage > totalpage) {

			cpage = totalpage;

		}

		this.start = (cpage - 1) * pagesize;
		this.cpage = cpage;
	}

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getCpage() {
		return cpage;
	}

	public void setCpage(int cpage) {
		this.cpage = cpage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

}

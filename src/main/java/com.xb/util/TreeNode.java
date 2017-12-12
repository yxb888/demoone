package com.xb.util;

import java.util.List;
import java.util.Map;


public class TreeNode
{
	//树节点ID
	private String id;
	//树节点名称
	private String text;
	//树前面的小图标样式
	private String iconCls;
	//是否勾选状态
	private String checked;
	//树的其它参数
	private Map<String,Object> attributes;
	//树的节点是否展开(open,closed)
	private String state = "open";
	//树的子节点
	private List<TreeNode> children;
	public TreeNode()
	{
		super();
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getText()
	{
		return text;
	}
	public void setText(String text)
	{
		this.text = text;
	}
	public String getIconCls()
	{
		return iconCls;
	}
	public void setIconCls(String iconCls)
	{
		this.iconCls = iconCls;
	}
	public String getChecked()
	{
		return checked;
	}
	public void setChecked(String checked)
	{
		this.checked = checked;
	}
	public Map<String, Object> getAttributes()
	{
		return attributes;
	}
	public void setAttributes(Map<String, Object> attributes)
	{
		this.attributes = attributes;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public List<TreeNode> getChildren()
	{
		return children;
	}
	public void setChildren(List<TreeNode> children)
	{
		this.children = children;
	}
	
	
}

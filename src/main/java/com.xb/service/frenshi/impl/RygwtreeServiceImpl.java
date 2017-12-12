package com.xb.service.frenshi.impl;

import com.xb.dao.frenshi.RygwtreeMapper;
import com.xb.dao.frenshi.RygwzutreeMapper;
import com.xb.domain.Rygwtree;
import com.xb.domain.Rygwzutree;
import com.xb.service.frenshi.RygwtreeService;
import com.xb.util.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RygwtreeServiceImpl implements RygwtreeService {
	private TreeNode treeNode;
	@Autowired
	private RygwtreeMapper rygwtreeMapper;
	
	@Override
	public List<Rygwtree> queryZuTree() {
		// TODO Auto-generated method stub
		return rygwtreeMapper.queryZuTree();
	}
	
	@Autowired
	private RygwzutreeMapper rygwzutreeMapper;
	
	@Override
	public List<Rygwzutree> queryRygwzutree() {
		// TODO Auto-generated method stub
		return rygwzutreeMapper.queryRygwzutree();
	}

	@Override
	public List<Rygwtree> queryZuTreeOnse(String id) {
		// TODO Auto-generated method stub
		System.out.println("aa");
		return rygwtreeMapper.queryZuTreeOnse(id);
	
	}

//	@SuppressWarnings("rawtypes")
	public List<TreeNode> queryRootNode(String valueOf) {
		// TODO Auto-generated method stub
		
		List<TreeNode> treeList = new ArrayList<TreeNode>();
		List<Rygwtree> orgList = rygwtreeMapper.getAllGroupAsTree(valueOf);
		if(orgList != null && orgList.size() > 0){
			for (int i = 0; i < orgList.size(); i++) {
				treeNode = new TreeNode();
				treeNode.setId(orgList.get(i).getId().toString());
				treeNode.setText(orgList.get(i).getText().toString());
//				treeNode.setState("open");
				queryRootNode1(treeNode,orgList.get(i).getId().toString());	
				treeList.add(treeNode);
			}
			
			
//		for ( Map map : orgList) {
//			treeNode = new TreeNode();
//			treeNode.setId(map.get("id").toString());
//			treeNode.setText(map.get("text").toString());
//			treeNode.setState("open");
//			queryRootNode1(treeNode,map.get("pid").toString());	
//			treeList.add(treeNode);
//		}
	}
		return treeList;
	}
	public void queryRootNode1(TreeNode treeNode1,String id){
		List<Rygwtree>  children1 = rygwtreeMapper.getAllOrgsTree(id);
		if(children1!=null&&children1.size()>0){
			List<TreeNode> treeList2 = new ArrayList<TreeNode>();		
			for (Rygwtree orgInfo2 : children1) {	
				TreeNode treeNode2 = new TreeNode();
				treeNode2.setId(orgInfo2.getId().toString());
				treeNode2.setText(orgInfo2.getText().toString());
				treeNode2.setState("open");
				queryRootNode1(treeNode2,orgInfo2.getId().toString());
				treeList2.add(treeNode2);
			}
			treeNode1.setChildren(treeList2);
			System.out.println(treeNode1);
		}
	}
}

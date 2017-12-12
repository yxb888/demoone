package com.xb.service.frenshi;

import com.xb.domain.Rygwtree;
import com.xb.domain.Rygwzutree;
import com.xb.util.TreeNode;

import java.util.List;

public interface RygwtreeService {

	List<Rygwtree> queryZuTree();

	List<Rygwzutree> queryRygwzutree();

	List<Rygwtree> queryZuTreeOnse(String id);

	List<TreeNode> queryRootNode(String valueOf);


}

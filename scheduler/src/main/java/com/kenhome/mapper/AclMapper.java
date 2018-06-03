
package com.kenhome.mapper;

import java.util.List;

import com.kenhome.model.Acl;



public interface AclMapper extends BaseMapper<Acl> {
	
	//获得根资源（包含下级资源）
	Acl selectRootAndChildAcl();
	
	//获得子资源（包含下级资源）
	List<Acl> selectChildAcls(Long aclNo);
	
}

package com.kenhome.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**      
 * @date:       
 */
public class Acl implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    //主键ID
    private Long ID;
    //资源编号
    private Long aclNo;
    //创建时间
    private Date createDate;
    //修改时间
    private Date updateDate;
    //创建者，不用ID存储是因为创建者被删将不知道是谁，故采用不可修改的用户名
    private String creater;
    //修改者
    private String updater;
    //资源名
    private String aclName;
    //资源地址，注：地址不带上服务器部分，方便日后迁移服务器
    private String aclUrl;
    //资源等级，1:父菜单，2:子菜单，3：第三级；
    private Integer aclGrade;
    //资源类型
    private Integer aclType;
    //权限标识
    private String permission;
    //图标
    private String icon;
    //父级ID
    private Long parentNo;
    //排序
    private Integer sort;
    //子资源集合
    private List<Acl> childAcls;
    
    public Long getID(){
        return ID;
    }
    public void setID (Long ID){
        this.ID = ID;
    }
    public Long getAclNo(){
        return aclNo;
    }
    public void setAclNo (Long aclNo){
        this.aclNo = aclNo;
    }
    public Date getCreateDate(){
        return createDate;
    }
    public void setCreateDate (Date createDate){
        this.createDate = createDate;
    }
    public Date getUpdateDate(){
        return updateDate;
    }
    public void setUpdateDate (Date updateDate){
        this.updateDate = updateDate;
    }
    public String getCreater(){
        return creater;
    }
    public void setCreater (String creater){
        this.creater = creater;
    }
    public String getUpdater(){
        return updater;
    }
    public void setUpdater (String updater){
        this.updater = updater;
    }
    public String getAclName(){
        return aclName;
    }
    public void setAclName (String aclName){
        this.aclName = aclName;
    }
    public String getAclUrl(){
        return aclUrl;
    }
    public void setAclUrl (String aclUrl){
        this.aclUrl = aclUrl;
    }
    public Integer getAclGrade(){
        return aclGrade;
    }
    public void setAclGrade (Integer aclGrade){
        this.aclGrade = aclGrade;
    }
    public Integer getAclType(){
        return aclType;
    }
    public void setAclType (Integer aclType){
        this.aclType = aclType;
    }
    public String getPermission(){
        return permission;
    }
    public void setPermission (String permission){
        this.permission = permission;
    }
    public String getIcon(){
        return icon;
    }
    public void setIcon (String icon){
        this.icon = icon;
    }
    public Long getParentNo(){
        return parentNo;
    }
    public void setParentNo (Long parentNo){
        this.parentNo = parentNo;
    }
    public Integer getSort(){
        return sort;
    }
    public void setSort (Integer sort){
        this.sort = sort;
    }
	public List<Acl> getChildAcls() {
		return childAcls;
	}
	public void setChildAcls(List<Acl> childAcls) {
		this.childAcls = childAcls;
	}
    
    
}
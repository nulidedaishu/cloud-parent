package com.itany.entity;

public class RolePermission {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role_permission.id
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role_permission.roleid
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    private Integer roleid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role_permission.permissionid
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    private Integer permissionid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role_permission.id
     *
     * @return the value of t_role_permission.id
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role_permission.id
     *
     * @param id the value for t_role_permission.id
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role_permission.roleid
     *
     * @return the value of t_role_permission.roleid
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role_permission.roleid
     *
     * @param roleid the value for t_role_permission.roleid
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role_permission.permissionid
     *
     * @return the value of t_role_permission.permissionid
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    public Integer getPermissionid() {
        return permissionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role_permission.permissionid
     *
     * @param permissionid the value for t_role_permission.permissionid
     *
     * @mbggenerated Sat Dec 14 10:39:12 CST 2024
     */
    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }
}
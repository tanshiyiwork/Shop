package com.wonders.shop.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ADMIN", schema = "SHOP")
public class AdminEntity  implements java.io.Serializable {
    private String stId;
    private String stName;
    private String stPwd;

    public AdminEntity() {
    }

    public AdminEntity(String stId, String stName, String stPwd) {
        this.stId = stId;
        this.stName = stName;
        this.stPwd = stPwd;
    }

    @Id
    @Column(name = "ST_ID" ,unique = true, nullable = false, length = 50)
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator",strategy = "uuid")
    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    @Basic
    @Column(name = "ST_NAME",length = 100)
    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    @Basic
    @Column(name = "ST_PWD" ,length = 50)
    public String getStPwd() {
        return stPwd;
    }

    public void setStPwd(String stPwd) {
        this.stPwd = stPwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminEntity that = (AdminEntity) o;
        return Objects.equals(stId, that.stId) &&
                Objects.equals(stName, that.stName) &&
                Objects.equals(stPwd, that.stPwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stId, stName, stPwd);
    }
}

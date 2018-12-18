package com.wonders.shop.common;

import com.wonders.shop.entity.AdminEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class AdminDao {
    private static Configuration conf;
    private static SessionFactory factory;
    private static Transaction ts;

    static {
        try {
            conf = new Configuration().configure();
            factory=conf.buildSessionFactory();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    public static Session getSession(){
        // 新的方法，需要和事务一起使用，可以保证每个用户创建的session独立，需要在配置文件中配置
        //<property name="current_session_context_class">thread</property>
        return  factory.getCurrentSession();
    }

    public List<AdminEntity> getAdmin(){
        List<AdminEntity> adminList=null;
        Session session=getSession();
        if(session!=null){
            try {
                String hql = "from Student";
                Query query = session.createQuery(hql);
                adminList = query.list();
            } catch (HibernateException e) {
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
        return adminList;
    }

    public AdminEntity getAdminById(String stId) {
        AdminEntity admin = null;
        Session session = getSession();
        if (session != null) {
            try {
                // get如果没有查询到数据，则返回null
                // admin = (Student) session.get(AdminEntity.class, stId);
                // load如果没有查询到数据，则抛出异常
                admin = (AdminEntity) session.load(AdminEntity.class, stId);
            } catch (HibernateException e) {
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
        return admin;
    }

    public boolean addAdmin(AdminEntity admin) {
        boolean result = false;
        Session session = getSession();
        if (session != null) {
            try {
                // 开启一个事务
                ts = session.beginTransaction();
                // 保存
                session.save(admin);
                // 提交事务
                ts.commit();
                return true;
            } catch (HibernateException e) {
                e.printStackTrace();
                ts.rollback();
            } finally {
                session.close();
            }
        }
        return result;
    }

    public boolean deleteAdmin(String stId) {
        boolean result = false;
        Session session = getSession();
        if (session != null) {
            try {
                // 开启一个事务
                ts = session.beginTransaction();
                // 获取一个学生对象
                AdminEntity admin = (AdminEntity) session.load(AdminEntity.class, stId);
                // 删除操作
                session.delete(admin);
                // 提交事务
                ts.commit();
                return true;
            } catch (HibernateException e) {
                e.printStackTrace();
                ts.rollback();
            } finally {
                session.close();
            }
        }
        return result;
    }
}

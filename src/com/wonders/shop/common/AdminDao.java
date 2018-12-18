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
        // �µķ�������Ҫ������һ��ʹ�ã����Ա�֤ÿ���û�������session��������Ҫ�������ļ�������
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
                // get���û�в�ѯ�����ݣ��򷵻�null
                // admin = (Student) session.get(AdminEntity.class, stId);
                // load���û�в�ѯ�����ݣ����׳��쳣
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
                // ����һ������
                ts = session.beginTransaction();
                // ����
                session.save(admin);
                // �ύ����
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
                // ����һ������
                ts = session.beginTransaction();
                // ��ȡһ��ѧ������
                AdminEntity admin = (AdminEntity) session.load(AdminEntity.class, stId);
                // ɾ������
                session.delete(admin);
                // �ύ����
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

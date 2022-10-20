package repository;

import model.Department;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.DepartmentRepository;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public  class DepRepoHiber implements DepartmentRepository {

    @Override
    public List<Department> findAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Department ", Department.class).list();
        }

    }

    public Department findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Department.class, id);
    }

    public int create(Department department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(department);
        tx1.commit();
        session.close();
        return 0;
    }

    public int update(Department department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(department);
        tx1.commit();
        session.close();
        return 0;
    }

    public int delete(int department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(department);
        tx1.commit();
        session.close();

        return department;
    }













    }

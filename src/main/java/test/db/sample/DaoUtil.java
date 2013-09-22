package test.db.sample;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DaoUtil {

    private SqlSessionFactory sessionFactory;
    private static DaoUtil inst = new DaoUtil();

    private DaoUtil() {
        sessionFactory = createSqlSessionFactory();
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return inst.sessionFactory;
    }

    private SqlSessionFactory createSqlSessionFactory() {
        SqlSessionFactory ssf = null;

        try {
            ssf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ssf;
    }


}

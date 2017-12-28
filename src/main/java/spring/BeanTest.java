package spring;

import java.util.Iterator;
import java.util.Map;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-12-26 16:09
 */
public class BeanTest {

    private DaoTest daoTest;
    private String year;
    private Map<String, Float> adminEmails;


//    /**
//     * 构造器注入
//     *
//     * @param daoTest
//     */
//    public BeanTest(DaoTest daoTest) {
//        this.daoTest = daoTest;
//    }

    //    public BeanTest(DaoTest daoTest, String year) {
//        this.daoTest = daoTest;
//        this.year = year;
//    }

//    @ConstructorProperties({"daoTest", "year"})
//    public BeanTest(DaoTest daoTest, String year) {
//        this.daoTest = daoTest;
//        this.year = year;
//    }

    void SyaHello() {
//        System.out.println("welcome to me!");
//        String s = daoTest.SyaDao("李栋梁");
//        System.out.println(s + " " + this.year);

        Iterator it = adminEmails.keySet().iterator();
        Object key;
        Object value;
        while (it.hasNext()) {
            key = it.next();
            value = adminEmails.get(key);
            System.out.println(key + ":" + value);
        }
    }

    public Map<String, Float> getAdminEmails() {
        return adminEmails;
    }

    public void setAdminEmails(Map<String, Float> adminEmails) {
        this.adminEmails = adminEmails;
    }

    //    /**
//     * Set/Get 注入
//     */
//    public void setDaoTest(DaoTest daoTest) {
//        this.daoTest = daoTest;
//    }
//
//    public DaoTest getDaoTest() {
//        return daoTest;
//    }
}

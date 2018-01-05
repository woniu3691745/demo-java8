package spring.bean;

import java.util.List;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2018-01-04 8:51
 */
public class BeanFirst {

    private List sourceList;

    @SuppressWarnings("unchecked")
    public void getFirstBean() {
        sourceList.forEach(System.out::println);
        System.out.println("this is first bean test");
    }

    public void setSourceList(List sourceList) {
        this.sourceList = sourceList;
    }

    public List getSourceList() {
        return sourceList;
    }
}

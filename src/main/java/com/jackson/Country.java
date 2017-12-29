package com.jackson;

import java.util.*;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-12-28 11:32
 */
public class Country {

    // 注意：被序列化的bean的private属性字段需要创建getter方法或者属性字段应该为public
    private String country_id;
    private Date birthDate;
    private List<String> nation = new ArrayList<>();
    private String[] lakes;
    private List<Province> provinces = new ArrayList<>();
    private Map<String, Integer> traffic = new HashMap<>();

    public Country() {
        // TODO Auto-generated constructor stub
    }

    public Country(String countryId) {
        this.country_id = countryId;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getNation() {
        return nation;
    }

    public void setNation(List<String> nation) {
        this.nation = nation;
    }

    public String[] getLakes() {
        return lakes;
    }

    public void setLakes(String[] lakes) {
        this.lakes = lakes;
    }

    public Integer get(String key) {
        return traffic.get(key);
    }

    public Map<String, Integer> getTraffic() {
        return traffic;
    }

    public void setTraffic(Map<String, Integer> traffic) {
        this.traffic = traffic;
    }

    public void addTraffic(String key, Integer value) {
        traffic.put(key, value);
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    @Override
    public String toString() {
        return "Country [country_id=" + country_id + ", birthDate=" + birthDate
                + ", nation=" + nation + ", lakes=" + Arrays.toString(lakes)
                + ", province=" + provinces + ", traffic=" + traffic + "]";
    }

}

package com.java8.method.collect;

import com.java8.method.entity.UserInfo;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * Created by lidongliang on 2017/7/12.
 * collect 方法收集器
 * <p>
 * java.util.stream.Collectors -> 有静态方法
 */
public class Collect {

    /**
     * 取得最大
     * max
     *
     * @param userInfos 实体
     * @return UserInfo
     */
    private Optional<UserInfo> biggestGroup(Stream<UserInfo> userInfos) {
//        Function<UserInfo,Integer> getCount = userInfo -> userInfo.getAge();
        Function<UserInfo, Integer> getCount = UserInfo::getAge;
        return userInfos.max(comparing(getCount));
    }

    /**
     * 平均值
     * averaging
     *
     * @param userInfos 实体
     */
    private void average(List<UserInfo> userInfos) {
        Double collect = userInfos.stream().collect(averagingInt(u -> u.getAge()));
//        Double collect = userInfos.stream().collect(averagingInt(UserInfo::getAge));
        System.out.println("average is " + collect);
    }

    /**
     * 数据分块
     * partitioningBy
     *
     * @param userInfos 实体
     * @return 通过字段height分块
     */
    private Map<Boolean, List<UserInfo>> isHeight(Stream<UserInfo> userInfos) {
        return userInfos.collect(partitioningBy(u -> u.getHeight()));
    }

    /**
     * 数据分组
     * groupingBy
     *
     * @param userInfos 实体
     * @return 分组后数据
     */
    private Map<String, List<UserInfo>> groupingByTeam(Stream<UserInfo> userInfos) {
        return userInfos.collect(groupingBy(u -> u.getUserName()));
    }

    /**
     * 拼接
     * joining
     *
     * @param userInfo 实体
     */
    private void joinString(List<UserInfo> userInfo) {
        String result =
                userInfo.stream()
                        .map(UserInfo::getUserName)
                        .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
    }


    /**
     * 下游收集器
     * mapping
     *
     * @param userInfos 实体
     * @return {lidongliang=[1], liyongxuan=[0, 1], lixiaoming=[1, 2]}
     */
    private Map<String, List<Integer>> ageOfSex(Stream<UserInfo> userInfos) {
        return userInfos.collect(groupingBy(UserInfo::getUserName,
                mapping(UserInfo::getSex, toList())));
    }


    public static void main(String[] args) {
        List<UserInfo> userInfos = asList(new UserInfo("lidongliang", 27, 1, true),
                new UserInfo("liyongxuan", 26, 0, true),
                new UserInfo("lixiaoming", 29, 1, false),
                new UserInfo("lixiaoming", 29, 2, false),
                new UserInfo("liyongxuan", 29, 1, false));

        Collect collect01 = new Collect();

//        collect01.average(userInfos);

        Optional<UserInfo> userInfo = collect01.biggestGroup(userInfos.stream());
//        System.out.println(userInfo);

        Map<Boolean, List<UserInfo>> booleanListMap = collect01.isHeight(userInfos.stream());
//        System.out.println(booleanListMap);

        Map<String, List<UserInfo>> stringListMap = collect01.groupingByTeam(userInfos.stream());
        System.out.println(stringListMap);

//        collect01.joinString(userInfos);

        Map<String, List<Integer>> integerListMap = collect01.ageOfSex(userInfos.stream());
//        System.out.println(integerListMap);
    }
}

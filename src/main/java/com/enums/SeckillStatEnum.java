package com.enums;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-12-28 16:02
 */
public enum SeckillStatEnum {

    SUCCESS(1, "秒杀成功"),
    END(0, "秒杀结束"),
    REPEAT_KILL(-1, "秒杀结束");

    private int state;

    private String stateInfo;

    SeckillStatEnum(int state, String stateInfo) {
//        System.out.println(state + " " + stateInfo);
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SeckillStatEnum statOf(int index) {
        for (SeckillStatEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}

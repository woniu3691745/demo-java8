package jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2017-12-28 11:32
 */
public class Province {

    @JsonIgnore
    public String name;

    public int population;
    public String[] city;

}

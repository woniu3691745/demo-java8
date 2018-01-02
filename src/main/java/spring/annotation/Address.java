package spring.annotation;

/**
 * 描述:
 *
 * @author lidongliang
 * @create 2018-01-02 13:43
 */
public class Address {

//    @NotBlank(message = "address name is not null")
    private String addressName;

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
}

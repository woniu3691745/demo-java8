package spring.asyncresttemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * ${DESCRIPTION}
 *
 * @author lidongliang
 * @create 2018-01-01 下午3:28
 **/
public class Main {

    public static void main(String[] args) {

//        Main.Async();
        Main.Sync();
        System.out.println("=== no wait");
    }

    /**
     * 异步
     */
    private static void Async() {
        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
        ListenableFuture<ResponseEntity<User>> future =
                asyncRestTemplate.getForEntity("http://localhost:8080/api", User.class);

        future.addCallback(new ListenableFutureCallback<ResponseEntity<User>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("==== client failure : " + ex);
            }

            @Override
            public void onSuccess(ResponseEntity<User> result) {
                System.out.println("==== client get result : " + result.getBody().getName());
            }
        });
    }

    /**
     * 同步
     */
    private static void Sync() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<User> forEntity = template.getForEntity("http://localhost:8080/user", User.class);
        System.out.println("====== sync " + forEntity.getBody().getDate());

    }
}

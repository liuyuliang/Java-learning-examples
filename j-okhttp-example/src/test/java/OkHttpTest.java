import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * ClassName: OkHttpTest
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/6 18:00
 */
public class OkHttpTest {
    //todo 未完成
    @Test
    public void get() throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://www.jianshu.com/users/recommended").newBuilder();
        urlBuilder.addQueryParameter("count", "5");
        urlBuilder.addQueryParameter("only_unfollowed", "true");
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
        response.body().close();
    }

}

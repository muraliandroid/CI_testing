package murali.myapplication.rest_api_work;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by shyleenrodrigues on 1/12/17.
 */

public interface APIInterface {

    // POST Samples API Interface methods
    // @Field annotation can be used only with @FormUrlEncoded

    /**
     * The createNewUser methods need User name and job to create a new user.
     *
     * @param userName
     * @param userJob
     * @return
     */
    @FormUrlEncoded
    @POST("/api/users")
    Call<PostFieldNewUserResponse> createNewUser(@Field("name") String userName, @Field("job") String userJob);
}

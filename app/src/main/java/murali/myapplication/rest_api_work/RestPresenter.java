package murali.myapplication.rest_api_work;

import android.content.Context;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shyleenrodrigues on 1/2/18.
 */

public class RestPresenter {

    private final Context context;
    private final RestCallBackListener mListener;
    APIInterface mRetrofitAPIInterface;
    public int responseCode;

    public interface RestCallBackListener {
        public void showLoading();

        public void dismissLoading();

        public void callBackResult(boolean responseStatus, int responseCode);

        public void callBackFailure();
    }

    public RestPresenter(Context context, RestCallBackListener mListener) {
        this.context = context;
        this.mListener = mListener;
        mRetrofitAPIInterface = APIClient.getRetrofitClient(context).create(APIInterface.class);
    }

    public void addNewEmployee(String empName, String empJob) {
/*        if (mListener != null)
            Log.d("*RestPresenter", "mListener is not null");
        else
            Log.d("*RestPresenter", "mListener is null");*/

        //mListener.showLoading();
        Call<PostFieldNewUserResponse> apiClient = mRetrofitAPIInterface.createNewUser(empName, empJob);
        apiClient.enqueue(new Callback<PostFieldNewUserResponse>() {
            @Override
            public void onResponse(Call<PostFieldNewUserResponse> call, Response<PostFieldNewUserResponse> response) {
                responseCode = response.code();
                mListener.callBackResult(response.isSuccessful(), response.code());
            }

            @Override
            public void onFailure(Call<PostFieldNewUserResponse> call, Throwable t) {
                mListener.callBackFailure();
            }
        });
        //mListener.dismissLoading();
    }
}

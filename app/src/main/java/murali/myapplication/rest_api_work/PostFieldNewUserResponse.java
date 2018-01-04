package murali.myapplication.rest_api_work;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shyleenrodrigues on 1/2/18.
 */

public class PostFieldNewUserResponse {

    @SerializedName("name")
    String mName;
    @SerializedName("job")
    String mJob;
    @SerializedName("id")
    String mId;
    @SerializedName("createdAt")
    String mCreatedAt;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmJob() {
        return mJob;
    }

    public void setmJob(String mJob) {
        this.mJob = mJob;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmCreatedAt() {
        return mCreatedAt;
    }

    public void setmCreatedAt(String mCreatedAt) {
        this.mCreatedAt = mCreatedAt;
    }
}
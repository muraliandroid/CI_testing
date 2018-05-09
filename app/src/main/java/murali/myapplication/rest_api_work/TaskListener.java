package murali.myapplication.rest_api_work;

/**
 * Created by shyleenrodrigues on 2/6/18.
 */

public interface TaskListener {

    public void taskStarted();

    public void taskInBackground();

    public void taskCompleted();
}

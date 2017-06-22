package androidjavapush.androidjavapush1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.microsoft.azure.mobile.MobileCenter;
import com.microsoft.azure.mobile.analytics.Analytics;
import com.microsoft.azure.mobile.crashes.Crashes;
import com.microsoft.azure.mobile.push.Push;
import com.microsoft.azure.mobile.push.PushListener;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Crashes.generateTestCrash();
        Push.setListener(new MyPushListener());
        MobileCenter.start(getApplication(), "9a405430-103d-4633-b13d-8bf2be4ad6a2",
                Analytics.class, Crashes.class, Push.class);

        setContentView(R.layout.activity_main);

        super.onCreate(savedInstanceState);

    }

    public void sentCrashMessage(View view){
        Crashes.generateTestCrash();
    }
}

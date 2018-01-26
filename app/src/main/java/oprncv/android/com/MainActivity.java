package oprncv.android.com;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;

public class MainActivity extends AppCompatActivity {

    @Nullable
    private BaseLoaderCallback callback;

    @NonNull
    private final OpenCvInitializer openCvInitializer = new OpenCvInitializer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openCvInitializer.initOpenCV(this, getCallback(this));
    }

    @NonNull
    private BaseLoaderCallback getCallback(@NonNull Context context) {
        if (callback == null) {
            callback = new BaseLoaderCallback(context) {
                @Override
                public void onManagerConnected(int status) {
                    switch (status) {
                        case LoaderCallbackInterface.SUCCESS: {
                            Log.d("OpenCvInitializer", "OpenCV loaded successfully");
                        }
                        break;
                        default: {
                            super.onManagerConnected(status);
                        }
                        break;
                    }
                }
            };
        }
        return callback;
    }
}

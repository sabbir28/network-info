import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NetworkTypeDetector detector = new NetworkTypeDetector(this);
        NetworkTypeDetector.NetworkDetails details = detector.getNetworkDetails();

        System.out.println(details);
    }
}

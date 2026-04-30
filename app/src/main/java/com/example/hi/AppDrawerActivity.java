import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class AppDrawerActivity extends AppCompatActivity {

    private ListView listView;
    private PackageManager packageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_drawer);

        listView = findViewById(R.id.app_list_view);
        packageManager = getPackageManager();

        loadInstalledApplications();
    }

    private void loadInstalledApplications() {
        List<ApplicationInfo> apps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        List<String> appNames = new ArrayList<>();

        for (ApplicationInfo appInfo : apps) {
            String appName = appInfo.loadLabel(packageManager).toString();
            appNames.add(appName);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, appNames);
        listView.setAdapter(adapter);
    }
}
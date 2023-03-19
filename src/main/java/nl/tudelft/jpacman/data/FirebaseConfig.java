package nl.tudelft.jpacman.data;
import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseConfig {
    public static void init() throws Exception {
        // Path to your service account key file
        String path = "./data/database/FirebaseKey.json";

        // Initialize Firebase with your service account credentials
        FileInputStream serviceAccount = new FileInputStream(path);
        FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build();
        FirebaseApp.initializeApp(options);

//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

}

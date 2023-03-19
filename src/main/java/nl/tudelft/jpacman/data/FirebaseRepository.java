package nl.tudelft.jpacman.data;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;

import java.util.Map;

public class FirebaseRepository {
    public static boolean canConnect() {
        try {
            FirebaseConfig.init();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public static void write(Score score) throws Exception {
        Firestore db = FirestoreClient.getFirestore();

        Map<String, Object> data = score.toMap();

        CollectionReference scoresRef = db.collection("scores");
        ApiFuture<DocumentReference> future = scoresRef.add(data);

        String documentId = future.get().getId();
        System.out.println("New document ID: " + documentId);
    }

}

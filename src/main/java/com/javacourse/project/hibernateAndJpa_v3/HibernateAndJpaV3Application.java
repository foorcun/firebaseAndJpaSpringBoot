package com.javacourse.project.hibernateAndJpa_v3;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class HibernateAndJpaV3Application {

	public static void main(String[] args) throws IOException {



//		ClassLoader classLoader = CRUDRunner
		ClassLoader classLoader = HibernateAndJpaV3Application.class.getClassLoader();


		File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
		FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());



//		FileInputStream serviceAccount =
//				new FileInputStream("path/to/serviceAccountKey.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://js-test-e5720.firebaseio.com")
				.build();

		FirebaseApp firebaseApp = null;
		List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
		if(firebaseApps!=null && !firebaseApps.isEmpty()){
			for(FirebaseApp app : firebaseApps){
				if(app.getName().equals(FirebaseApp.DEFAULT_APP_NAME)){
					firebaseApp =app;
				}
			}
		}else
			FirebaseApp.initializeApp(options);


		SpringApplication.run(HibernateAndJpaV3Application.class, args);
	}

}

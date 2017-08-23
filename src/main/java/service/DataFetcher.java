package service;

/**
 * Created by cataraucorina on 23/08/2017.
 */
import model.Contact;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cataraucorina on 23/08/2017.
 */
@Component
public class DataFetcher {
    private ArrayList<Contact> contacts;

    public List<Contact> getContacts(){
        ArrayList<Contact> phoneBook=new ArrayList<Contact>();
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://www.mocky.io/v2/581335f71000004204abaf83")
                    .get()
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "d67b42fd-d1bb-af50-eaba-023b52bc3fc8")
                    .build();
            Response response = client.newCall(request).execute();
            String jsonData = response.body().string();
            JSONObject object  = new JSONObject(jsonData);
            JSONArray contacts=object.getJSONArray("contacts");
            for(int i=0;i<contacts.length();i++) {
                Contact contact=new Contact(contacts.getJSONObject(i));
                phoneBook.add(contact);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return phoneBook;
    }

}


package FileHandler;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.XML;

import Animation.Animation;

public class AssetsManager {
    
    public Map<String, Animation> m_animationMap = new HashMap<>();
    
    public AssetsManager(){}

    public void loadFromFile(String file)
    {
        try {
             // Creates a FileInputStream
            FileInputStream in = new FileInputStream("res/config/Islands.tmx");
            // Creates an InputStreamReader
            InputStreamReader input = new InputStreamReader(in);
            // InputStream in = getClass().getResourceAsStream(file);
            // JSONObject jo = new JSONObject(new JSONTokener(input)); 
            JSONObject jo = XML.toJSONObject(input); 

            // JSONArray objs = jo.getJSONArray("OBJ");
            // for(int i = 0; i < objs.length(); i++)
            // {
            //     System.out.println(objs.getJSONObject(i).getString("name"));
            // }
            // System.out.println(jo);
            // System.out.println(jo.getJSONObject("map").getJSONArray("layer").length());
            System.out.println(jo.getJSONObject("map").getJSONArray("layer").getJSONObject(0).getJSONObject("data").getString("content"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }


    public void addAnimation(String name, String texFilePath, int frameCount, int duration, int w, int h)
    {
        Animation anim = new Animation(name, texFilePath, frameCount, duration, w, h);
        m_animationMap.put(name, anim); 
    }
}

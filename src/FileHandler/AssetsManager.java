package FileHandler;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.Texture;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import Animation.Animation;

public class AssetsManager {
    
    public Map<String, Animation> m_animationMap = new HashMap<>();
    public Map<String, Texture> m_textureMap = new HashMap<>();
    public AssetsManager(){}

    public void loadFromFile(String file)
    {
        try {
             // Creates a FileInputStream
            FileInputStream in = new FileInputStream(file);
            // Creates an InputStreamReader
            InputStreamReader input = new InputStreamReader(in);
            // InputStream in = getClass().getResourceAsStream(file);
            // JSONObject jo = new JSONObject(new JSONTokener(input)); 
            JSONObject jo = new JSONObject(new JSONTokener(input));

            // JSONArray objs = jo.getJSONArray("OBJ");
            // for(int i = 0; i < objs.length(); i++)
            // {
            //     System.out.println(objs.getJSONObject(i).getString("name"));
            // }
            // System.out.println(jo);
            // System.out.println(jo.getJSONObject("map").getJSONArray("layer").length());
            //System.out.println(jo.getJSONObject("map").getJSONArray("layer").getJSONObject(0).getJSONObject("data").getString("content"));
            System.out.println(jo);
            
            // Spritesheets
            JSONArray spritesheets = jo.getJSONArray("spritesheets");
            for(int i = 0; i < spritesheets.length(); i++)
            {
                JSONObject tex = spritesheets.getJSONObject(i);
                String name = tex.getString("name");
                String path = tex.getString("path");
                int posX    = tex.getInt("posX");
                int posY    = tex.getInt("posY");
                int width   = tex.getInt("width");
                int height  = tex.getInt("height"); 

                addTexture(name, path, posX, posY, width, height);
            }


            //Animation
            JSONArray animations = jo.getJSONArray("animations");
            for(int i = 0; i < animations.length(); i++)
            {
                JSONObject anim = animations.getJSONObject(i);

                String name     = anim.getString("name");
                String sprite   = anim.getString("sprite");
                int frameCount  = anim.getInt("frameCount");
                int duration    = anim.getInt("duration");

                addAnimation(name, sprite, frameCount, duration);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }

    public void addAnimation(String name, String texName, int frameCount, int duration)
    {
        Animation anim = new Animation(name, getTexture(texName), frameCount, duration);
        m_animationMap.put(name, anim); 
        System.out.println("Animation " + name);
    }

    public void addTexture(String name, String filePath, int posX, int posY, int width, int height)
    {
        System.out.println("Spritesheet " + name + " " + filePath);
        Texture texture = new Texture();
        try {
            texture.loadFromFile(Paths.get(filePath), new IntRect(posX, posY, width, height));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        m_textureMap.put(name, texture);
    }


    public Texture getTexture(String name)
    {
        return m_textureMap.get(name);
    }

    public Animation getAnimation(String name)
    {
        return m_animationMap.get(name);
    }
}

import java.util.HashMap;
public class Codec {

    private HashMap <Integer, String> map = new HashMap<>();
    private int id = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        map.put(id, longUrl);
        String shortUrl = "https://tinyurl.com/"+id;
        id++;
        return shortUrl;        
    }
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        int lastSlashIndex = shortUrl.lastIndexOf('/');
        String idString = shortUrl.substring(lastSlashIndex + 1);
        int key = Integer.parseInt(idString);
        return map.get(key);        
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
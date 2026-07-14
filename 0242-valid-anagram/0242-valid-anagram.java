import java.util.HashMap;
import java.util.Map;
class Solution {
    public boolean isAnagram(String s, String t){

        if(s.length() != t.length())
            return false;

        Map <Character,Integer> frequencyMap = new HashMap<>();

        for(char ch : s.toCharArray()){
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch,0)+1);
        }

        for(char ch : t.toCharArray()){

            int currentFrequency = frequencyMap.getOrDefault(ch,0);

            if(currentFrequency == 0)
                return false;
            
            frequencyMap.put(ch, currentFrequency - 1);
        }
        return true;
    }
}
        
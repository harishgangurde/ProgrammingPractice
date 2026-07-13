class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        
        Map<String,List<String>> stringAnagramsMap = new HashMap<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            if(!stringAnagramsMap.containsKey(key))
                stringAnagramsMap.put(key, new ArrayList<>());
            
            stringAnagramsMap.get(key).add(s);
        }

        List<List<String>> resultList = new ArrayList<>();
        for(Map.Entry<String, List<String>> stringAnagrams : stringAnagramsMap.entrySet()){
            resultList.add(stringAnagrams.getValue());
        }
        return resultList;
    }

    public List<List<String>> groupAnagramsCategorizeFrequency(String[] strs){
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> frequencyStringMap = new HashMap<>();
        for(String str : strs){
            String frequencyString = getFrequencyString(str);

            if(frequencyStringMap.containsKey(frequencyString)){
                frequencyStringMap.get(frequencyString).add(str);
            } else{
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequencyStringMap.put(frequencyString, strList);
            }
        }
        return new ArrayList<>(frequencyStringMap.values());
    }
    private String getFrequencyString(String str){
        int[] freq = new int[26];

        for(char c : str.toCharArray()){
            freq[c - 'a']++;
        }
        StringBuilder frequencyString = new StringBuilder("");
        char c = 'a';
        for(int i : freq){
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }
        return frequencyString.toString();
    }
}
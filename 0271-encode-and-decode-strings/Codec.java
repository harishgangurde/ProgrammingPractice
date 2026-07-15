/*
Problem: 271. Encode and Decode Strings

Approach:
- Store each string as: length + '#' + string.
- During decoding, read the length first, then read exactly that many characters.

Time Complexity:
Encode: O(n)
Decode: O(n)

Space Complexity: O(n)
*/

class Solution {

    public String encode(List<String> strs) {

        StringBuilder encoded = new StringBuilder();

        for(String word : strs){

            encoded.append(word.length());
            encoded.append("#");
            encoded.append(word);
        }
        return encoded.toString();

    }

    public List<String> decode(String str) {

        List<String> decoded = new ArrayList<>();

        int i = 0;

        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            String word = str.substring(j+1,j+1+length);
            decoded.add(word);
            i = j+1+length;
        }
        return decoded;

    }
}

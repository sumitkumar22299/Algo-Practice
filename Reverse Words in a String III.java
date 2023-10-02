class Solution {
    public String reverseWords(String s) {
        String output = "";
        for(int i = 0 ; i < s.length() ; i++){
            int counter = 0;
            while(i < s.length() && s.charAt(i) != ' '){
                counter++;
                i++;
            }

            String temp = "";
            for(int j = 1; j <= counter ; j++){
                temp += s.charAt(i-j);
            }
            if(i != s.length()){
                output += temp + " ";
            } else {
                output += temp;
            }
        }
        return output;
    }
}

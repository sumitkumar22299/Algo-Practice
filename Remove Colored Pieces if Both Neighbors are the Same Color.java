class Solution {
    public boolean winnerOfGame(String colors) {
        int countAlice =0;
        int countBob = 0;
        int colorlength = colors.length();
        for(int i =1; i < colors.length() ; i++){
            int length = 1;
            while(i < colors.length() && colors.charAt(i) == colors.charAt(i-1)){
                length++;
                i++;
            }
            if(length >= 3){
                if(colors.charAt(i-1) == 'A'){
                    countAlice += length-2;
                } else if (colors.charAt(i-1) == 'B'){
                    countBob += length-2;
                }
            }
            // i++;
        }
        if(countAlice == countBob){
            return false;
        }
        return (countAlice > countBob) ? true : false ;
    }
}
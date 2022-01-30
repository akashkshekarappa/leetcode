//Approach
//Count the number of capital letter and check if all letters are uppercase / or lowercase -> count equals word-length or count == 0. only first letter is uppercase -> count is 1 and 0th character uppercase
class Solution {
    public boolean detectCapitalUse(String word) {
        int countOfCapitalLetters = 0;
        for(char c: word.toCharArray()){
            if(Character.isUpperCase(c))
                countOfCapitalLetters++;
        }
        // case 1 and case 2
        if(countOfCapitalLetters == word.length() || countOfCapitalLetters == 0)
            return true;
        //case3
        else if(countOfCapitalLetters == 1 && Character.isUpperCase(word.charAt(0)))
            return true;
        
        return false;
    }
}
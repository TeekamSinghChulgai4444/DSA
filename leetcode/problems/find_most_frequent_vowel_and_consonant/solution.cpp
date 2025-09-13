class Solution {
public:
    int maxFreqSum(string s) {
        int vowel[5] = {0};  // a, e, i, o, u
        int consonant[26] = {0};
        
        for(char ch : s){
            if(ch == 'a') vowel[0]++;
            else if(ch == 'e') vowel[1]++;
            else if(ch == 'i') vowel[2]++;
            else if(ch == 'o') vowel[3]++;
            else if(ch == 'u') vowel[4]++;
            else consonant[ch - 'a']++;
        }
        
        int maxVowel = max({vowel[0], vowel[1], vowel[2], vowel[3], vowel[4]});
        int maxConsonant = 0;
        
        for(int i = 0; i < 26; i++){
            if(i != ('a'-'a') && i != ('e'-'a') && i != ('i'-'a') && i != ('o'-'a') && i != ('u'-'a')){
                maxConsonant = max(maxConsonant, consonant[i]);
            }
        }
        
        return maxVowel + maxConsonant;
    }
};
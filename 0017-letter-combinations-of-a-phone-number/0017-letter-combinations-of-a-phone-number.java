class Solution {
    // Map digits to letters using an array
    private String[] map = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        
        // Start the recursive process
        backtrack(result, digits, "", 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, String current, int index) {
        // BASE CASE: If the string length matches the input length, we found a combination
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        // Get the letters for the current digit (e.g., if digit is '2', letters = "abc")
        String letters = map[digits.charAt(index) - '0'];

        // Loop through each letter and move to the next digit
        for (char c : letters.toCharArray()) {
            backtrack(result, digits, current + c, index + 1);
        }
    }
}
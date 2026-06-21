class Solution {

    public String encode(List<String> strs) {
        String encodedString = "";
        for (String str : strs){
            encodedString = encodedString + str + "(" + String.valueOf(str.length()) + ")";
        }
        System.out.println(encodedString);
        return encodedString;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < str.length(); i++){
            if (Character.isDigit(str.charAt(i))){
                System.out.println("Entered digit if.");
                int check = i;
                while(check < str.length() && Character.isDigit(str.charAt(check))){
                    System.out.println("Entered while.");
                    check++;
                }
                if (str.charAt(i - 1) == '(' && str.charAt(check) == ')'){
                    System.out.println("Entered if.");
                    result.add(str.substring(start, i-1));
                    start = check + 1;
                    i = check;
                }
                
            }
        }
        return result;
    }
}

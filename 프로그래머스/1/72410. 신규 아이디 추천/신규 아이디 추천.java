class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^-_.a-z0-9]", "");
        new_id = new_id.replaceAll("[.]{2,}", ".");
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        if(new_id.equals("")) new_id = "a";
        if(new_id.length() >= 16) new_id = new_id.substring(0,15).replaceAll("^[.]|[.]$", "");
        while(new_id.length() < 3) new_id += new_id.charAt(new_id.length()-1);
        return new_id;
    }
}
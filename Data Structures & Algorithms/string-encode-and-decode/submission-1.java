class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for(String s: strs)
        {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
        
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        StringBuilder l = new StringBuilder();

        for(int i=0;i<str.length();i++)
        {
            int j=i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            strs.add(str.substring(j + 1, j + len + 1));
            i=j+len;
        }
        return strs;
    }
}

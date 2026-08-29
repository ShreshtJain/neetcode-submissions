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
        StringBuilder sb = new StringBuilder();
        String l="";

        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='#')
            {
                int n = Integer.parseInt(l);

                for(int j=i+1;j<=i+n;j++)
                {
                    sb.append(str.charAt(j));
                }
                System.out.println(sb.toString());
                strs.add(sb.toString());
                sb=new StringBuilder();
                l="";
                i+=n;
            }
            else{
            l+=Character.toString(str.charAt(i));
            }

        }
        return strs;
    }
}

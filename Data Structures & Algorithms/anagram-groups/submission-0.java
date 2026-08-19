class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        List<List<String>> list = new ArrayList<>();

        for(String s: strs)
        {
            int n=s.length();
            int[] arr=new int[26];
            
            for(int i=0;i<n;i++)
            {
                int index = s.charAt(i);
                arr[index-97]++;
            }
            String key = Arrays.toString(arr);
            List<String> temp = map.getOrDefault(key, new ArrayList<>());
            temp.add(s);
            map.put(key, temp);
        }

        for(Map.Entry<String,List<String>> entry:map.entrySet())
        {
            list.add(entry.getValue());
        }
        return list;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Integer order[] = new Integer[n];

        for(int i=0;i<n;i++)
        {
            order[i]=i;
        }

        Arrays.sort(order,(a,b)->position[b]-position[a]);

        double maxTime= Integer.MIN_VALUE;
        int fleets=0;

        for(int i:order)
        {
            double time= (double)(target-position[i])/speed[i];

            if(time>maxTime)
            {
                fleets++;
                maxTime=time;
            }
        }

        return fleets;
    }
}

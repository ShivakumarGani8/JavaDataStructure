class FirstAndLast{
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        System.out.println(searchRange(nums,8));
    }
    
        public static int[] searchRange(int[] nums, int target) {
            int[] positions={-1,-1};
            int start=0, end=nums.length-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(nums[mid]==target){
                    int first=mid, last=mid;
                    while(first>0 && nums[first]==target){
                        first--;
                    }
                    while( last<nums.length && nums[last]==target)
                        last++;

                    positions[0]=first+1;
                    positions[1]=last-1;
                    return positions;
                }
                if(nums[mid]<target)
                    start= mid+1;
                else
                    end= mid-1; 
            }
            return positions;
        }
    
}
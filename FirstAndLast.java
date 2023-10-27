class FirstAndLast{
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        System.out.println(searchRange(nums,8));
    }
    
    //In this approch we'll use binary search
        public static int[] searchRange(int[] nums, int target) {
            int[] positions={-1,-1};
            int start=0, end=nums.length-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(nums[mid]==target){ //Once if we find target.
                    int first=mid, last=mid;
                    int index=mid;

                    //Looping until the first element is equal to target
                    while(first>=0 && nums[first]==target){
                        index=first;
                        first--;
                    }
                    positions[0]=index; //Once != target add last index that matches condition.
                    index=mid;

                    //Looping until the last element is equal to target
                    while( last<nums.length && nums[last]==target){
                        index=last;
                        last++;
                    }
                    positions[1]=index; //Once != target add last index that matches condition.
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
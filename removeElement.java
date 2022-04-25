/******************************************************************************

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

https://leetcode.com/problems/remove-element/

*******************************************************************************/

public class Main
{
	public static void main(String[] args) {
	    int[] nums1 = {3,2,2,3};
		  System.out.println(removeElement(nums1,3));
	}
	
	public static int removeElement(int[] nums, int val) {
	    int returnVal = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                returnVal++;
                continue;
            } else{
                int pos = swapPosition(nums,i,val);
                
                if(pos==nums.length-1){
                    returnVal=i+1;
                    break;
                } else if(pos == -1){
                    return i;
                } else{
                    nums[i]=nums[pos];
                    nums[pos]=val;
                }
            }
            
        }
        return returnVal;
    }
    
    public static int swapPosition(int nums[], int i, int val){
        int ret=-1;
        for(int k=i+1;k<nums.length;k++){
            if(nums[k]!=val){
                return k;
            }
        }
        return ret;
    }
}
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

/**
 *
 * @author Bryce
 */
public class findMedianSortedArrays_004 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int len = len1 + len2;
            int p=0, q=0;
            for(int i=0; i<(len-1)/2; i++){
                int n1 = p==len1 ? Integer.MAX_VALUE: nums1[p];
                int n2 = q==len2 ? Integer.MAX_VALUE: nums2[q];
                if(n1<n2)   p++;
                else q++;
            }
            
            double res = 0;
            for(int i=1; i<=1+(len-1)%2; i++){
                int n1 = p==len1 ? Integer.MAX_VALUE: nums1[p];
                int n2 = q==len2 ? Integer.MAX_VALUE: nums2[q];
                if(n1<n2){
                    p++;
                    res = (res + (double)n1)/(double) i;
                }
                else{
                    q++;
                    res = (res + (double)n2)/(double) i;
                }
            }
            return res;
        }
    }
}

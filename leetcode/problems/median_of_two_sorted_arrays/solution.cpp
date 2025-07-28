class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        vector<int>merge;
        int i,j,n,m;
        n=nums1.size();
        m=nums2.size();
        i=0;
        j=0;
        while(i<n && j<m){
           

             if(nums1[i]>=nums2[j]){
                     merge.push_back(nums2[j]);
                     j++;
            }
            else{
                merge.push_back(nums1[i]);
                i++;
            }
        }
        while(i<n){
            merge.push_back(nums1[i]);
            i++;
        }

        while(j<m){
            merge.push_back(nums2[j]);
            j++;
        }

        int size=merge.size();

        cout<<"size of merge : : "<<merge.size()<<endl;
        cout<<"merge vector  : : ";


        for(int i:merge){
            cout<<i<<" ";
        }

        cout<<endl;

        if(size %2==0){
            double median=(merge[size/2]+merge[size/2-1])/2.0;
            return median;
        } else{
            double median=merge[size/2];
            return median;
        }
       
    }
};

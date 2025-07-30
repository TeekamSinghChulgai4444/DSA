class Solution {
public:
    void merge(vector<int>& nums, int ft, int mid, int end) {
        vector<int> temp;
        int i = ft;
        int j = mid + 1;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp.push_back(nums[i]);
                i++;
            } else {
                temp.push_back(nums[j]);
                j++;
            }
        }

        while (i <= mid) {
            temp.push_back(nums[i++]);
        }
        while (j <= end) {
            temp.push_back(nums[j++]);
        }

        for (int k = 0; k < temp.size(); k++) {
            nums[ft + k] = temp[k];
        }
    }

    void mergeSort(vector<int>& nums, int ft, int end) {
        if (ft < end) {
            int mid = ft + (end - ft) / 2;
            mergeSort(nums, ft, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, ft, mid, end);
        }
    }

    vector<int> sortArray(vector<int>& nums) {
        mergeSort(nums, 0, nums.size() - 1);
        return nums;
    }
};
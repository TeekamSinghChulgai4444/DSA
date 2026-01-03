class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> answer;
        if (root == NULL) return answer;

        queue<TreeNode*> st;         
        st.push(root);
        st.push(NULL);

        bool flag = true;             
        vector<int> temp;

        while (!st.empty()) {
            TreeNode* curr = st.front();  
            st.pop();

            if (curr == NULL) {
                
                if (flag == false) {
                    reverse(temp.begin(), temp.end());
                }

                answer.push_back(temp);
                temp.clear();           
                flag = !flag;

                if (!st.empty()) {
                    st.push(NULL);
                }
            }
            else {
                temp.push_back(curr->val); 

                if (curr->left != NULL)
                    st.push(curr->left);

                if (curr->right != NULL)
                    st.push(curr->right);
            }
        }

        return answer;
    }
};

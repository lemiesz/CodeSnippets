#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;


#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;


class Solution {
public:
    int orderOfLargestPlusSign(int N, vector<vector<int> >& mines) {
        unordered_set<int>* banned = new unordered_set<int>();
        int dp[N][N];
        for(vector<vector<int> >::iterator it = mines.begin(); it != mines.end(); ++it) {
            vector<int> v1 = *it;
            banned->insert(v1[0] * N + v1[1]);
        }

        int count = 0;
        int ans = 0;
        for(int i = 0; i<N; i++) {
            count = 0;
            for(int j = 0; j < N; j++) {
                count = banned->find(i * N + j) != banned->end() ? 0 : count + 1;
                dp[i][j] = count;
            }

            count = 0;
            for(int j = N - 1; j >= 0; j--) {
                count = banned->find(i * N + j) != banned->end() ? 0 : count + 1;
                dp[i][j] = min(dp[i][j], count);
            }
        }

        for(int j = 0; j<N; j++) {
            count = 0;
            for(int i = 0; i < N; i++) {
                count = banned->find(i * N + j) != banned->end() ? 0 : count + 1;
                dp[i][j] = min(dp[i][j], count);
            }
            count = 0;
            for(int i = N - 1; i >= 0; i--) {
                count = banned->find(i * N + j) != banned->end() ? 0 : count + 1;
                dp[i][j] = min(dp[i][j], count);

                ans = max(ans, dp[i][j]);
            }
        }
        delete banned;
        return ans;
    }
};


int main() {
    cout<<"Hello2\n";
    Solution* sol = new Solution();
    vector<vector<int> >* mines = new vector<vector<int> >();;
    vector<int> v1;
    v1.push_back(4);
    v1.push_back(2);
    mines->push_back(v1);
    cout<<sol->orderOfLargestPlusSign(20, *mines);
    return 0;
}

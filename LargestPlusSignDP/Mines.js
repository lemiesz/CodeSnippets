var orderOfLargestPlusSign = (N, mines) => {
    if(N === 0) {
        return 0;
    }

    var banned = new Set();
    mines.map(item => {
        banned.add(item[0] * N + item[1]);
    });
    var dp = Array(N).fill(null).map(item => Array(N).fill(null));

    var count, ans = 0;

    for(var i = 0; i < N; i++) {
        count = 0;
        
        for(var j = 0; j<N; j++) {
            count = banned.has(i * N + j) ? 0 : count + 1;
            dp[i][j] = count;
        }

        count = 0;
        for(var j = N - 1; j >= 0; j--) {
            count = banned.has(i * N + j) ? 0 : count + 1;
            dp[i][j] = Math.min(dp[i][j], count);
        }     
    }

    for(var j = 0; j<N; j++) {
        count = 0;
        for(var i = 0; i<N; i++) {
            count = banned.has(i * N + j) ? 0 : count + 1;
            dp[i][j] = Math.min(dp[i][j], count);
        }

        count = 0;
        for(var i = N - 1; i >= 0; i--) {
            count = banned.has(i * N + j) ? 0 : count + 1;
            dp[i][j] = Math.min(dp[i][j], count);

            ans = Math.max(ans, dp[i][j]);
        }
    }
    return ans;
}

console.log(orderOfLargestPlusSign(10, []));
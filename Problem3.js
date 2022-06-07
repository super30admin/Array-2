/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
 const initialize2DArray = (n, m) => {
    let d = [];
    for (let i = 0; i < n; i++) {
        let t = Array(m).fill(0); d.push(t);
    }
    return d;
};

const gameOfLife = (g) => {
    let n = g.length; 
    let m = g[0].length;
    let res = initialize2DArray(n,m);
    
	for (let i = 0; i < n; i++) {
	    for (let j = 0; j < m; j++) {
	        let one = 0; // count live for 8 neighbours
            if (i + 1 < n && g[i + 1][j]) one++;
            if (i - 1 >= 0 && g[i - 1][j]) one++;
            if (j + 1 < m && g[i][j + 1])  one++;
            if (j - 1 >= 0 && g[i][j - 1]) one++;
            if (i + 1 < n && j + 1 < m && g[i + 1][j + 1]) one++;
            if (i - 1 >= 0 && j + 1 < m && g[i - 1][j + 1]) one++;
            if (i + 1 < n && j - 1 >= 0 && g[i + 1][j - 1])  one++;
            if (i - 1 >= 0 && j - 1 >= 0 && g[i - 1][j - 1] ) one++;
            if (g[i][j]) {
                res[i][j] = one === 2 || one === 3 ? 1 : 0;
            } else {
                res[i][j] = one == 3 ? 1 : 0;
            }
        }
    }
	// in-place
	for (let i = 0; i < n; i++) 
	    for (let j = 0; j < m; j++) g[i][j] = res[i][j];
};
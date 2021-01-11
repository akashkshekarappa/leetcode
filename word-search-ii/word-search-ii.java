            currNode.word = null;
        }
        // mark the current letter before the EXPLORATION
        _board[r][c] = '#';
        int[][] dirs = {{0,1},{0,-1},{1,0}, {-1,0}};
        for(int[] dir: dirs){
            int row = dir[0] + r;
            int col = dir[1] + c;
            
        if(row < 0 || row >= _board.length || col < 0 || col >= _board[0].length)
            continue;
        //recurse
        if(currNode.map.containsKey(_board[row][col]))
            backtrack(row, col, currNode);
        }
        //backtrack
         // End of EXPLORATION, restore the original letter in the board.
        _board[r][c] = letter;
         // Optimization: incrementally remove the leaf nodes
        if(currNode.map.isEmpty()){
            root.map.remove(letter);
        }
        
    }
}

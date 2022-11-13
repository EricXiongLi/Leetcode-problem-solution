# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minimumOperations(self, root: Optional[TreeNode]) -> int:

        #   original    7 6 5 4 {7:0 6:1 5:2 4:3}
#               4 6 5 7 {7:3 6:1 5:2 4:0}
#               in O(n) swaps
#               O(nlogn) 
#   target      4 5 6 7

        # //BFS by level
        def countSwaps(level):
            level=[node.val for node in level]
            swaps=0
            sorted_level=sorted(level)
            hashmap={level[idx]:idx for idx in range(len(level))}
            for idx in range(len(level)):
                correct_value=sorted_level[idx]
                unsorted_idx=hashmap[correct_value]
                if unsorted_idx!=idx:
                    actual_value=level[idx]
                    level[unsorted_idx],level[idx]= level[idx],level[unsorted_idx]
                    hashmap[correct_value]=idx
                    hashmap[actual_value]=unsorted_idx
                    swaps+=1
            return swaps

        curr_level=[root]
        swaps=0
        while curr_level:
            new_level=[]
            for node in curr_level:
                if node.left:
                    new_level.append(node.left)
                if node.right:
                    new_level.append(node.right)
            swaps+=countSwaps(new_level)
            curr_level=new_level
        return swaps





        

       

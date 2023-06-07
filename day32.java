class Solution {
    int cnt = 0;
  
    public ListNode swapPairs(ListNode node) {
      if (node == null) return null;
  
      cnt++;
      var ret = swapPairs(node.next);
  
      if (cnt % 2 == 1 && ret != null) {
        
        node.next = ret.next;
        ret.next = node;
      } else {
        
        node.next = ret;
        ret = node;
      }
      cnt--;
      return ret;
    }
  }
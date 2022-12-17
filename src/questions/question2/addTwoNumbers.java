package questions.question2;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      public ListNode addListNode(int n){
          ListNode ln = new ListNode(n);
          ListNode temp = ln;
          ln.next = this;
          return ln;
      }
  }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln = new ListNode(0);
        ListNode m = ln ,p=l1,q=l2;

        int carry = 0;
        while(p!=null||q!=null){
            int x = (p!=null)?p.val:0;
            int y = (q!=null)?q.val:0;
            int sum = x + y + carry;
            carry = sum/10;
            m.next = new ListNode(sum%10);
            m = m.next;
            if(q!=null)q=q.next;
            if(p!=null)p=p.next;
        }
        if(carry>0){
            m.next = new ListNode(carry);
            m=m.next;
        }
        return ln.next;
    }

}

public class addTwoNumbers {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode l1 = new ListNode(3);
        l1 = l1.addListNode(4);
        l1 = l1.addListNode(2);
        ListNode l2 = new ListNode(4);
        l2 = l2.addListNode(6);
        l2 = l2.addListNode(5);

//        while(l1!=null){
//            System.out.print(l1.val);
//            l1=l1.next;
//        }
//        while(l2!=null){
//            System.out.print(l2.val);
//            l2=l2.next;
//        }
        ListNode ll = sol.addTwoNumbers(l1,l2);
        while(ll!=null){
            System.out.print(ll.val);
            ll=ll.next;
        }



    }
}

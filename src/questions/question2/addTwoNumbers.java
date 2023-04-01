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
      ListNode() {}
      ListNode(int x) { val = x; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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

    /**
     * 2023/3/25写
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode resultHead = null;
        ListNode tail = null;
        //进位初始化为0
        int carry = 0;
        //只要下一位还有值就继续循环，进位>0也可以看作下一位有值
        while(l1!=null||l2!=null||carry>0) {
            //如果当前节点为空则val按0算
            int a = 0;
            int b = 0;
            if(l1!=null) {
                a = l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                b = l2.val;
                l2 = l2.next;
            }
            //是否有进位
            int val = a+b+carry;
            if(val>=10) {
                val = val - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            //生成结果listNode
            //头节点为null此时相当于初始化，尾节点便于插入
            if(resultHead == null) {
                resultHead = new ListNode(val,null);
                tail = resultHead;
            } else {
                ListNode p = new ListNode(val,null);
                tail.next = p;
                tail = p;
            }
        }
        return resultHead;
    }

    /**
     * 复制的
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return root.next;
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
        l1 = null;
        l2 = null;
//        while(l1!=null){
//            System.out.print(l1.val);
//            l1=l1.next;
//        }
//        while(l2!=null){
//            System.out.print(l2.val);
//            l2=l2.next;
//        }
        ListNode ll = sol.addTwoNumbers3(l1,l2);
        while(ll!=null){
            System.out.print(ll.val);
            ll=ll.next;
        }



    }
}

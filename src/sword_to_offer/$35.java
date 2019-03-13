package sword_to_offer;

/**
 * Created by Yang Liu on 2019/3/7
 */

// 复制复杂的链表
public class $35 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        cloneNodes(pHead);
        connectSiblingNodes(pHead);
        return reconnectNodes(pHead);
    }

    private void cloneNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pCloned = new RandomListNode(-1);
            pCloned.label = pNode.label;
            pCloned.next = pNode.next;
            pCloned.random = null;

            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }

    private void connectSiblingNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pCloned = pNode.next;
            if (pNode.random != null) {
                pCloned.random = pNode.random.next;
            }
            pNode = pCloned.next;
        }
    }

    private RandomListNode reconnectNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pClonedNode = null;
        if (pNode != null) {
            pClonedHead = pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }

        while (pNode != null) {
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }

        return pClonedHead;
    }
}
